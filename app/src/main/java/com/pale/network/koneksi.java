package com.pale.network;

public class koneksi {

    public static final String BASE_URL_API = "http://192.168.43.249:1702/api/";

    public static BaseApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API)
                .create(BaseApiService.class);
    }

}
