package com.example.collections.listsandMaps.mvp.presenter;

import com.example.collections.listsandMaps.providers.ExecutorProvider;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MapManager {


    public static Map<Integer, Integer> initializeHashMap(Integer size) {

        Random random = new Random();
        Map hashMap = new HashMap<>();
        ExecutorProvider.getExecutorService().execute(() -> {
            for (int i = 0; i < size; i++) {
                hashMap.put(i, random.nextInt(100_000));
            }
        });
        return hashMap;
    }

    public static Map<Integer, Integer> initializeTreeMap(Integer size) {

        Random random = new Random();
        Map treeMap = new TreeMap<>();
        ExecutorProvider.getExecutorService().execute(() -> {
            for (int i = 0; i < size; i++) {
                treeMap.put(i, random.nextInt(100_000));
            }
        });
        return treeMap;
    }

}
