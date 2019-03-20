package com.devitis.base.base;

import android.app.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.devitis.base.R;
import com.devitis.base.interactor.IScreenView;

import java.lang.ref.WeakReference;

public abstract class BaseActivity extends Activity {

    private WeakReference<IScreenView> contentView;

    private boolean isActivityVisible;

    protected abstract boolean isValid();

    protected abstract void initDependency();

    protected abstract void onCreateUI(Bundle bundle);

    public boolean isActivityVisible() {
        return isActivityVisible;
    }


    protected BasePresenter<? extends View> presenter() {
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }


    @Override
    protected void onDestroy() {
        if (contentView != null) {
            IScreenView screenView = contentView.get();
            if (screenView != null) {
                screenView.onDestroy();
            }
            contentView = null;
        }

        super.onDestroy();
    }


    @Override
    protected void onPause() {
        if (contentView != null && isValid()) {
            IScreenView screenView = contentView.get();
            if (screenView != null) {
                screenView.onHideView();
            }
        }
        if (presenter() != null) {
            presenter().onPause();
        }

        super.onPause();
        isActivityVisible = false;
    }


    @Override
    protected void onResume() {

        super.onResume();
        if (contentView != null && isValid()) {
            IScreenView screenView = contentView.get();
            if (screenView != null) {
                screenView.onShowView();
            }
        }
        if (presenter() != null) {
            presenter().onResume();
        }
        isActivityVisible = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter() != null) {
            presenter().onSaveInstance(outState);
        }
    }
}
