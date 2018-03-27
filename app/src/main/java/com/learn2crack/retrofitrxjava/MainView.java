package com.learn2crack.retrofitrxjava;

import com.learn2crack.retrofitrxjava.model.Android;

import java.util.List;


/**
 * Created by alandwiprasetyo on 11/22/16.
 */
interface MainView {

    void handleResponse(List<Android> androidList);

    void handleError(Throwable error);

}
