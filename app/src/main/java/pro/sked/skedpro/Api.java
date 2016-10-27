package pro.sked.skedpro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Bondint on 23.10.2016.
 */

public interface Api {

    @FormUrlEncoded
    @POST("/create_user.php")
   // Call<Object> CreateUser (@FieldMap Map<String, String> map);
    Call<RespMessage> CreateUser(@Field("login") String login, @Field("password") String password, @Field("email") String email, @Field("name") String name);

    @GET("/get_items.php")
    Call <List<GetItems>> getItems(@Query("user_name") String user_name);

    @GET("/get_user.php")
    Call <RespMessage> getUser(@Query("login") String login, @Query("password") String password);
}
