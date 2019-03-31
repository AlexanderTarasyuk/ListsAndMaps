package com.example.collections.listsandMaps.mvp.presenter;


import com.example.collections.listsandMaps.contract.Contract;
import com.example.collections.listsandMaps.managers.ListUseCaseImpl;
import com.example.collections.listsandMaps.mvp.view.MainActivity;
import com.example.collections.listsandMaps.providers.ExecutorProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;


public final class ListPresenter implements Contract.Presenter {

    private static volatile ListPresenter listPresenter;
    private Contract.View view;
    private Contract.ListUseCase useCase;

    private List<Integer> arrayList;
    private List<Integer> linkedList;
    private List<Integer> writeOnWriteLinkedList;

    private ListPresenter() {
        useCase = ListUseCaseImpl.getListUseCaseSingleton();
    }

    public static ListPresenter getListPresenterSingleton() {

        if (listPresenter == null) {
            synchronized (ListPresenter.class) {
                listPresenter = new ListPresenter();

            }
        }
        return listPresenter;
    }

    public Contract.View getView() {
        return view;
    }


    @Override
    public void setTvInsertAtBeginningArrayList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtBeginningArrayList(useCase.calculateInsertAtTheBeginning(arrayList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvInsertAtMiddleArrayList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtMiddleArrayList(useCase.calculateInsertAtTheMiddle(arrayList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void setTvInsertAtEndArrayList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtEndArrayList(useCase.calculateInsertAtTheEnd(arrayList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void setTvFindElementArrayList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvFindElementArrayList(useCase.calculateFindTheIndexOfElement(arrayList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvDeleteFirstArrayList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteFirstArrayList(useCase.calculateRemoveFirstElement(arrayList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvDeleteMiddle() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteMiddleArrayList(useCase.calculateRemoveMiddleElementArrayList(arrayList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setTvDeleteLastElementArrayList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteLastElementArrayList(useCase.calculateRemoveLastElement(arrayList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvInsertAtBeginningLinkedList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtBeginningLinkedList(useCase.calculateInsertAtTheBeginning(linkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setTvInsertAtMiddleLinkList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtMiddleLinkList(useCase.calculateInsertAtTheMiddle(linkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvInsertAtEndLinkList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtEndLinkList(useCase.calculateInsertAtTheEnd(linkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvFindElementLinkList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvFindElementLinkList(useCase.calculateFindTheIndexOfElement(linkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvDeleteFirstLinkList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteFirstLinkList(useCase.calculateRemoveFirstElement(linkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvDeleteMiddleLinkList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteMiddleLinkList(useCase.calculateRemoveMiddleElementArrayList(linkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvDeleteLastLinkList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteLastLinkList(useCase.calculateRemoveLastElement(linkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvInsertAtBeginningCopyOnWriteList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtBeginningCopyOnWriteList(useCase.calculateInsertAtTheBeginning(writeOnWriteLinkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setTvInsertAtMiddleCopyOnWriteList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtMiddleCopyOnWriteList(useCase.calculateInsertAtTheMiddle(writeOnWriteLinkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setTvInsertAtEndCopyOnWriteList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvInsertAtEndCopyOnWriteList(useCase.calculateInsertAtTheEnd(writeOnWriteLinkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setTvFindElementCopyOnWriteList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvFindElementCopyOnWriteList(useCase.calculateFindTheIndexOfElement(writeOnWriteLinkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setTvDeleteFirstCopyOnWriteList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteFirstCopyOnWriteList(useCase.calculateRemoveFirstElement(writeOnWriteLinkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setTvDeleteMiddleCopyOnWriteList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteMiddleCopyOnWriteList(useCase.calculateRemoveMiddleElementArrayList(writeOnWriteLinkedList));
//                view.setTvDeleteMiddleCopyOnWriteList(useCase.calculateRemoveMiddleElementArrayList(writeOnWriteLinkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setTvDeleteLastCopyOnWriteList() {
        if (view != null & useCase != null) {
            try {
                ((MainActivity) view).getListFragment().setTvDeleteLastCopyOnWriteList(useCase.calculateRemoveMiddleElementArrayList(writeOnWriteLinkedList));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initialzeList(Integer size) {

//        arrayList = ListManager.initializeArrayList(size);
//        linkedList = ListManager.initializeLinkedList(size);
//        writeOnWriteLinkedList = ListManager.initializeCopyOnWriteList(size);


        Random random = new Random();
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        writeOnWriteLinkedList = new CopyOnWriteArrayList<>();


        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(100_000));
            linkedList.add(random.nextInt(100_000));
            writeOnWriteLinkedList.add(random.nextInt(100_000));

        }


    }

    @Override
    public void loadSizeOfLists(int number) {
        initialzeList(number);


    }


    @Override
    public void attachView(Contract.View view) {
        this.view = view;


    }

    @Override
    public void detachView() {
        view = null;
        useCase = null;

    }

}
