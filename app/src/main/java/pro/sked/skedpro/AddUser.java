package pro.sked.skedpro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Bondint on 21.10.2016.
 */

public class AddUser extends Activity {

    private    Button btnRegister ;
    private    Button btnLogin;
    private    EditText Login;
    private    EditText Password;
               String Log;
    private    String Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);

        btnRegister = (Button) findViewById(R.id.AddUser);
        btnLogin =(Button) findViewById(R.id.LogIn);
        Login = (EditText) findViewById(R.id.Login);
        Password = (EditText) findViewById(R.id.Password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log = Login.getText().toString();
                Pass= Password.getText().toString();
                //add user in BD
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                getIntent().putExtra("Log", Login.getText().toString());
                startActivity(i);

            }
        });

    }
}
