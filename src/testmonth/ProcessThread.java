package testmonth;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ProcessThread implements Callable<String>{
    private String value;
    private ProcessThread next;
    private Integer index;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProcessThread getNext() {
        return next;
    }

    public void setNext(ProcessThread next) {
        this.next = next;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String call() throws Exception {
        if(this.next!=null){
            this.next.setIndex(this.index);
            //开启下一个线程
            FutureTask<String> future = new FutureTask<String>(this.next);
            new  Thread(future).start();
            String nextString = future.get();
            return value.charAt(this.index)+nextString;
        }
        return String.valueOf(value.charAt(this.index));
    }
    public ProcessThread(String value, ProcessThread next) {
        this.value = value;
        this.next = next;
    }
    //set/get 省略
}