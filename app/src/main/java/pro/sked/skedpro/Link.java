package pro.sked.skedpro;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Bondint on 23.10.2016.
 */

public interface Link {

    @FormUrlEncoded
    //@GET("get_user.php")
    @POST("/create_user.php")
   // Call<Object> CreateUser (@FieldMap Map<String, String> map);
    Call<RespMessage> CreateUser(@Field("login") String login, @Field("password") String password, @Field("email") String email, @Field("name") String name);

}
