package com.devitis.base.base;

import android.os.Bundle;
import android.view.View;

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

}
