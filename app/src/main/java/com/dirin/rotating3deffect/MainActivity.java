package com.dirin.rotating3deffect;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    private Animation animation1;
    private Animation animation2;

    private boolean isBack = true;
    private ImageView imViewAnimation;
    private Button btnStartAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        animation1 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                if (isBack){
                    imViewAnimation.setImageResource(R.drawable.front);
                    imViewAnimation.clearAnimation();
                    imViewAnimation.setAnimation(animation2);
                    imViewAnimation.startAnimation(animation2);
                } else {
                    imViewAnimation.setImageResource(R.drawable.back);
                    imViewAnimation.clearAnimation();
                    imViewAnimation.setAnimation(animation2);
                    imViewAnimation.startAnimation(animation2);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



        animation2 = AnimationUtils.loadAnimation(this, R.anim.from_middle);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                if (isBack){
                    isBack = false;
                } else {
                    isBack = true;
                }

                btnStartAnim.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imViewAnimation = (ImageView) findViewById(R.id.imViewAnimation);


        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_rotate);

        btnStartAnim = (Button) findViewById(R.id.btnStartAnim);
        btnStartAnim.setSoundEffectsEnabled(false);

        btnStartAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);

                mp.setVolume(1,1);
                mp.start();

                if (isBack){
                    imViewAnimation.setImageResource(R.drawable.back);
                } else {
                    imViewAnimation.setImageResource(R.drawable.front);
                }

                imViewAnimation.clearAnimation();
                imViewAnimation.setAnimation(animation1);
                imViewAnimation.startAnimation(animation1);

            }
        });




    }






}
