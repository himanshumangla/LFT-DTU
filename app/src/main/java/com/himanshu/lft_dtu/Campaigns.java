package com.himanshu.lft_dtu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Himanshu on 1/22/2016.
 */
public class Campaigns extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaigns);

        final String[] campaigns={"ADAR", "ADAPT", "Cleanathon", "Collection Drives", "Shramdaan"};
        ListAdapter campaignAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, campaigns);
        ListView campaignslist = (ListView) findViewById(R.id.lvcampaigns);
        campaignslist.setAdapter(campaignAdapter);

        campaignslist.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String[] campaigns1={"adar", "adapt", "cleanathon", "collectiondrives", "shramdan"};
                        String currentCampaign = campaigns1[position];
                        try {
                            Class currentClass = Class.forName("com.himanshu.lft_dtu." + currentCampaign);
                            Intent ourIntent = new Intent(Campaigns.this, currentClass);
                            startActivity(ourIntent);
                        }catch(ClassNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                }
        );
    }


}
