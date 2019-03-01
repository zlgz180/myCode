package com.my.code.jdk.thead;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyDelayMsg implements Delayed {
    private final long delayTime; // 延迟时间
    private final long expire; // 到期时间
    private Object data; // 数据

    public MyDelayMsg() {
        delayTime = 0;
        expire = 0;
    }

    public MyDelayMsg(Object data, long delay) {
        delayTime = delay;
        this.data = data;
        expire = System.currentTimeMillis() + delay;
    }


    /**
     * 方法返回该元素距离失效还剩余的时间，当<=0时元素就失效了， 就可以从队列中获取到。
     * 
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "MyDelayMsg{" + "delayTime=" + delayTime + ", expire=" + expire + ", data=" + data + '}';
    }
}
