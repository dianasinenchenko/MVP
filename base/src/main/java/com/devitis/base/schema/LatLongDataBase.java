package com.devitis.base.schema;

import com.devitis.base.base.ConfigDataBase;

/**
 * Created by Diana on 20.03.2019.
 */

public class LatLongDataBase extends ConfigDataBase {

    public static final String LATLONG_DB_NAME = "latlong_db";
    public static final int SCHEMA_VERSION = 0;

    @Override
    public String getName() {
        return LATLONG_DB_NAME;
    }

    @Override
    public long getSchemaVersion() {
        return SCHEMA_VERSION;
    }

    @Override
    public Object getModule() {
        return new LatLongModule();
    }
}
