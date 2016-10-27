package pro.sked.skedpro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bondint on 25.10.2016.
 */

public class SkedProGetUser {

    @SerializedName("id")
    public String id;

    @SerializedName("login")
    public String login;

    @SerializedName("password")
    public String password;

}
