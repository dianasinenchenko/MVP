package com.devitis.base.base;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Diana on 20.03.2019.
 */

public abstract class ConfigDataBase {

    private RealmConfiguration realmConfiguration;

    public Realm getInstance(){
       if (realmConfiguration == null){
           synchronized (this){
               if (realmConfiguration == null){
                  realmConfiguration = new RealmConfiguration.Builder()
                          .name(getName())
                          .schemaVersion(getSchemaVersion())
                          .modules(getModule())
                          .build();
               }
           }
       }
       return Realm.getInstance(realmConfiguration);
    }



    public abstract String getName();

    public abstract long getSchemaVersion();

    public abstract Object getModule();
}
