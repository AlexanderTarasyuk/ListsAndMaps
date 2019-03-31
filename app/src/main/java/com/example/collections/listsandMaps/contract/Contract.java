package com.example.collections.listsandMaps.contract;

import android.support.v4.app.Fragment;

import com.example.collections.listsandMaps.mvp.view.fragments.MapFragment;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface Contract {
    interface View {


        int loadSize();

        Fragment getListFragment();

        MapFragment getMapFragment();
    }

    interface MapPresenter {
        void attachView(View view);

        void detachView();

        void calculateAddNewElementToHashMap();

        void calculateFindElementInHashMapByKey();

        void calculateRemoveElementInHashMapByKey();

        void calculateAddNewElementToTreeMap();

        void calculateFindElementInTreeMapByKey();

        void calculateRemoveElementInTreeMapByKey();

        void initializeMap(Integer size);

    }

    interface Presenter {
        void initialzeList(Integer size);

        void loadSizeOfLists(int number);

        void setTvInsertAtBeginningArrayList();

        void setTvInsertAtMiddleArrayList();


        void setTvInsertAtEndArrayList();


        void setTvFindElementArrayList();

        void setTvDeleteFirstArrayList();

        void setTvDeleteMiddle();

        void setTvDeleteLastElementArrayList();

        void setTvInsertAtBeginningLinkedList();

        void setTvInsertAtMiddleLinkList();

        void setTvInsertAtEndLinkList();

        void setTvFindElementLinkList();

        void setTvDeleteFirstLinkList();

        void setTvDeleteMiddleLinkList();

        void setTvDeleteLastLinkList();

        void setTvInsertAtBeginningCopyOnWriteList();

        void setTvInsertAtMiddleCopyOnWriteList();

        void setTvInsertAtEndCopyOnWriteList();

        void setTvFindElementCopyOnWriteList();

        void setTvDeleteFirstCopyOnWriteList();

        void setTvDeleteMiddleCopyOnWriteList();

        void setTvDeleteLastCopyOnWriteList();

        void attachView(View view);

        void detachView();

    }

    interface ListUseCase {
        String calculateInsertAtTheBeginning(List<Integer> list) throws ExecutionException, InterruptedException;

        String calculateInsertAtTheMiddle(List<Integer> list) throws ExecutionException, InterruptedException;

        String calculateInsertAtTheEnd(List<Integer> list) throws ExecutionException, InterruptedException;

        String calculateFindTheIndexOfElement(List<Integer> list) throws ExecutionException, InterruptedException;

        String calculateRemoveFirstElement(List<Integer> list) throws ExecutionException, InterruptedException;

        String calculateRemoveMiddleElementArrayList(List<Integer> list) throws ExecutionException, InterruptedException;

        String calculateRemoveLastElement(List<Integer> list) throws ExecutionException, InterruptedException;


    }


    interface MapUseCase {

        String calculateAddNewElementToMap(Map<Integer, Integer> treeMap) throws ExecutionException, InterruptedException;

        String calculateFindElementInMapByKey(Map<Integer, Integer> treeMap) throws ExecutionException, InterruptedException;

        String calculateRemoveElementInMapByKey(Map<Integer, Integer> treeMap) throws ExecutionException, InterruptedException;
    }
}