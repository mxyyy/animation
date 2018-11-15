package com.bwie.animation;


import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBu;
    private Button btnShu;
    private ImageView imgShu;
    private ImageView imgBu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        btnShu = findViewById(R.id.btn_shu);
        btnBu = findViewById(R.id.btn_bu);
        imgShu = findViewById(R.id.img_shu);
        imgBu = findViewById(R.id.img_bu);
        btnBu.setOnClickListener(this);
        btnShu.setOnClickListener(this);
        imgShu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击真实的", Toast.LENGTH_SHORT).show();
            }
        });
        imgBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击虚幻的", Toast.LENGTH_SHORT).show();
            }
        });
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_shu:
                //做平移动画,translationY,translationX new float[]{10f, 20f, 30f, 40f, 60f, 80f}
                ObjectAnimator translationY = ObjectAnimator.ofFloat(imgShu, "translationY", new float[]{0f, -800f});
                translationY.setDuration(4000);
                translationY.setRepeatMode(ObjectAnimator.RESTART);

                translationY.start();


                break;

            case R.id.btn_bu:
                code();

                  break;
        }
    }

    private void code() {
        TranslateAnimation translateAnimation1 = new TranslateAnimation(0, 0, 0, -800);

        translateAnimation1.setDuration(6000);
        translateAnimation1.setInterpolator(new DecelerateInterpolator());
        imgBu.startAnimation(translateAnimation1);
        translateAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation.setFillAfter(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }


        });
    }

}
