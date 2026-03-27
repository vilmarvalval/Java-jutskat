public class Television {
    private boolean on = false;
    private int channel;
    public final int channelCount=10;

    void pressOnOff(){
        this.on = !this.on;
    }

    boolean isOn(){
        return this.on;
    }

    void setChannel(double channel){
        this.channel = (int )channel;
        if (this.channel >channelCount) this.channel=1;
    }

    int getChannel(){
        return this.channel;
    }
}
