package com.example.apina.di;

import com.example.apina.data.repo.YemekDaoRepository;
import com.example.apina.retrofit.ApiUtils;
import com.example.apina.retrofit.YemekDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module

@InstallIn(SingletonComponent.class)
public class AppModule {


    @Singleton
    @Provides
    public YemekDaoRepository provideYemekDaoRepository(YemekDao ydao){
        return new YemekDaoRepository(ydao);


    }

    @Singleton
    @Provides
    public YemekDao provideYemekDao(){
        return ApiUtils.getYemekDao();
    }






}
