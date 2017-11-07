package com.cputech.demo.jdk.cocurrency;

import java.util.concurrent.*;

/**
 * Created by song on 2017/10/24.
 */
public class CompleteServiceDemo {
    public static void main(String args[]) throws Exception {
        Executor executor = Executors.newFixedThreadPool(5);
        CompletionService<Double> completionService = new ExecutorCompletionService<Double>(executor);
        Double total = 0.0;
        for(int i = 0 ;i <20 ; i++){
            final int finalI = i;
            completionService.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    Thread.sleep(((int) (Math.random()*2000)));
                    return finalI + Math.random();
                }
            });
        }

        for(int i = 0; i < 20; i++){
            total += completionService.take().get();
        }
        System.out.println(total);
    }
}
