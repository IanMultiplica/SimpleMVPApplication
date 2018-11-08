package com.multiplica.cleanarchitecture.simplemvpapplication;

import android.util.Log;

import com.multiplica.cleanarchitecture.simplemvpapplication.entity.EarthquakeEntity;
import com.multiplica.cleanarchitecture.simplemvpapplication.network.IWebServices;
import com.multiplica.cleanarchitecture.simplemvpapplication.network.RetrofitClient;
import com.multiplica.cleanarchitecture.simplemvpapplication.network.response.ResponseQuery;
import com.multiplica.cleanarchitecture.simplemvpapplication.network.response.ResponseQueryFeature;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by user on 07/11/18.
 */

public class ListInteractorImpl implements IListInterface.Interactor{


    private IListInterface.Presenter presenter;


    public ListInteractorImpl(IListInterface.Presenter presenter){
        this.presenter = presenter;
    }

    public void getEarthquakeList(String startDate, String endDate) {
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        Observable<ResponseQuery> request = retrofit.create(IWebServices.class).query("geojson",startDate,
                endDate,10);
        request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseQuery>() {

                    ArrayList<EarthquakeEntity> earthquakes = new ArrayList<EarthquakeEntity>();
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(ResponseQuery responseQuery) {
                        Log.i("RESPONSE: ",responseQuery.getType());
                        ArrayList<ResponseQueryFeature> features = responseQuery.getFeatures();

                        int id = 1;

                        for (ResponseQueryFeature feature: features) {
                            EarthquakeEntity earthquake = new EarthquakeEntity();

                            earthquake.setId(id);
                            earthquake.setPlace(feature.getProperties().getPlace());
                            earthquake.setTime(feature.getProperties().getTime());
                            earthquake.setTitle(feature.getProperties().getTitle());
                            earthquake.setLatitude(feature.getGeometry().getCoordinates()[0]);
                            earthquake.setLongitude(feature.getGeometry().getCoordinates()[1]);
                            earthquakes.add(earthquake);

                            id++;
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i("FAILURE: ",e.getMessage());
                        //callback.onError(new Exception(),e.getMessage());
                        presenter.showMessageError("FAILURE");
                    }
                    @Override
                    public void onComplete() {
                        Log.i("COMPLETE: ","READY!!!");
                        presenter.showList(earthquakes);
                        //callback.onSuccess(earthquakes);
                    }
                });
    }
}
