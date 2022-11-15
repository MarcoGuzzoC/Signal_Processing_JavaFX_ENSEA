package audio;

public class CircularBuffer {
    private double[] m_data;
    private int m_front;
    private int m_length;

    public CircularBuffer(int size) {
        m_data = new double[size];
        for(int i =0;i< m_data.length;i++){
            m_data[i]=0.0;
        }
    }
    double size(){
        return m_length;
    }
    double getFirst(){
        return m_data[m_front];
    }
    double getLast(){
        if(m_length==0){return 0;}
        return m_data[(m_front+m_length-1)% m_data.length];
    }
    public void addFirst(double value){
        if(m_data.length==0){return;}
        m_data[m_front]=value;
        if(m_length< m_data.length){m_length++;}
    }

}
