package demo.democurrentbug.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class LockThreadExample implements Runnable {
    private Lock lock;
    private List<String> list;

    public LockThreadExample(Lock lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            //this.lock.lock();
            this.lock.tryLock(1000, TimeUnit.SECONDS);
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(100L);
                this.list.add("value-" + i);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.lock.unlock();
        }
    }
}