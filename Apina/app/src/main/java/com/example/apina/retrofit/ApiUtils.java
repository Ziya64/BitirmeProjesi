package com.example.apina.retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://kasimadalan.pe.hu/";
    public static YemekDao getYemekDao(){                                         // Birden fazla interface olsaydı herbiri için ayrı ayrı yapıcaktık.
        return RetrofitClient.getClient(BASE_URL).create(YemekDao.class);
    }
}
