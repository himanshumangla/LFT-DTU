package com.himanshu.lft_dtu;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Himanshu on 12/18/2015.
 */
public class Splash extends Activity {
    public static MediaPlayer song;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        song = MediaPlayer.create(Splash.this, R.raw.lft);
        song.start();
        Thread timer = new Thread() {
            public void run() {
                try{
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally{
                    Intent openMenu = new Intent("openMenu");
                    startActivity(openMenu);
                }
            }
        };
        timer.start();
    }

    protected void onDestroy(){
        super.onDestroy();
        song.release();
    }

}
