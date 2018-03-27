package com.learn2crack.retrofitrxjava.network;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.reactivestreams.Subscriber;


/**
 * Created by alandwiprasetyo on 11/22/16.
 */

public abstract class NetworkCallback<M> implements Subscriber<M> {

    private static final String TAG = NetworkCallback.class.getName();

    public abstract void onSuccess(M model);

    public abstract void onFailure(String message);

    public abstract void onFinish();

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String message = httpException.getMessage();
            Log.i(TAG, "code : " + code);
            onFailure(message);

        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(M model) {
        onSuccess(model);
    }


    @Override
    public void onComplete() {
        onFinish();
    }
}
