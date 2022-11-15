package audio.effect;

import java.lang.Object;
import java.util.Arrays;
import audio.CircularBuffer;

public class LinearFilter extends Object{
    private final CircularBuffer m_inputs;
    private final CircularBuffer m_outputs;
    private final double[] m_inputGains;
    private final double[] m_outputGains;

    private static int instances;



    public LinearFilter(double[] ffGains, double[] fbGains){
        m_inputs=new CircularBuffer(ffGains.length);
        m_outputs=new CircularBuffer(fbGains.length);
        m_inputGains= Arrays.copyOf(ffGains,ffGains.length);
        m_outputGains=Arrays.copyOf(fbGains,fbGains.length);
//ffGains = gains FIR ; fgGains = gains IIR
    }

    public static LinearFilter highPass(double timeConstant,double period){

        double gain = Math.exp(-period/timeConstant);
        double[] ffGains = {gain,-gain};
        double[] fbGains = {-gain};

        return new LinearFilter(ffGains,fbGains);
    }

    public static LinearFilter movingAverage(int size,float coef){
        if(size<=0){
            throw new IllegalArgumentException("On ne peut pas faire la moyenne de moins de 1 élément");
        }
        double[] ffGains = new double[size];
        for(int i=0;i<ffGains.length;i++){
            ffGains[i]=coef/size;
        }
        double[] fbGains=new double[0];
        return new LinearFilter(ffGains,fbGains);
    }

    public static LinearFilter singlePoleIIR(double timeConstant, double period){
        double gain = Math.exp(-period/timeConstant);
        double[] ffGains = {1.0-gain};
        double[] fbGains = {-gain};

        return new LinearFilter(ffGains,fbGains);

    }

}
