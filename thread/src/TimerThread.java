public class TimerThread implements Runnable {

    private SyncObj syncObj;

    TimerThread(SyncObj syncObj) {
        this.syncObj = syncObj;
    }

    @Override
    public void run() {
        while (true){
            syncObj.setTick();
        }
    }


}
