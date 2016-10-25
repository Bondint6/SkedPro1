package pro.sked.skedpro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bondint on 25.10.2016.
 */
public class SkedProAPIService {

    private static SkedProAPIService instance = null;

    private Link api = null;

    private final String URL = "http://sked.pro/";

    public static SkedProAPIService getInstance()
    {
        if (instance == null)
        {
            instance = new SkedProAPIService();
        }
        return instance;
    }

    private SkedProAPIService()
    {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(URL)
                .build();
        api =  retrofit.create(Link.class);
    }

    public Link getApi()
    {
        return api;
    }
}
