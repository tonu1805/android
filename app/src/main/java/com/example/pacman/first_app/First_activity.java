package com.example.pacman.first_app;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by PacMan on 8/29/2017.
 */

public class First_activity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        AssetManager assetManager=getAssets();
        Typeface abc=Typeface.createFromAsset(assetManager, "font/xanadu.ttf");
        final Button btn=(Button) findViewById(R.id.first_btn);
        btn.setTypeface(abc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hi);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent=new Intent(getApplicationContext(),second_activity.class);
                        startActivity(intent);

                        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                btn.startAnimation(animation);

                Vibrator vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            MediaPlayer mediaPlayer= MediaPlayer.create(getApplicationContext(),R.raw.button);
            mediaPlayer.start();


            }
        });
    }
}
