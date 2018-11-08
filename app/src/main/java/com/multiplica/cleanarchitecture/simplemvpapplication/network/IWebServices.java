package com.multiplica.cleanarchitecture.simplemvpapplication.network;

import com.multiplica.cleanarchitecture.simplemvpapplication.network.response.ResponseQuery;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 07/11/18.
 */

public interface IWebServices {

    @GET(EndPointConf.QUERY)
    Observable<ResponseQuery> query(@Query("format") String format, @Query("starttime") String starttime,
                                    @Query("endtime") String endtime, @Query("limit") int limit);
}
