package com.devitis.mvp_v1.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.devitis.mvp_v1.interactor.IScreenView;

import java.lang.ref.WeakReference;


public abstract class BaseActivity extends Activity {
    private WeakReference<IScreenView> contentView;
    private boolean isActivityVisible;


    protected abstract boolean isValid();

    protected abstract void initDependency();

    protected abstract void onCreateUI(Bundle bundle);

    protected BasePresenter<? extends View> presenter() {
        return null;
    }

    public boolean isActivityVisible() {
        return isActivityVisible;
    }

    public void onBack() {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDependency();
        onCreateUI(savedInstanceState);
    }

    @Override
    public void setContentView(View view) {
        if (view instanceof IScreenView) {
            IScreenView screen = (IScreenView) view;
            contentView = new WeakReference<IScreenView>(screen);
        }
        super.setContentView(view);
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
