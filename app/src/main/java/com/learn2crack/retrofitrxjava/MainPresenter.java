package com.learn2crack.retrofitrxjava;


import com.learn2crack.retrofitrxjava.network.NetworkClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yanto on 3/26/18.
 */

public class MainPresenter extends NetworkClient {

    MainView  mainView;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainView mainView){
        this.mainView = mainView;
        mCompositeDisposable = new CompositeDisposable();
    }

    public void loadJSON() {

        mCompositeDisposable.add(getRequestInterface().register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(mainView::handleResponse, mainView::handleError));
    }

    public void clearCompositeDisposable(){
        mCompositeDisposable.clear();
    }
}
