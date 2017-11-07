package com.cputech.demo.jdk.cocurrency;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * Created by song on 2017/10/24.
 */
public class ExecutorDemo {
    public static Runnable toDoLater() {
        return () -> {
            System.out.println("later");
        };
    }

    public static Callable callMeLater(int counter) {
        return () -> {
            Thread.sleep(((int) (Math.random()*1000)));
            System.out.println(counter);
            return counter;
        };
    }
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService threadPoolTaskExecutor = Executors.newFixedThreadPool(10);
        threadPoolTaskExecutor.submit(ExecutorDemo.toDoLater());
        threadPoolTaskExecutor.submit(ExecutorDemo.toDoLater());

        LinkedList<Future<Integer>> taskResults = new LinkedList();
        //通过get来阻塞结果
        for(int i = 0 ; i < 3 ; i++)
            threadPoolTaskExecutor.submit(ExecutorDemo.callMeLater(i)).get();
        for(int i = 0 ; i < 5 ; i++)
            taskResults.add(threadPoolTaskExecutor.submit(ExecutorDemo.callMeLater(i)));
        int total = 0;
        //没有结束的 从对头插入到队尾
        while(taskResults.size() > 0){
            if(taskResults.getFirst().isDone()){
                System.out.println("+");
                total += taskResults.getFirst().get();
                taskResults.removeFirst();
            }else if (taskResults.getFirst().isCancelled()){
                taskResults.removeFirst();
                System.out.println("-");
            }else {
                taskResults.addLast(taskResults.removeFirst());
                System.out.println("=");
            }
            Thread.sleep(100);
        }
        System.out.println(total);
//        taskResults.get(1).
        threadPoolTaskExecutor.shutdown();
    }

    // future get 0 超时时间,设置为0 没取到就pass了
   /* while(numThread > 0){
        for(Future<String> future : futureList){
            String result = null;
            try {
                result = future.get(0, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                //超时异常直接忽略
            }
            if(null != result){
                futureList.remove(future);
                numThread--;
                System.out.println(result);
                //此处必须break，否则会抛出并发修改异常。（也可以通过将futureList声明为CopyOnWriteArrayList类型解决）
                break;
            }
        }
    }*/

}




