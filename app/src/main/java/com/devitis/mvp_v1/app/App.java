package com.devitis.mvp_v1.app;

import android.app.Application;

import com.devitis.mvp_v1.injection.component.IAppComponent;

import io.realm.Realm;

import javax.inject.Inject;

/**
 * Created by Diana on 20.03.2019.
 */

public class App extends Application {
    private static volatile IAppComponent appComponent;

    private void initDependency() {
        appComponent = IAppComponent.Initialize.init(this);
    }

    private void initRealm() {
        Realm.init(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDependency();
        initRealm();
    }

    public static IAppComponent getAppComponent() {
        return appComponent;
    }
}
