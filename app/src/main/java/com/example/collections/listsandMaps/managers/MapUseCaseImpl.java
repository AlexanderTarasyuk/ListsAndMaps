package com.example.collections.listsandMaps.managers;

import android.os.AsyncTask;

import com.example.collections.listsandMaps.providers.ExecutorProvider;
import com.example.collections.listsandMaps.contract.Contract;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public final class MapUseCaseImpl implements Contract.MapUseCase {

    private static volatile MapUseCaseImpl mapCalculation;

    private MapUseCaseImpl() {
    }

    public static MapUseCaseImpl getMapUseCaseSingleTon() {

        if (mapCalculation == null) {
            synchronized (MapUseCaseImpl.class) {
                mapCalculation = new MapUseCaseImpl();
            }
        }
        return mapCalculation;
    }

    @Override
    public String calculateAddNewElementToMap(Map<Integer, Integer> map) throws ExecutionException, InterruptedException {

        return new AddNewElementToMap().executeOnExecutor(ExecutorProvider.getExecutorService(), map).get();
    }

    @Override
    public String calculateFindElementInMapByKey(Map<Integer, Integer> map) throws ExecutionException, InterruptedException {
        return new FindElementInMapByKey().executeOnExecutor(ExecutorProvider.getExecutorService(), map).get();
    }

    @Override
    public String calculateRemoveElementInMapByKey(Map<Integer, Integer> map) throws ExecutionException, InterruptedException {
        return new RemoveElementInMap().executeOnExecutor(ExecutorProvider.getExecutorService(), map).get();
    }


    public static class AddNewElementToMap extends AsyncTask<Map<Integer, Integer>, Void, String> {

        @Override
        protected String doInBackground(Map... voids) {

            long temp = System.nanoTime();
            voids[0].put(new Integer(1), 1);
            return String.valueOf(System.nanoTime() - temp);
        }
    }

    public static class FindElementInMapByKey extends AsyncTask<Map<Integer, Integer>, Void, String> {

        @Override
        protected String doInBackground(Map... voids) {

            long temp = System.nanoTime();
            voids[0].get(11);
            return String.valueOf(System.nanoTime() - temp);
        }
    }

    public static class RemoveElementInMap extends AsyncTask<Map<Integer, Integer>, Void, String> {

        @Override
        protected String doInBackground(Map... voids) {


            long temp = System.nanoTime();
            voids[0].remove(11);
            return String.valueOf(System.nanoTime() - temp);
        }
    }
}

