package com.example.collections.listsandMaps.mvp.presenter;

import com.example.collections.listsandMaps.contract.Contract;
import com.example.collections.listsandMaps.managers.MapUseCaseImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

public final class MapPresenter implements Contract.MapPresenter {
    private Contract.View view;
    private Contract.MapUseCase mapModel;
    private Map<Integer, Integer> hashMap;
    private Map<Integer, Integer> treeMap;

    private static volatile MapPresenter mapPresenter;

    public Contract.View getView() {
        return view;
    }

    private MapPresenter() {
        mapModel = MapUseCaseImpl.getMapUseCaseSingleTon();
    }

    public static MapPresenter getMapPresenterSingleton() {
        if (mapPresenter == null) {
            synchronized (MapPresenter.class) {
                mapPresenter = new MapPresenter();
            }
        }
        return mapPresenter;
    }


    @Override
    public void calculateAddNewElementToHashMap() {
        try {
            view.getMapFragment().setAddInHashMap(mapModel.calculateAddNewElementToMap(hashMap));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void calculateFindElementInHashMapByKey() {
        try {
            view.getMapFragment().setSelectInHashMap(mapModel.calculateFindElementInMapByKey(hashMap));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void calculateRemoveElementInHashMapByKey() {
        try {
            view.getMapFragment().setRemoveInHashMap(mapModel.calculateRemoveElementInMapByKey(hashMap));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void calculateAddNewElementToTreeMap() {
        try {
            view.getMapFragment().setAddInTreeMap(mapModel.calculateAddNewElementToMap(treeMap));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void calculateFindElementInTreeMapByKey() {

        try {
            view.getMapFragment().setSelectInTreeMap(mapModel.calculateFindElementInMapByKey(treeMap));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void calculateRemoveElementInTreeMapByKey() {
        try {
            view.getMapFragment().setRemoveInTreeMap(mapModel.calculateRemoveElementInMapByKey(treeMap));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initializeMap(Integer size) {

//        hashMap = MapManager.initializeHashMap(size);
//        treeMap = MapManager.initializeTreeMap(size);

        Random random = new Random();
        hashMap = new HashMap<>();
        treeMap = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            hashMap.put(i, random.nextInt(100_000));
            treeMap.put(i, random.nextInt(100_000));
        }

    }


    @Override
    public void attachView(Contract.View view) {
        this.view = view;


    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
