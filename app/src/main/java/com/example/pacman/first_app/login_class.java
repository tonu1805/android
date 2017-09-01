package com.example.pacman.first_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by PacMan on 9/1/2017.
 */

public class login_class extends AppCompatActivity{
    EditText email,password;
    Button login;
    SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        init();

        //For preserveing the Data in perticular text field even when the app is closed
        preferences = getSharedPreferences("myprefernces",MODE_PRIVATE);
        email.setText(preferences.getString("email",""));
        password.setText(preferences.getString("password",""));
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SharedPreferences.Editor editor = preferences.edit();
               editor.putString("email",email.getText().toString());
               editor.putString("password",password.getText().toString());
               editor.commit();
           }
       });
        //Till here
    }
    public void init() {
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.button);
    }

}
