public class SyncObj {

    private int tick = 0;
    private long time = System.currentTimeMillis();

    public long getTime(){
        return time;
    }

    public synchronized int getTick(int tick, int sleepTick) {
        while (this.tick == tick) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return this.tick;
    }

    public synchronized void setTick() {
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tick++;
        System.out.println("tick");
        notifyAll();
    }
}
