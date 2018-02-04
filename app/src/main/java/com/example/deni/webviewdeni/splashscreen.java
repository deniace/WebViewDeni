package com.example.deni.webviewdeni;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Aris on 04/02/2018.
 */

public class splashscreen extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstancesState)
    {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.splashscreen);

        handler = new Handler();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashscreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },300);
    }

}
