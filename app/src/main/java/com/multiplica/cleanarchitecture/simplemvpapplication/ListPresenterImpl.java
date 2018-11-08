package com.multiplica.cleanarchitecture.simplemvpapplication;

import com.multiplica.cleanarchitecture.simplemvpapplication.entity.EarthquakeEntity;

import java.util.ArrayList;

/**
 * Created by user on 07/11/18.
 */

public class ListPresenterImpl implements IListInterface.Presenter{

    private IListInterface.View view;
    private IListInterface.Interactor interactor;

    public ListPresenterImpl(IListInterface.View view){
        this.view = view;
        this.interactor = new ListInteractorImpl(this);
    }

    @Override
    public void onGetEarthquakes() {
        interactor.getEarthquakeList("","");
    }

    @Override
    public void showList(ArrayList<EarthquakeEntity> earthquakes) {
        if(view!=null && earthquakes.size()>0){
            view.showList(earthquakes);
        }
    }

    @Override
    public void showMessageError(String error) {
        if(view!=null){
            view.showMessageError(error);
        }
    }
}
