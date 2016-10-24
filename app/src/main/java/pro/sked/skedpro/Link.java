package pro.sked.skedpro;

import java.util.Map;

import retrofit.http.FieldMap;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Bondint on 23.10.2016.
 */

public interface Link {

    @FormUrlEncoded
    //@GET("get_user.php")
    @POST("create_user.php")
    Call<Object> CreateUser (@FieldMap Map <String, String> map);

}
