package pro.sked.skedpro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bondint on 25.10.2016.
 */

public class GetItems {
    @SerializedName("user_name")
    public String user;

    @SerializedName("items")
    public String items;

    @SerializedName("counts")
    public String counts;

     @SerializedName("created_at")
    public String created;

}
