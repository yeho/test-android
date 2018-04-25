package com.yeho.movies.common;

/**
 * @author yeho
 *      fecha: 24/04/2018
 */

public interface MvpPresenter<V> {

    void attachView(V view);
    void detachView();

}