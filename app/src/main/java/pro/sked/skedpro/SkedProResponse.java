package pro.sked.skedpro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daemmon on 10/25/16.
 */

public class SkedProResponse <T> {

    @SerializedName("success")
    public String success;

    //@SerializedName("object")
    public T object;

}
