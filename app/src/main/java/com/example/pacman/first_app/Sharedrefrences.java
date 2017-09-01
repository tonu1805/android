package com.example.pacman.first_app;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Sharedrefrences extends AppCompatActivity {
 EditText email, password;
    Button button3;
    SharedPreferences preferences;
Spinner countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedrefrences);

        init();
        String [] items=getResources().getStringArray(R.array.myarray);
        preferences=getSharedPreferences("mypreferences",MODE_PRIVATE);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,items);
        countries.setAdapter(adapter);

        email.setText(preferences.getString("email",""));
        password.setText(preferences.getString("password",""));
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("email",email.getText().toString());
                editor.putString("password",password.getText().toString());
                editor.commit();
            }
        });
    }

    private void init() {
    email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        button3=(Button)findViewById(R.id.button3);
        countries=(Spinner)findViewById(R.id.spinner);
    }
}
