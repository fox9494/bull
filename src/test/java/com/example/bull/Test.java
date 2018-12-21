package com.example.bull;

import org.apache.commons.lang3.StringUtils;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        class PrimeThread extends Thread {

            private ThreadPoolExecutor threadPool;

            public PrimeThread(ThreadPoolExecutor pool){
                threadPool=pool;
            }

            public void run() {
                System.out.println("我正在做关闭工作"  );
                threadPool.shutdown();
                try {
                    threadPool.awaitTermination(180, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //可以自己定义ThreadFactory，自己生成线程，这样可以定义线程名字
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        for (int j = 0; j < 20; j++) {
                            System.out.println("我是线程"+Thread.currentThread().getName()+",我正在执行任务工作"+j  );
                            Thread.sleep(5000);
                            System.out.println("我执行任务工作完成"+j  );
                            System.out.println("---------"+j  );
                            Thread.sleep(3000);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }




        Runtime.getRuntime().addShutdownHook(new PrimeThread(threadPool));
        System.exit(0);

    }

}
