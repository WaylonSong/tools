package com.cputech.demo.jdk.cocurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by song on 2017/10/28.
 */
public class ForkJoinSort extends RecursiveAction {
    final long[] array;
    final int lo, hi;
    ForkJoinSort(long[] array, int lo, int hi) {
        this.array = array; this.lo = lo; this.hi = hi;
    }
    ForkJoinSort(long[] array) { this(array, 0, array.length); }
    protected void compute() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (hi - lo < THRESHOLD)
            sortSequentially(lo, hi);
        else {
            int mid = (lo + hi) >>> 1;
            invokeAll(new ForkJoinSort(array, lo, mid),
                    new ForkJoinSort(array, mid, hi));
            merge(lo, mid, hi);
        }
    }
    // implementation details follow:
    static final int THRESHOLD = 100;
    void sortSequentially(int lo, int hi) {
        Arrays.sort(array, lo, hi);
    }
    void merge(int lo, int mid, int hi) {
        long[] buf = Arrays.copyOfRange(array, lo, mid);
        for (int i = 0, j = lo, k = mid; i < buf.length; j++)
            array[j] = (k == hi || buf[i] < array[k]) ?
                    buf[i++] : array[k++];
    }

    public static void main(String args[]) throws InterruptedException {
        Random random = new Random();
        int size = 1000;
        long[] longs = new long[size];
        for(int i = 0; i<size; i++){
            longs[i] = random.nextLong();
        }
        long[] longs1 = Arrays.copyOf(longs, size);
        long timeBeg = System.currentTimeMillis();
        System.out.println(Arrays.toString(longs));
        ForkJoinSort forkJoinSort = new ForkJoinSort(longs);
        forkJoinSort.fork().join();
        System.out.println(Arrays.toString(longs));

        System.out.println(System.currentTimeMillis()-timeBeg);

        timeBeg = System.currentTimeMillis();
        System.out.println(Arrays.toString(longs1));
        ForkJoinPool fjpool = new ForkJoinPool(100);//10 100
        fjpool.invoke(new ForkJoinSort(longs1));
        System.out.println(Arrays.toString(longs1));
        System.out.println(System.currentTimeMillis()-timeBeg);


        /*
        * 上述二者的差别
        *
        * 默认fork的话 会调用 ForkJoinPool.common, 在静态初始化里创建的对象,并发现成数量取决于runtime的可以处理器数量
        *
        *
        * if (parallelism < 0 && // default 1 less than #cores
            (parallelism = Runtime.getRuntime().availableProcessors() - 1) <= 0)
            parallelism = 1;
        if (parallelism > MAX_CAP)
            parallelism = MAX_CAP;
        *
        *
        * */

    }

}
