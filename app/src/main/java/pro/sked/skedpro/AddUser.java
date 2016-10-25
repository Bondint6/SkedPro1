package pro.sked.skedpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    String s;
//    private final String URL = "http://sked.pro/";
//
////    private Gson gson = new GsonBuilder().create();
////    private Retrofit retrofit = new Retrofit.Builder()
////            .addConverterFactory(GsonConverterFactory.create(gson))
////            .baseUrl(URL)
////            .build();
////
////    private Link intf = retrofit.create(Link.class);


    RespMessage Respmessage = new RespMessage();

    private  SkedProAPIService service = SkedProAPIService.getInstance();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Call<SkedProResponse<String>> call = service.getApi().getUserInfo();
        call.enqueue(new Callback<SkedProResponse<String>>() {
            @Override
            public void onResponse(Call<SkedProResponse<String>> call, Response<SkedProResponse<String>> response) {
                SkedProResponse<String> responseObject = response.
            }

            @Override
            public void onFailure(Call<SkedProResponse<String>> call, Throwable t) {

            }
        });

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

                Call<RespMessage> call = service.getApi().CreateUser(Login.getText().toString(),Password.getText().toString(),Email.getText().toString(),"Test");
                call.enqueue(new Callback <RespMessage>() {
                    @Override
                    public void onFailure(Call<RespMessage> call, Throwable t) {

                    }

                    @Override
                    public void onResponse(Call<RespMessage> call, Response<RespMessage> response) {

                        if (response.body().success.equals("1")){

                        //System.out.println(" "+Respmessage.message+" ");  // REsponse  response.body().toString() -> pro.sked.skedpro.RespMessage@53701324
                        Context context = getApplicationContext();
                        CharSequence text = response.body().message;
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        }
                       // RespMessage respmessage = gson.fromJson(response.body().toString(),RespMessage.class);

                        /*s = response.body().toString();
                        System.out.println(s);
                        if (s.equals("{=true}")) {
                            Context context = getApplicationContext();
                            CharSequence text = "User is created!";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }*/

                    }
                });


               // System.out.println();

                /*Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("login", Login.getText().toString());
                mapJson.put("password", Password.getText().toString());
                mapJson.put("email", Email.getText().toString());
                mapJson.put("name", "Bondint_test");

                Call<Object> call = intf.CreateUser(mapJson);
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {

                        RespMessage addUser = gson.fromJson(response.body().toString(),RespMessage.class);
                        //jsNewUser jsNewUser = gson.fromJson(response.body().toString(), pro.sked.skedpro.jsNewUser.class);

                        Map<String, String> map  =  gson.fromJson(response.body().toString(),Map.class);

                        for (Map.Entry e : map.entrySet())
                        {
                            System.out.println(e.getKey()+" "+ e.getValue());
                        }


                    }
                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        
                    }
                });

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
            */
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
