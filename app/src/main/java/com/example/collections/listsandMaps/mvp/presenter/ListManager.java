package com.example.collections.listsandMaps.mvp.presenter;

import com.example.collections.listsandMaps.providers.ExecutorProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class ListManager {

    public static List<Integer> initializeLinkedList(Integer size) {
        Random random = new Random();
        List linkedlist = new LinkedList();
        ExecutorProvider.getExecutorService().submit(() -> {
            for (int i = 0; i < size; i++) {
                linkedlist.add(random.nextInt(100_000));
            }
        });

        return linkedlist;
    }

    public static List<Integer> initializeCopyOnWriteList(Integer size) {
        Random random = new Random();
        List copyOnWriteList = new CopyOnWriteArrayList();

        ExecutorProvider.getExecutorService().submit(() -> {
            for (int i = 0; i < size; i++) {
                copyOnWriteList.add(random.nextInt(100_000));
            }
        });

        return copyOnWriteList;
    }

    public static List<Integer> initializeArrayList(Integer size) {
        Random random = new Random();
        List arrayList = new ArrayList<>();

        ExecutorProvider.getExecutorService().submit(() -> {
            for (int i = 0; i < size; i++) {
                arrayList.add(random.nextInt(100_000));
            }
        });

        return arrayList;
    }
}