package com.devitis.base.schema;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Diana on 20.03.2019.
 */

public class LatLong extends RealmObject {
    @PrimaryKey
    public int id;
    public String placeName;
    private Double placeLat;
    private Double placeLong;

    public LatLong(Double placeLat, Double placeLong) {
        this.placeLat = placeLat;
        this.placeLong = placeLong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Double getPlaceLat() {
        return placeLat;
    }

    public void setPlaceLat(Double placeLat) {
        this.placeLat = placeLat;
    }

    public Double getPlaceLong() {
        return placeLong;
    }

    public void setPlaceLong(Double placeLong) {
        this.placeLong = placeLong;
    }
}
