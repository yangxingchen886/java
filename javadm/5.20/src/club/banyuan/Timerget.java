package club.banyuan;

public class Timerget implements Timer{
    long startTime;
    long endTime;
    boolean isTimerWorking = false;

    @Override
    public void start() throws IllegalStateException {
        if(isTimerWorking){
            throw new IllegalStateException();
        }
        this.startTime = System.currentTimeMillis();
        isTimerWorking = true;
    }

    @Override
    public void stop() throws IllegalStateException {
        if(!isTimerWorking){
            throw new IllegalStateException();
        }
        this.endTime = System.currentTimeMillis();
        isTimerWorking = false;
    }

    @Override
    public void reset() {
        this.startTime = 0;
        this.endTime = 0;
    }

    @Override
    public long getTimeMillisecond() {
        return endTime - startTime;
    }
}
