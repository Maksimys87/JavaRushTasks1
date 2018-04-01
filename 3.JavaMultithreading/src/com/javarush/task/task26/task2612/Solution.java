package com.javarush.task.task26.task2612;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
      /* if (!lock.tryLock()) ifLockIsBusy();
       else try {
           ifLockIsFree();
       } finally {
           lock.unlock();
       }*/
       if (lock.tryLock()) {
           try {
               ifLockIsFree();
           } finally {
               lock.unlock();
           }
       }
       else ifLockIsBusy();
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //LinkedList<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 30000000; i++) {
            list.add(i);
        }
        long finish = System.currentTimeMillis();
        /*for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();*/
        long time = finish-start;
        System.out.println(time/1000 + " sec on creating List");
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.set(i,((list.get(i)*10)/100));
        }
        long finish1 = System.currentTimeMillis();
       /* for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();*/
        System.out.println((finish1-start1)/1000 + " sec on changing List");
    }
}
