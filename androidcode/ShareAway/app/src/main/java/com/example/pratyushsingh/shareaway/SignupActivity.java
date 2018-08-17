package com.example.pratyushsingh.shareaway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignupActivity extends AppCompatActivity {

    EditText Name;
    EditText Phonenumber;
    EditText Sex;
    EditText Email;
    EditText Password;
    Button Signup;
    String name;
    String pnumebr;
    String sex;
    String  email;
    String pas;
    String Fcm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Name = (EditText) findViewById(R.id.name);
        Phonenumber = (EditText) findViewById(R.id.number);
        Sex = (EditText) findViewById(R.id.sex);
        Email = (EditText) findViewById(R.id.email);
        Password  = (EditText) findViewById(R.id.password);
        Signup = (Button) findViewById(R.id.signup);
        Fcm = String.valueOf(FirebaseInstanceId.getInstance().getToken());

        Log.i("khbsvkbsr",String.valueOf(FirebaseInstanceId.getInstance().getToken()));

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = Name.getText().toString();
                pnumebr  = Phonenumber.getText().toString();
                sex = Sex.getText().toString();
                email = Email.getText().toString();
                pas = Password.getText().toString();
                Log.i("kfbsekfbsduk",String.valueOf(name));

                RetrofitCreator retrofitCreator = new RetrofitCreator();
                Retrofit retrofit = retrofitCreator.retrofitcreate();

                APIInterface apiInterface = retrofit.create(APIInterface.class);
                Call<LoginStructure> call = apiInterface.signup(name,email,pas,pnumebr,sex,Fcm);
                call.enqueue(new Callback<LoginStructure>() {
                    @Override
                    public void onResponse(Call<LoginStructure> call, Response<LoginStructure> response) {
                        if(response.body()!=null){
                            LoginStructure s = response.body();

                            if(s.getStatus().equals("SUCCESS")){
                                Toast.makeText(SignupActivity.this,"SUCCESS",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(SignupActivity.this,"Something went wrong. Please try again later",Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(SignupActivity.this,"Something went wrong. Please try again later",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginStructure> call, Throwable t) {
                        Toast.makeText(SignupActivity.this,"Something went wrong. Please try again later",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}
