package testmonth;

import java.util.concurrent.ExecutionException;

import java.util.concurrent.FutureTask;



/**

 * 用多线程去处理 "123","456","789" 三个字符串，然后以"147","258","369"输出

 *

 */

public class ThreadSample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        String str1 = "123",str2 = "456",str3 = "789";

        ProcessThread thread3 = new ProcessThread(str3, null);

        ProcessThread thread2 = new ProcessThread(str2, thread3);

        ProcessThread thread1 = new ProcessThread(str1, thread2);

        for (int i = 0; i < str1.length(); i++) {

            thread1.setIndex(i);

            FutureTask<String> future = new FutureTask<String>(thread1);

            new Thread(future).start();

            String outStr = future.get();

            System.out.println(outStr);

        }

    }

}