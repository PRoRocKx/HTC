public class WriterThread implements Runnable{

        int tick = 0;
        int sleepTick;
        SyncObj syncObj;
        WriterThread(SyncObj syncObj, int sleepTick) {
            this.syncObj = syncObj;
            this.sleepTick = sleepTick;
        }
        @Override
        public void run() {
            while(true) {
                tick = syncObj.getTick(tick, sleepTick);
                if (tick % sleepTick == 0)
                    System.out.println(Thread.currentThread().getName() + " " + (System.currentTimeMillis() - syncObj.getTime()));
            }
        }
}
