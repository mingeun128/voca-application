package com.voca_application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    Animation growAnim;
    ImageView vocaImg;
    ImageView flowerImg;
    private static final String TAG = SplashActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        vocaImg = findViewById(R.id.voca_text);
        flowerImg = findViewById(R.id.flower);
        Intent intent = new Intent(this,MainActivity.class);
        growAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.grow);
        growAnim.setAnimationListener(new Animation.AnimationListener(){
            public void onAnimationEnd(Animation animation){
                startActivity(intent);
                finish();
            }
            public void onAnimationStart(Animation animation){;}
            public void onAnimationRepeat(Animation animation){;}
        });
        //growAnim.setInterpolator(getApplicationContext(), android.R.anim.accelerate_interpolator);
        //vocaImg.startAnimation(growAnim);
        try {
            flowerImg.startAnimation(growAnim);
        }
        catch (NullPointerException e){
            Log.d(TAG,"ANIMATION ERROR");
        }
    }
}
