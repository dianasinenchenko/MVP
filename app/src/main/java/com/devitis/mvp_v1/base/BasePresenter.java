package com.devitis.mvp_v1.base;

import android.os.Bundle;
import android.view.View;

import com.devitis.mvp_v1.LogUtils;


/**
 * Created by Diana on 20.03.2019.
 */

public abstract class BasePresenter<V extends View> {
    private boolean onLoaded;
    private V view = null;

    protected abstract BaseActivity getActivity();


    public void onDestroy() {

    }

    public void onLoad() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onSaveInstance(Bundle state) {

    }


    public void dropView(V view) {
        if (view == null) {
            LogUtils.d(new NullPointerException("drop null view"));
            return;
        }

        if (this.view == view) {
            onLoaded = false;
            this.view = null;
            onDestroy();
        }

    }

    public V getView() {
        return view;
    }

    public void takeView(V view) {
        if (view == null) {
            LogUtils.d(new NullPointerException("take null view"));
            return;
        }

        if (this.view != view) {
            if (this.view != null) {
                dropView(this.view);
            }

            this.view = view;
            if (getView() != null && !onLoaded) {
                onLoaded = true;
                onLoad();
            }
        }
    }

}
