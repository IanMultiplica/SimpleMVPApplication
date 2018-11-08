package com.multiplica.cleanarchitecture.simplemvpapplication;

import com.multiplica.cleanarchitecture.simplemvpapplication.entity.EarthquakeEntity;

import java.util.ArrayList;

/**
 * Created by user on 07/11/18.
 */

public interface IListInterface {

    interface View{
        void showList(ArrayList<EarthquakeEntity> earthquakes);
        void showMessageError(String error);
    }

    interface Presenter{
        void onGetEarthquakes();
        void showList(ArrayList<EarthquakeEntity> earthquakes);
        void showMessageError(String error);
    }

    interface Interactor{
        void getEarthquakeList(String startDate, String endDate);
    }

}
