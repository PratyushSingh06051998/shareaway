package com.example.pratyushsingh.shareaway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class loginactivity extends AppCompatActivity {

    EditText uanme;
    EditText pass;
    Button Login;
    Button Signup;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        uanme = (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.pass);
        Login = (Button) findViewById(R.id.login);
        Signup = (Button) findViewById(R.id.signup);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = uanme.getText().toString();
                password = pass.getText().toString();

                RetrofitCreator retrofitCreator = new RetrofitCreator();
                Retrofit retrofit = retrofitCreator.retrofitcreate();

                APIInterface apiInterface = retrofit.create(APIInterface.class);
                Call<LoginStructure> call = apiInterface.login(email,password);
                call.enqueue(new Callback<LoginStructure>() {
                    @Override
                    public void onResponse(Call<LoginStructure> call, Response<LoginStructure> response) {
                        if(response.body()!=null){

                            LoginStructure ls = response.body();

                            if(ls.getStatus().equals("SUCCESS")){
                                Toast.makeText(loginactivity.this,"SUCCESS",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(loginactivity.this,"SOMETHING WENT ERONG TRY AGAIN LATER",Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(loginactivity.this,"SOMETHING WENT ERONG TRY AGAIN LATER",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginStructure> call, Throwable t) {

                    }
                });

            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loginactivity.this,SignupActivity.class);
                startActivity(i);
            }
        });

    }
}
