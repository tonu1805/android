package com.example.pacman.first_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity
{
    ArrayList<person> persons;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();
       // initData();

        MySQLiteOpenHelper helper=new MySQLiteOpenHelper(getApplicationContext(),"mydb",null,1);
        persons=helper.fetchlist();
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),persons);
        listView.setAdapter(customAdapter);
    }

    private void init()
    {
        listView=(ListView)findViewById(R.id.list1);
    }

    private void initData()
    {
        persons=new ArrayList<person>();
        persons.add(new person(R.drawable.android,"RAM","12345233"));
        persons.add(new person(R.drawable.android,"sh","1234523"));
        persons.add(new person(R.drawable.android,"dsf","1234335"));
        persons.add(new person(R.drawable.android,"sada","12342345"));
        persons.add(new person(R.drawable.android,"adsd","12342345"));
        persons.add(new person(R.drawable.android,"dfsf","12342345"));
        persons.add(new person(R.drawable.android,"jhg","12342133435"));
        persons.add(new person(R.drawable.android,"jhgj","1234235445"));
        persons.add(new person(R.drawable.android,"khj","123423443535"));
        persons.add(new person(R.drawable.android,"nbmb","12342343455"));
        persons.add(new person(R.drawable.android,"nbmbh","123423434535"));

    }
}
