package com.himanshu.lft_dtu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Himanshu on 1/26/2016.
 */
public class customTeam extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_team);

        String[] team = {"Sonal Chopra\nCollege Head \n2nd year, IT", "Himanshu Mangla\nFounder & Technical Head\n2nd year, COE", "Aashima Garg\nContent Writer\n2nd year, PCT", "Akshat Jain\n2nd year, PCT", "Shivani Aggarwal\n2nd year, COE", "Pratik Singh\n2nd year, IT", "Sarthak Rastogi\n2nd year, IT", "Shikha Asrani\n 2nd year, IT", "Shweta Garg\n2nd year, COE"};
        ListAdapter teamAdapter= new customAdapter(this, team);
        ListView teamCustom = (ListView) findViewById(R.id.lvteam);
        teamCustom.setAdapter(teamAdapter);

    }
}
