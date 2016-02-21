package com.himanshu.lft_dtu;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Himanshu on 12/18/2015.
 */
public class Menu extends ListActivity  {

    String [] classes= {"About DTU","About LFT", "Team" , "Events", "Campaigns", "Contact Us","Custom Team","Register","FirstPage"};

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
        Toast.makeText(Menu.this, "Welcome!", Toast.LENGTH_SHORT).show();

    }
    protected void onListItemClick(ListView l , View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        String [] classes1= {"AboutDTU","AboutUs", "Team" , "Events", "Campaigns", "ContactUs","customTeam", "Register","FirstPage"};

        String currentClassName = classes1[position];
        try {
            Class currentClass = Class.forName("com.himanshu.lft_dtu." + currentClassName);
            Intent ourIntent = new Intent(Menu.this, currentClass);
            startActivity(ourIntent);
        }catch(ClassNotFoundException e){
                e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        switch (id){
            case R.id.item1:

                break;
            case R.id.item2:

                break;
            case R.id.item3:

                break;
            case R.id.Exit:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
