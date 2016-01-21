package com.himanshu.lft_dtu;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Himanshu on 12/18/2015.
 */
public class Menu extends ListActivity {

    String [] classes= {"AboutUs", "Team" , "Events", "ContactUs"};

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));

    }
    protected void onListItemClick(ListView l , View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        String currentClassName = classes[position];
        try {
            Class currentClass = Class.forName("com.himanshu.lft_dtu." + currentClassName);
            Intent ourIntent = new Intent(Menu.this, currentClass);
            startActivity(ourIntent);
        }catch(ClassNotFoundException e){
                e.printStackTrace();
        }
    }


}
