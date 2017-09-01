package com.example.pacman.first_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 123 on 8/31/2017.
 */

public class MyDatabase extends AppCompatActivity{

    EditText pname,pno;
    Button save;
    Button showlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydatabase);
        init();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySQLiteOpenHelper myhelper=new MySQLiteOpenHelper(getApplicationContext(),"mydb",null,1);
               if( myhelper.insertRow(pname.getText().toString(),pno.getText().toString()))
                   Toast.makeText(getApplicationContext(),"Saved successfully",Toast.LENGTH_LONG).show();
               else
                   Toast.makeText(getApplicationContext(),"Not Saved successfully",Toast.LENGTH_LONG).show();


            }
        });


        showlist.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(MyDatabase.this,ActivityList.class);
                                            startActivity(intent);
                                        }
                                    }

        );

    }

    private void init() {


        pname=(EditText)findViewById(R.id.pname);
        pno=(EditText)findViewById(R.id.pno);
        showlist=(Button)findViewById(R.id.showlist);
        save=(Button)findViewById(R.id.savebutton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case  R.id.home:Toast.makeText(getApplicationContext(),"this is home",Toast.LENGTH_SHORT).show();
            case  R.id.profile:Toast.makeText(getApplicationContext(),"this is home",Toast.LENGTH_SHORT).show();
            case  R.id.settings:Toast.makeText(getApplicationContext(),"this is home",Toast.LENGTH_SHORT).show();


        }

        return super.onOptionsItemSelected(item);
    }
}
