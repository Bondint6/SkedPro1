package pro.sked.skedpro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class LoginUser extends Activity {

    private    Button btnRegister ;
    private    Button btnLogin;
    private    EditText Login;
    private    EditText Password;
               String Log;
    private    String Pass;

    private  SkedProAPIService service = SkedProAPIService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);

        btnRegister = (Button) findViewById(R.id.AddUser);
        btnLogin =(Button) findViewById(R.id.LogIn);
        Login = (EditText) findViewById(R.id.Login);
        Password = (EditText) findViewById(R.id.Password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log = Login.getText().toString();
                Pass= Password.getText().toString();

                Call<RespMessage> call = service.getApi().getUser(Login.getText().toString(),Password.getText().toString());
                call.enqueue(new Callback<RespMessage>() {
                    @Override
                    public void onResponse(Call<RespMessage> call, Response<RespMessage> response) {
                    if (response.body().success.equals("1"))
                        {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("Login", Login.getText().toString());
                            startActivity(intent);
                        }
                        else
                        {
                            Context context = getApplicationContext();
                            CharSequence text = response.body().message;
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RespMessage> call, Throwable t) {

                    }
                });


                //add user in BD
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddUser.class);
                startActivity(intent);
                //login
            }
        });


    }

}
