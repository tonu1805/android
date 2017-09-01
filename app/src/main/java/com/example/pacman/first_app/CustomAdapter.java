package com.example.pacman.first_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

/**
 * Created by 123 on 8/31/2017.
 */

public class CustomAdapter extends BaseAdapter
{
    Context context;
    ArrayList<person> persons;

    public CustomAdapter(Context context, ArrayList<person> persons)
    {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount()
    {
        return persons.size();
    }

    @Override
    public Object getItem(int i)
    {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    private class ViewHolder
    {

        ImageView personImage;
        TextView personName;
        TextView pesonMobile;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent)
    {
        ViewHolder holder=new ViewHolder();
        person p=(person) getItem(i);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView==null)
        {
            convertView=inflater.inflate(R.layout.rowlayout,parent,false);

            holder.personImage=(ImageView) convertView.findViewById(R.id.imageView2);
            holder.personName=(TextView) convertView.findViewById(R.id.text);
            holder.pesonMobile=(TextView)convertView.findViewById(R.id.text2);

            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder) convertView.getTag();

        holder.personImage.setImageResource(p.getImageid());
        holder.personName.setText(p.getPersonName());
        holder.pesonMobile.setText(p.getMobileNumber());

        return convertView;
    }
}
