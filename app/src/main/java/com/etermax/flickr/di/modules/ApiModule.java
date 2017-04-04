package com.etermax.flickr.di.modules;

import com.etermax.flickr.api.services.PersonApi;
import com.etermax.flickr.api.services.PhotosApi;
import com.etermax.flickr.utils.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit retrofit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(Constant.URL_SERVER)
                .build();
    }

    @Provides
    @Singleton
    public PhotosApi photosApi(Retrofit retrofit) {
        return retrofit.create(PhotosApi.class);
    }

    @Provides
    @Singleton
    public PersonApi personApi(Retrofit retrofit) {
        return retrofit.create(PersonApi.class);
    }

}
