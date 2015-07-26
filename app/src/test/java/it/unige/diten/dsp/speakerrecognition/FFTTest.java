package it.unige.diten.dsp.speakerrecognition;

import junit.framework.Assert;
import junit.framework.TestCase;

public class FFTTest extends TestCase
{
    public static void testFFTOfSin() throws Exception
    {
        int len = 256;

        Complex[] input = new Complex[len];
        for(int C = 0; C < len; C ++)
            input[C] = new Complex(Math.sin((double)C+1.0),.0);



        Complex[] expectation = new Complex[256];
        int k = 0;
        expectation[k++] = new Complex(4.520581e-01,0);
        expectation[k++] = new Complex(4.518907e-01,3.779047e-02);
        expectation[k++] = new Complex(4.513872e-01,7.570705e-02);
        expectation[k++] = new Complex(4.505441e-01,1.138774e-01);
        expectation[k++] = new Complex(4.493550e-01,1.524321e-01);
        expectation[k++] = new Complex(4.478111e-01,1.915068e-01);
        expectation[k++] = new Complex(4.459008e-01,2.312434e-01);
        expectation[k++] = new Complex(4.436094e-01,2.717922e-01);
        expectation[k++] = new Complex(4.409190e-01,3.133144e-01);
        expectation[k++] = new Complex(4.378077e-01,3.559838e-01);
        expectation[k++] = new Complex(4.342499e-01,3.999907e-01);
        expectation[k++] = new Complex(4.302149e-01,4.455444e-01);
        expectation[k++] = new Complex(4.256670e-01,4.928774e-01);
        expectation[k++] = new Complex(4.205638e-01,5.422504e-01);
        expectation[k++] = new Complex(4.148559e-01,5.939577e-01);
        expectation[k++] = new Complex(4.084851e-01,6.483346e-01);
        expectation[k++] = new Complex(4.013830e-01,7.057657e-01);
        expectation[k++] = new Complex(3.934686e-01,7.666962e-01);
        expectation[k++] = new Complex(3.846460e-01,8.316451e-01);
        expectation[k++] = new Complex(3.748008e-01,9.012229e-01);
        expectation[k++] = new Complex(3.637957e-01,9.761539e-01);
        expectation[k++] = new Complex(3.514650e-01,1.057305e+00);
        expectation[k++] = new Complex(3.376068e-01,1.145726e+00);
        expectation[k++] = new Complex(3.219730e-01,1.242697e+00);
        expectation[k++] = new Complex(3.042556e-01,1.349802e+00);
        expectation[k++] = new Complex(2.840677e-01,1.469025e+00);
        expectation[k++] = new Complex(2.609165e-01,1.602882e+00);
        expectation[k++] = new Complex(2.341654e-01,1.754621e+00);
        expectation[k++] = new Complex(2.029773e-01,1.928505e+00);
        expectation[k++] = new Complex(1.662291e-01,2.130243e+00);
        expectation[k++] = new Complex(1.223792e-01,2.367670e+00);
        expectation[k++] = new Complex(6.925212e-02,2.651832e+00);
        expectation[k++] = new Complex(3.676615e-03,2.998824e+00);
        expectation[k++] = new Complex(-7.915751e-02,3.433052e+00);
        expectation[k++] = new Complex(-1.869144e-01,3.993392e+00);
        expectation[k++] = new Complex(-3.325966e-01,4.745793e+00);
        expectation[k++] = new Complex(-5.401716e-01,5.811806e+00);
        expectation[k++] = new Complex(-8.592172e-01,7.442849e+00);
        expectation[k++] = new Complex(-1.411592e+00,1.025688e+01);
        expectation[k++] = new Complex(-2.598701e+00,1.628944e+01);
        expectation[k++] = new Complex(-6.981027e+00,3.852477e+01);
        expectation[k++] = new Complex(2.283626e+01,-1.126667e+02);
        expectation[k++] = new Complex(5.187892e+00,-2.315952e+01);
        expectation[k++] = new Complex(3.183709e+00,-1.298435e+01);
        expectation[k++] = new Complex(2.411000e+00,-9.054181e+00);
        expectation[k++] = new Complex(2.001772e+00,-6.967391e+00);
        expectation[k++] = new Complex(1.748562e+00,-5.671934e+00);
        expectation[k++] = new Complex(1.576551e+00,-4.788391e+00);
        expectation[k++] = new Complex(1.452163e+00,-4.146492e+00);
        expectation[k++] = new Complex(1.358089e+00,-3.658457e+00);
        expectation[k++] = new Complex(1.284500e+00,-3.274438e+00);
        expectation[k++] = new Complex(1.225401e+00,-2.964028e+00);
        expectation[k++] = new Complex(1.176927e+00,-2.707621e+00);
        expectation[k++] = new Complex(1.136475e+00,-2.492013e+00);
        expectation[k++] = new Complex(1.102227e+00,-2.307981e+00);
        expectation[k++] = new Complex(1.072875e+00,-2.148889e+00);
        expectation[k++] = new Complex(1.047456e+00,-2.009841e+00);
        expectation[k++] = new Complex(1.025242e+00,-1.887146e+00);
        expectation[k++] = new Complex(1.005674e+00,-1.777966e+00);
        expectation[k++] = new Complex(9.883160e-01,-1.680086e+00);
        expectation[k++] = new Complex(9.728233e-01,-1.591751e+00);
        expectation[k++] = new Complex(9.589184e-01,-1.511550e+00);
        expectation[k++] = new Complex(9.463764e-01,-1.438339e+00);
        expectation[k++] = new Complex(9.350128e-01,-1.371180e+00);
        expectation[k++] = new Complex(9.246750e-01,-1.309293e+00);
        expectation[k++] = new Complex(9.152355e-01,-1.252030e+00);
        expectation[k++] = new Complex(9.065870e-01,-1.198843e+00);
        expectation[k++] = new Complex(8.986389e-01,-1.149268e+00);
        expectation[k++] = new Complex(8.913135e-01,-1.102908e+00);
        expectation[k++] = new Complex(8.845444e-01,-1.059424e+00);
        expectation[k++] = new Complex(8.782743e-01,-1.018521e+00);
        expectation[k++] = new Complex(8.724534e-01,-9.799443e-01);
        expectation[k++] = new Complex(8.670384e-01,-9.434706e-01);
        expectation[k++] = new Complex(8.619914e-01,-9.089047e-01);
        expectation[k++] = new Complex(8.572790e-01,-8.760744e-01);
        expectation[k++] = new Complex(8.528718e-01,-8.448278e-01);
        expectation[k++] = new Complex(8.487437e-01,-8.150297e-01);
        expectation[k++] = new Complex(8.448716e-01,-7.865599e-01);
        expectation[k++] = new Complex(8.412349e-01,-7.593109e-01);
        expectation[k++] = new Complex(8.378150e-01,-7.331862e-01);
        expectation[k++] = new Complex(8.345954e-01,-7.080991e-01);
        expectation[k++] = new Complex(8.315612e-01,-6.839715e-01);
        expectation[k++] = new Complex(8.286991e-01,-6.607324e-01);
        expectation[k++] = new Complex(8.259967e-01,-6.383178e-01);
        expectation[k++] = new Complex(8.234432e-01,-6.166691e-01);
        expectation[k++] = new Complex(8.210286e-01,-5.957332e-01);
        expectation[k++] = new Complex(8.187437e-01,-5.754613e-01);
        expectation[k++] = new Complex(8.165804e-01,-5.558089e-01);
        expectation[k++] = new Complex(8.145311e-01,-5.367351e-01);
        expectation[k++] = new Complex(8.125888e-01,-5.182023e-01);
        expectation[k++] = new Complex(8.107472e-01,-5.001756e-01);
        expectation[k++] = new Complex(8.090005e-01,-4.826231e-01);
        expectation[k++] = new Complex(8.073434e-01,-4.655151e-01);
        expectation[k++] = new Complex(8.057710e-01,-4.488239e-01);
        expectation[k++] = new Complex(8.042788e-01,-4.325241e-01);
        expectation[k++] = new Complex(8.028625e-01,-4.165919e-01);
        expectation[k++] = new Complex(8.015184e-01,-4.010050e-01);
        expectation[k++] = new Complex(8.002428e-01,-3.857427e-01);
        expectation[k++] = new Complex(7.990326e-01,-3.707856e-01);
        expectation[k++] = new Complex(7.978846e-01,-3.561154e-01);
        expectation[k++] = new Complex(7.967961e-01,-3.417151e-01);
        expectation[k++] = new Complex(7.957644e-01,-3.275685e-01);
        expectation[k++] = new Complex(7.947871e-01,-3.136606e-01);
        expectation[k++] = new Complex(7.938620e-01,-2.999769e-01);
        expectation[k++] = new Complex(7.929870e-01,-2.865040e-01);
        expectation[k++] = new Complex(7.921602e-01,-2.732291e-01);
        expectation[k++] = new Complex(7.913797e-01,-2.601398e-01);
        expectation[k++] = new Complex(7.906440e-01,-2.472247e-01);
        expectation[k++] = new Complex(7.899514e-01,-2.344728e-01);
        expectation[k++] = new Complex(7.893006e-01,-2.218734e-01);
        expectation[k++] = new Complex(7.886903e-01,-2.094165e-01);
        expectation[k++] = new Complex(7.881192e-01,-1.970925e-01);
        expectation[k++] = new Complex(7.875862e-01,-1.848921e-01);
        expectation[k++] = new Complex(7.870903e-01,-1.728064e-01);
        expectation[k++] = new Complex(7.866305e-01,-1.608268e-01);
        expectation[k++] = new Complex(7.862060e-01,-1.489451e-01);
        expectation[k++] = new Complex(7.858159e-01,-1.371531e-01);
        expectation[k++] = new Complex(7.854596e-01,-1.254432e-01);
        expectation[k++] = new Complex(7.851364e-01,-1.138077e-01);
        expectation[k++] = new Complex(7.848456e-01,-1.022393e-01);
        expectation[k++] = new Complex(7.845869e-01,-9.073090e-02);
        expectation[k++] = new Complex(7.843596e-01,-7.927533e-02);
        expectation[k++] = new Complex(7.841635e-01,-6.786573e-02);
        expectation[k++] = new Complex(7.839981e-01,-5.649534e-02);
        expectation[k++] = new Complex(7.838632e-01,-4.515747e-02);
        expectation[k++] = new Complex(7.837585e-01,-3.384551e-02);
        expectation[k++] = new Complex(7.836838e-01,-2.255293e-02);
        expectation[k++] = new Complex(7.836391e-01,-1.127325e-02);
        expectation[k++] = new Complex(7.836242e-01,0);
        expectation[k++] = new Complex(7.836391e-01,1.127325e-02);
        expectation[k++] = new Complex(7.836838e-01,2.255293e-02);
        expectation[k++] = new Complex(7.837585e-01,3.384551e-02);
        expectation[k++] = new Complex(7.838632e-01,4.515747e-02);
        expectation[k++] = new Complex(7.839981e-01,5.649534e-02);
        expectation[k++] = new Complex(7.841635e-01,6.786573e-02);
        expectation[k++] = new Complex(7.843596e-01,7.927533e-02);
        expectation[k++] = new Complex(7.845869e-01,9.073090e-02);
        expectation[k++] = new Complex(7.848456e-01,1.022393e-01);
        expectation[k++] = new Complex(7.851364e-01,1.138077e-01);
        expectation[k++] = new Complex(7.854596e-01,1.254432e-01);
        expectation[k++] = new Complex(7.858159e-01,1.371531e-01);
        expectation[k++] = new Complex(7.862060e-01,1.489451e-01);
        expectation[k++] = new Complex(7.866305e-01,1.608268e-01);
        expectation[k++] = new Complex(7.870903e-01,1.728064e-01);
        expectation[k++] = new Complex(7.875862e-01,1.848921e-01);
        expectation[k++] = new Complex(7.881192e-01,1.970925e-01);
        expectation[k++] = new Complex(7.886903e-01,2.094165e-01);
        expectation[k++] = new Complex(7.893006e-01,2.218734e-01);
        expectation[k++] = new Complex(7.899514e-01,2.344728e-01);
        expectation[k++] = new Complex(7.906440e-01,2.472247e-01);
        expectation[k++] = new Complex(7.913797e-01,2.601398e-01);
        expectation[k++] = new Complex(7.921602e-01,2.732291e-01);
        expectation[k++] = new Complex(7.929870e-01,2.865040e-01);
        expectation[k++] = new Complex(7.938620e-01,2.999769e-01);
        expectation[k++] = new Complex(7.947871e-01,3.136606e-01);
        expectation[k++] = new Complex(7.957644e-01,3.275685e-01);
        expectation[k++] = new Complex(7.967961e-01,3.417151e-01);
        expectation[k++] = new Complex(7.978846e-01,3.561154e-01);
        expectation[k++] = new Complex(7.990326e-01,3.707856e-01);
        expectation[k++] = new Complex(8.002428e-01,3.857427e-01);
        expectation[k++] = new Complex(8.015184e-01,4.010050e-01);
        expectation[k++] = new Complex(8.028625e-01,4.165919e-01);
        expectation[k++] = new Complex(8.042788e-01,4.325241e-01);
        expectation[k++] = new Complex(8.057710e-01,4.488239e-01);
        expectation[k++] = new Complex(8.073434e-01,4.655151e-01);
        expectation[k++] = new Complex(8.090005e-01,4.826231e-01);
        expectation[k++] = new Complex(8.107472e-01,5.001756e-01);
        expectation[k++] = new Complex(8.125888e-01,5.182023e-01);
        expectation[k++] = new Complex(8.145311e-01,5.367351e-01);
        expectation[k++] = new Complex(8.165804e-01,5.558089e-01);
        expectation[k++] = new Complex(8.187437e-01,5.754613e-01);
        expectation[k++] = new Complex(8.210286e-01,5.957332e-01);
        expectation[k++] = new Complex(8.234432e-01,6.166691e-01);
        expectation[k++] = new Complex(8.259967e-01,6.383178e-01);
        expectation[k++] = new Complex(8.286991e-01,6.607324e-01);
        expectation[k++] = new Complex(8.315612e-01,6.839715e-01);
        expectation[k++] = new Complex(8.345954e-01,7.080991e-01);
        expectation[k++] = new Complex(8.378150e-01,7.331862e-01);
        expectation[k++] = new Complex(8.412349e-01,7.593109e-01);
        expectation[k++] = new Complex(8.448716e-01,7.865599e-01);
        expectation[k++] = new Complex(8.487437e-01,8.150297e-01);
        expectation[k++] = new Complex(8.528718e-01,8.448278e-01);
        expectation[k++] = new Complex(8.572790e-01,8.760744e-01);
        expectation[k++] = new Complex(8.619914e-01,9.089047e-01);
        expectation[k++] = new Complex(8.670384e-01,9.434706e-01);
        expectation[k++] = new Complex(8.724534e-01,9.799443e-01);
        expectation[k++] = new Complex(8.782743e-01,1.018521e+00);
        expectation[k++] = new Complex(8.845444e-01,1.059424e+00);
        expectation[k++] = new Complex(8.913135e-01,1.102908e+00);
        expectation[k++] = new Complex(8.986389e-01,1.149268e+00);
        expectation[k++] = new Complex(9.065870e-01,1.198843e+00);
        expectation[k++] = new Complex(9.152355e-01,1.252030e+00);
        expectation[k++] = new Complex(9.246750e-01,1.309293e+00);
        expectation[k++] = new Complex(9.350128e-01,1.371180e+00);
        expectation[k++] = new Complex(9.463764e-01,1.438339e+00);
        expectation[k++] = new Complex(9.589184e-01,1.511550e+00);
        expectation[k++] = new Complex(9.728233e-01,1.591751e+00);
        expectation[k++] = new Complex(9.883160e-01,1.680086e+00);
        expectation[k++] = new Complex(1.005674e+00,1.777966e+00);
        expectation[k++] = new Complex(1.025242e+00,1.887146e+00);
        expectation[k++] = new Complex(1.047456e+00,2.009841e+00);
        expectation[k++] = new Complex(1.072875e+00,2.148889e+00);
        expectation[k++] = new Complex(1.102227e+00,2.307981e+00);
        expectation[k++] = new Complex(1.136475e+00,2.492013e+00);
        expectation[k++] = new Complex(1.176927e+00,2.707621e+00);
        expectation[k++] = new Complex(1.225401e+00,2.964028e+00);
        expectation[k++] = new Complex(1.284500e+00,3.274438e+00);
        expectation[k++] = new Complex(1.358089e+00,3.658457e+00);
        expectation[k++] = new Complex(1.452163e+00,4.146492e+00);
        expectation[k++] = new Complex(1.576551e+00,4.788391e+00);
        expectation[k++] = new Complex(1.748562e+00,5.671934e+00);
        expectation[k++] = new Complex(2.001772e+00,6.967391e+00);
        expectation[k++] = new Complex(2.411000e+00,9.054181e+00);
        expectation[k++] = new Complex(3.183709e+00,1.298435e+01);
        expectation[k++] = new Complex(5.187892e+00,2.315952e+01);
        expectation[k++] = new Complex(2.283626e+01,1.126667e+02);
        expectation[k++] = new Complex(-6.981027e+00,-3.852477e+01);
        expectation[k++] = new Complex(-2.598701e+00,-1.628944e+01);
        expectation[k++] = new Complex(-1.411592e+00,-1.025688e+01);
        expectation[k++] = new Complex(-8.592172e-01,-7.442849e+00);
        expectation[k++] = new Complex(-5.401716e-01,-5.811806e+00);
        expectation[k++] = new Complex(-3.325966e-01,-4.745793e+00);
        expectation[k++] = new Complex(-1.869144e-01,-3.993392e+00);
        expectation[k++] = new Complex(-7.915751e-02,-3.433052e+00);
        expectation[k++] = new Complex(3.676615e-03,-2.998824e+00);
        expectation[k++] = new Complex(6.925212e-02,-2.651832e+00);
        expectation[k++] = new Complex(1.223792e-01,-2.367670e+00);
        expectation[k++] = new Complex(1.662291e-01,-2.130243e+00);
        expectation[k++] = new Complex(2.029773e-01,-1.928505e+00);
        expectation[k++] = new Complex(2.341654e-01,-1.754621e+00);
        expectation[k++] = new Complex(2.609165e-01,-1.602882e+00);
        expectation[k++] = new Complex(2.840677e-01,-1.469025e+00);
        expectation[k++] = new Complex(3.042556e-01,-1.349802e+00);
        expectation[k++] = new Complex(3.219730e-01,-1.242697e+00);
        expectation[k++] = new Complex(3.376068e-01,-1.145726e+00);
        expectation[k++] = new Complex(3.514650e-01,-1.057305e+00);
        expectation[k++] = new Complex(3.637957e-01,-9.761539e-01);
        expectation[k++] = new Complex(3.748008e-01,-9.012229e-01);
        expectation[k++] = new Complex(3.846460e-01,-8.316451e-01);
        expectation[k++] = new Complex(3.934686e-01,-7.666962e-01);
        expectation[k++] = new Complex(4.013830e-01,-7.057657e-01);
        expectation[k++] = new Complex(4.084851e-01,-6.483346e-01);
        expectation[k++] = new Complex(4.148559e-01,-5.939577e-01);
        expectation[k++] = new Complex(4.205638e-01,-5.422504e-01);
        expectation[k++] = new Complex(4.256670e-01,-4.928774e-01);
        expectation[k++] = new Complex(4.302149e-01,-4.455444e-01);
        expectation[k++] = new Complex(4.342499e-01,-3.999907e-01);
        expectation[k++] = new Complex(4.378077e-01,-3.559838e-01);
        expectation[k++] = new Complex(4.409190e-01,-3.133144e-01);
        expectation[k++] = new Complex(4.436094e-01,-2.717922e-01);
        expectation[k++] = new Complex(4.459008e-01,-2.312434e-01);
        expectation[k++] = new Complex(4.478111e-01,-1.915068e-01);
        expectation[k++] = new Complex(4.493550e-01,-1.524321e-01);
        expectation[k++] = new Complex(4.505441e-01,-1.138774e-01);
        expectation[k++] = new Complex(4.513872e-01,-7.570705e-02);
        expectation[k++] = new Complex(4.518907e-01,-3.779047e-02);

        Complex[] output = FFT.fft(input);

        for(int C = 0; C < 256; C++)
        {
            Assert.assertTrue(areEqual(expectation[C],output[C]));
        }

    }

    private static boolean areEqual(Complex a, Complex b)
    {
        double prec = 0.0001;

        double abs1, abs2;

        abs1 = a.Re - b.Re;
        if(abs1 < 0) abs1 = -abs1;
        abs2 = a.Im - b.Im;
        if(abs2 < 0) abs2 = -abs2;

        return( abs1 <= prec && abs2 <= prec );
    }
}
