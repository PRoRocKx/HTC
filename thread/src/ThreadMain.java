public class ThreadMain {
        public static void main(String[] args) {
            SyncObj syncObj = new SyncObj();
            TimerThread timerThread = new TimerThread(syncObj);
            WriterThread writerThread = new WriterThread(syncObj,1);
            WriterThread writerThread1 = new WriterThread(syncObj,5);
            WriterThread2 writerThread2 = new WriterThread2(syncObj,7);
            new Thread(timerThread).start();
            new Thread(writerThread).start();
            new Thread(writerThread1).start();
            new Thread(writerThread2).start();
        }
}
