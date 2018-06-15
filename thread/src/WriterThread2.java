public class WriterThread2 extends WriterThread{
    WriterThread2(SyncObj syncObj, int sleepTick) {
        super(syncObj, sleepTick);
    }

    @Override
    public void run() {
        while(true) {
            tick = syncObj.getTick(tick, sleepTick);
            if (tick % sleepTick == 0)
                System.out.println(Thread.currentThread().getName());
        }
    }
}
