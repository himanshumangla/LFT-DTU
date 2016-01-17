package com.himanshu.lft_dtu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Himanshu on 12/25/2015.
 */
public class ContactUs extends Activity implements View.OnClickListener{
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

    protected void onPause(){
        super.onPause();
        finish();
    }
}
