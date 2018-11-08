package com.multiplica.cleanarchitecture.simplemvpapplication.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 07/11/18.
 */

public class ResponseQueryFeatureGeometry {


    @SerializedName("type")
    @Expose
    String type;

    @SerializedName("coordinates")
    @Expose
    double[] coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

}
