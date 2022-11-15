package audio;

import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class AudioSignal {

    private double[] sampleBuffer;
    private double dBlevel;
    private int frameSize;


    public AudioSignal(int frameSize){



    }

    public void setFrom(AudioSignal other){




    }

    public boolean recordFrom(TargetDataLine audioInput){
        byte[] byteBuffer = new byte[sampleBuffer.length*2];
        if(audioInput.read(byteBuffer,0, byteBuffer.length)==1) return false;
        for (int i=0;i<sampleBuffer.length;i++)
            sampleBuffer[i]=((byteBuffer[2*i]<<8)+byteBuffer[2*i+1])/32768.0;

        return true;
    }

    public boolean playTo(SourceDataLine audioOutput){

    return true;

    }

}
