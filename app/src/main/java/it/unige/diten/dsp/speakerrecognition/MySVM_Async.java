package it.unige.diten.dsp.speakerrecognition;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import it.unige.diten.dsp.speakerrecognition.libsvm.svm;
import it.unige.diten.dsp.speakerrecognition.libsvm.svm_model;
import it.unige.diten.dsp.speakerrecognition.libsvm.svm_node;

public class MySVM_Async extends AsyncTask<Void, Void, Void>
{
    private static svm_model model = null;
    public static final String TAG = "MySVM_Async";

    private static ProgressDialog cProgressRecorder;
    private static Context cContext;

    private static boolean initialized = false;
    private static double[] y_min;
    private static double[] y_max;

    private static void initialize()
    {
        cProgressRecorder.setMessage("Loading SVM model and features range...");
        // TODO correggi 26 con il numero delle feature estratte
        y_min = new double[26];
        y_max = new double[26];
        Log.v(TAG, "fileName: " + MainActivity.MODEL_FILENAME);

        readRange(MainActivity.RANGE_FILENAME);

        Log.v(TAG, "Caricato range.range");

        try
        {
            model = svm.svm_load_model(MainActivity.MODEL_FILENAME);

            Log.v(TAG, "Caricato model.model");
        }
        catch(IOException ew)
        {
            Log.e(TAG, "initialize: " + ew.getMessage());
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();

        cContext = MainActivity.context;

        cProgressRecorder = new ProgressDialog(cContext);
        cProgressRecorder.setIndeterminate(true);
        cProgressRecorder = ProgressDialog.show(cContext, "Recognition", "recognition in progress...");

    }

    @Override
    protected Void doInBackground(Void...params)
    {
        if (!initialized)
        {
            initialize();
            initialized = true;
        }

        cProgressRecorder.setMessage("Building features matrix...");
        // fill features vectors (svm_node[][])
        scaleMatrix(FeatureExtractor.MFCC);
        scaleMatrix(FeatureExtractor.DeltaDelta);
        int frameCount = FeatureExtractor.MFCC.length;
        svm_node[][] features = new svm_node[frameCount][FeatureExtractor.MFCC_COUNT * 2 + 1];


        for (int F = 0; F < frameCount; F++) {
            int C;
            for (C = 0; C < FeatureExtractor.MFCC_COUNT; C++) {
                features[F][C] = new svm_node();
                features[F][C].index = C + 1;
                features[F][C].value =  FeatureExtractor.MFCC[F][C];
            }

            for (; C < FeatureExtractor.MFCC_COUNT * 2; C++) {
                features[F][C] = new svm_node();
                features[F][C].index = C + 1;
                features[F][C].value = FeatureExtractor.DeltaDelta[F][C - FeatureExtractor.MFCC_COUNT];
            }

            features[F][C] = new svm_node();
            features[F][C].index = -1;
            features[F][C].value = 0;

        }

        cProgressRecorder.setMessage("Performing recognition...");
        int[] results = new int[3];
        for(int i=0; i<3; i++)
            results[i] = 0;


        // Multithreaded recognition!
        Runnable[] runnables = new Runnable[MainActivity.numCores];
        Thread[] threads = new Thread[MainActivity.numCores];
        for(int C = 0; C < MainActivity.numCores; C++)
        {
            runnables[C] = new RecognitionThread(C,MainActivity.numCores,features,results,model);
            threads[C] = new Thread(runnables[C]);
            threads[C].start();
        }
        try {
            for (int C = 0; C < MainActivity.numCores; C++)
                threads[C].join();
        }
        catch(Exception ewww)
        {
            // exceptions suck.
        }

        MainActivity.SVMResults  = results;

        Log.i(TAG, "Res(0): " + results[0]);
        Log.i(TAG, "Res(1): " + results[1]);
        Log.i(TAG, "Res(2): " + results[2]);

        // Find the most popular outcome
        int maxV = -1;
        int maxI = -1;
        for(int C = 0; C < 3; C++)
        {
            if(results[C] > maxV)
            {
                maxI = C;
                maxV = results[C];
            }
        }

        RecognitionReceiver.result = maxI;

        Intent intent = new Intent("it.unige.diten.dsp.speakerrecognition.UPDATE_RECOGNITION");
        cContext.sendBroadcast(intent);

        return null;
    }

    private static void scaleMatrix(double[][] input)
    {
        double y_lower = -1;
        double y_upper = 1;

        for(int C = 0; C < input.length; C++)
        {
            for (int J = 0; J < input[0].length; J++)
            {
                input[C][J] = y_lower + (y_upper - y_lower) * (input[C][J] - y_min[J]) / (y_max[J] - y_min[J]);
            }
        }
    }

    private static void readRange(String fileName)
    {
        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(fileName));
            int lineNumber = 1;
            while ((sCurrentLine = br.readLine()) != null)
            {
                Log.v(TAG,"readRange: line read '" + sCurrentLine + "'");
                if(lineNumber >= 3)
                {
                    String[] arr = sCurrentLine.split(" ");
                    y_min[lineNumber - 3] = Double.valueOf(arr[1]);
                    y_max[lineNumber - 3] = Double.valueOf(arr[2]);

                    Log.v(TAG, "y_min[" + (lineNumber - 3) + "] = " + y_min[lineNumber - 3]);
                    Log.v(TAG, "y_max[" + (lineNumber - 3) + "] = " + y_max[lineNumber - 3]);
                }
                lineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    @Override
    protected void onPostExecute(Void cv)
    {
        super.onPostExecute(cv);
        cProgressRecorder.dismiss();
    }
}
