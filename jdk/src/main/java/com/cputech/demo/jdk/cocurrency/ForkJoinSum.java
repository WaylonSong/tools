package com.cputech.demo.jdk.cocurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by song on 2017/10/26.
 */

//[beg, end]
class ForkJoinSum extends RecursiveTask<Integer> {
    final int[] array;
    final int beg;
    final int end;
    int result;
    public ForkJoinSum(int[] array) {
        this(array, 0, array.length-1);
    }

    public ForkJoinSum(int[] array, int beg, int end) {
        this.array = array;
        this.beg = beg;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(end - beg  == 1){
            return (array[beg]+array[end]);
        }else if(end - beg == 0){
            return (array[beg]);
        }else{
            int pivot = (beg+end)>>>1;
            ForkJoinSum left = new ForkJoinSum(array, beg, pivot);
            ForkJoinSum right = new ForkJoinSum(array, pivot+1, end);
            left.fork();
            right.fork();
            return left.join()+right.join();
        }
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        int size = 100;
        int[] ints = new int[size];
        for(int i = 0; i < size; i++){
            ints[i] = i+1;
        }
        long beg = System.currentTimeMillis();
        ForkJoinSum sumTask = new ForkJoinSum(ints);
        ForkJoinPool fjpool = new ForkJoinPool(100);//10 100
        Future<Integer> result = fjpool.submit(sumTask);
        // do something
        System.out.println(result.get());
        System.out.println(System.currentTimeMillis()-beg);

    }

}