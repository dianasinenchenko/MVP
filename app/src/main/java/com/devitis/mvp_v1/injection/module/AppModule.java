package com.devitis.mvp_v1.injection.module;

import com.devitis.mvp_v1.app.App;
import com.devitis.mvp_v1.injection.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Diana on 20.03.2019.
 */
@Module
public class AppModule {

    private final App app;


    public AppModule(App app) {
        this.app = app;
    }

    @ApplicationScope
    @Provides
    App provideApplicationContext() {
        return app;
    }


}
