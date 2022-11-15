package audio;

import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class AudioProcessor implements Runnable{

    private AudioSignal inputSignal,outputSignal;
    private TargetDataLine audioInput;
    private SourceDataLine audioOutput;
    private boolean isThreadRunning;


    public AudioProcessor(TargetDataLine audioInput, SourceDataLine audioOutput, int frameSize){



    }

    @Override
    public void run(){
        isThreadRunning = true;
        while (isThreadRunning){
            inputSignal.recordFrom(audioInput);


            outputSignal.playTo(audioOutput);
        }
    }

    public void terminateAudioThread(){



    }

}
