package pro.sked.skedpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bondint on 21.10.2016.
 */

public class AddUser extends Activity {

    private ProgressDialog pDialog;

    private    Button btnOk ;
    private    Button btnCancel;
    private    EditText Login;
    private    EditText Password;
    private    EditText Email;

    private final String URL = "http://sked.pro/";

    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL)
            .build();

    private Link intf = retrofit.create(Link.class);

    //private static String url_create_user = "http://sked.pro";

    //private static final String TAG_SUCCESS = "success";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        btnOk = (Button) findViewById(R.id.ok);
        btnCancel = (Button) findViewById(R.id.cancel);
        Login = (EditText) findViewById(R.id.Login);
        Password = (EditText) findViewById(R.id.Password);
        Email = (EditText) findViewById(R.id.Email);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("login", Login.getText().toString());
                mapJson.put("password", Password.getText().toString());
                mapJson.put("email=", Email.getText().toString());
                mapJson.put("name=", "Bondint_Test");





/*
                Call<Object> call = intf.CreateUser(mapJson);
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        
                    }
                });


*/
                Call<Object> call = intf.CreateUser(mapJson);

                try {

                    Response<Object> response = call.execute();
                    Map<String, String> map = gson.fromJson(response.body().toString(), Map.class);
                    for (Map.Entry e : map.entrySet())
                    {
                    System.out.println(e.getKey()+" "+ e.getValue());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


               /* Response r = intf.CreateUser("login="+Login.getText().toString(), "password="+Password.getText().toString(), "email="+Email.getText().toString(), "name=Bondint");
                String sss = gson.fromJson(r.body().toString(),String.class);
                System.out.println(sss); */
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  finish();
            }
        });






    }
}
