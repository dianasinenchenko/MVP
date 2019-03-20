package com.devitis.mvp_v1.injection.component;

import com.devitis.mvp_v1.app.App;
import com.devitis.mvp_v1.injection.module.AppModule;
import com.devitis.mvp_v1.injection.scope.ApplicationScope;

import dagger.Component;

/**
 * Created by Diana on 20.03.2019.
 */
@ApplicationScope
@Component(modules = {AppModule.class})
public interface IAppComponent {

    final class Initialize {
        public static IAppComponent init(App app) {
            return DaggerAppComponent.builder().appModule(new AppModule(app)).build();
        }


    }
}
