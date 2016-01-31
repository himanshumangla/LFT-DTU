package com.himanshu.lft_dtu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Himanshu on 12/25/2015.
 */
public class ContactUs extends ActionBarActivity implements View.OnClickListener{
    EditText email, subject, text;
    Button send;
    String semail, ssubject, stext;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        initialise();
        send.setOnClickListener(this);
    }

    private void initialise() {
        email = (EditText) findViewById(R.id.etemail);
        text = (EditText) findViewById(R.id.ettext);
        subject = (EditText) findViewById(R.id.etsubject);
        send = (Button) findViewById(R.id.bsend);
    }

    @Override
    public void onClick(View v) {
        makeStrings();
        String [] emails= {semail};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, ssubject);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_TEXT, stext);
        startActivity(emailIntent);
    }

    private void makeStrings() {
        semail = email.getText().toString();
        ssubject = subject.getText().toString();

        stext = text.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.options,menu);
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
                Toast.makeText(this, "Exiting now. Thank You!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
