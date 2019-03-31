package com.example.collections.listsandMaps.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.alextarasyuk.collectionsandmaps.BuildConfig;
import com.example.alextarasyuk.collectionsandmaps.R;
import com.example.collections.listsandMaps.contract.Contract;
import com.example.collections.listsandMaps.mvp.presenter.ListPresenter;
import com.example.collections.listsandMaps.mvp.presenter.MapPresenter;
import com.example.collections.listsandMaps.mvp.view.fragments.ListFragment;
import com.example.collections.listsandMaps.mvp.view.fragments.MapFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements Contract.View {

    @BindView(R.id.btn_calculate)
    Button btn;
    @BindView(R.id.edt_text)
    EditText editText;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private Contract.Presenter listPresenter;
    private Contract.MapPresenter mapPresenter;
    private ListFragment listFragment;
    private MapFragment mapFragment;
    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        listPresenter = ListPresenter.getListPresenterSingleton();
        listPresenter.attachView(this);


        mapPresenter = MapPresenter.getMapPresenterSingleton();
        mapPresenter.attachView(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                listPresenter.initialzeList(Integer.valueOf(editText.getText().toString()));
                mapPresenter.initializeMap(Integer.valueOf(editText.getText().toString()));

            }
        }).start();

        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_collections);
        mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_maps);


        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }


    @OnClick(R.id.btn_calculate)
    void calculateContenetOfTableafterButtonIsClicked(View view) {
        Timber.d("calculate content of table after button is clicked");


        if (listPresenter != null & (getSize() >= 1) & !TextUtils.isEmpty(editText.getText().toString())
                & Integer.valueOf(editText.getText().toString()) <= Integer.MAX_VALUE) {

//            ExecutorProvider.getExecutorService().execute(new Runnable() {
//                @Override
//                public void run() {
//                    listPresenter.initialzeList(Integer.valueOf(editText.getText().toString()));
//                    mapPresenter.initializeMap(Integer.valueOf(editText.getText().toString()));
//                }
//            });
            new Thread(() -> {
                listPresenter.initialzeList(Integer.valueOf(editText.getText().toString()));
                mapPresenter.initializeMap(Integer.valueOf(editText.getText().toString()));
            }).start();

            startList();
            startMap();
        }
    }


    private void startList() {
        listPresenter.setTvInsertAtBeginningArrayList();
        listPresenter.setTvInsertAtMiddleArrayList();
        listPresenter.setTvInsertAtEndArrayList();
        listPresenter.setTvFindElementArrayList();
        listPresenter.setTvDeleteFirstArrayList();
        listPresenter.setTvDeleteFirstArrayList();
        listPresenter.setTvDeleteMiddle();
        listPresenter.setTvDeleteLastElementArrayList();

        listPresenter.setTvInsertAtBeginningLinkedList();
        listPresenter.setTvInsertAtMiddleLinkList();
        listPresenter.setTvInsertAtEndLinkList();
        listPresenter.setTvFindElementLinkList();
        listPresenter.setTvDeleteFirstLinkList();
        listPresenter.setTvDeleteMiddleLinkList();
        listPresenter.setTvDeleteLastLinkList();

        listPresenter.setTvInsertAtBeginningCopyOnWriteList();
        listPresenter.setTvInsertAtMiddleCopyOnWriteList();
        listPresenter.setTvInsertAtEndCopyOnWriteList();
        listPresenter.setTvFindElementCopyOnWriteList();
        listPresenter.setTvDeleteFirstCopyOnWriteList();
        listPresenter.setTvDeleteMiddleCopyOnWriteList();
        listPresenter.setTvDeleteLastCopyOnWriteList();
    }

    private void startMap() {
        mapPresenter.calculateAddNewElementToHashMap();
        mapPresenter.calculateFindElementInHashMapByKey();
        mapPresenter.calculateRemoveElementInHashMapByKey();

        mapPresenter.calculateAddNewElementToTreeMap();
        mapPresenter.calculateFindElementInTreeMapByKey();
        mapPresenter.calculateRemoveElementInTreeMapByKey();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("EditTextValue", editText.getText().toString());
        getSupportFragmentManager().putFragment(outState, "ListFragment", listFragment);
        getSupportFragmentManager().putFragment(outState, "MapFragment", mapFragment);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            editText.setText(savedInstanceState.getString("EditTextValue"));
            listFragment = (ListFragment) getSupportFragmentManager().getFragment(savedInstanceState, "ListFragment");
            mapFragment = (MapFragment) getSupportFragmentManager().getFragment(savedInstanceState, "MapFragment");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (listPresenter != null) listPresenter.detachView();
        if (mapPresenter != null) mapPresenter.detachView();


        if (unbinder != null) unbinder.unbind();

    }


    public int getSize() {
        return Integer.valueOf(editText.getText().toString().trim());
    }


    @Override
    public int loadSize() {
        return Integer.valueOf(editText.getText().toString().trim());
    }

    @Override
    public ListFragment getListFragment() {
        return listFragment;
    }

    @Override
    public MapFragment getMapFragment() {
        return mapFragment;
    }
}
