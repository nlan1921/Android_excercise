package com.huy.bubblegame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        Addevents();
    }

    int score;
    Random random=new Random();
    TextView txtScore;
    ViewGroup.LayoutParams params;
    LinearLayout layoutBubble;
    Button btnlevel1,btnlevel2,btnlevel3;
    ObjectAnimator objectAnimator;

    private void addControls() {
        txtScore=findViewById(R.id.txtscore);
        layoutBubble=findViewById(R.id.layoutBuble);
        btnlevel1=findViewById(R.id.btnlevel1);
        params=new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        btnlevel2=findViewById(R.id.btnlevel2);
        btnlevel3=findViewById(R.id.btnlevel3);

    }

    private void Addevents(){
        btnlevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anbtn();
                score=0;
                txtScore.setText("Điểm của bạn : "+ score);
                for (int i =0;i<=5;i++) {
                    if(i%2==0)
                    {
                        processAnimx();
                    }
                    else
                    {
                        processAnimy();
                    }

                }
            }
        });
        btnlevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anbtn();
                score=0;
                txtScore.setText("Điểm của bạn : "+ score);
                for (int i =0;i<=8;i++) {
                    if(i%2==0)
                    {
                        processAnimx();
                    }
                    else
                    {
                        processAnimy();
                    }
                }
            }
        });
        btnlevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anbtn();
                score=0;
                txtScore.setText("Điểm của bạn : "+ score);
                for (int i =0;i<=11;i++) {
                    if(i%2==0)
                    {
                        processAnimx();
                    }
                    else
                    {
                        processAnimy();
                    }
                }
            }
        });
    }

    @RequiresApi(api= Build.VERSION_CODES.JELLY_BEAN)
    private void processAnimy()
    {
        ImageView img=getImageView();

        img.setBackground(getDrawable());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutBubble.removeView(v);
                txtScore.setText("Điểm của bạn : "+(score+=1));
            }
        });
        objectAnimator=(ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.bubbleanimation);
        objectAnimator.setDuration(random.nextInt(1000)+2000);
        objectAnimator.setTarget(img);
        layoutBubble.addView(img,params);
        objectAnimator.addListener(new Animator.AnimatorListener()
        {

            @Override
            public void onAnimationStart(Animator animation) {


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                layoutBubble.removeView((View) ((ObjectAnimator)animation).getTarget());
                txtScore.setText("Bạn đã thua cuộc hãy thử lại ^^ ");
                hienbtn();
                if(score==6)
                {
                    txtScore.setText("Chúc mừng bạn chiến thắng : Điểm 6");
                }
                else if(score==9)
                {
                    txtScore.setText("Chúc mừng bạn chiến thắng : Điểm 9");
                }
                else if(score==12)
                {
                    txtScore.setText("Chúc mừng bạn chiến thắng : Điểm 12");
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {


            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();
    }
    private void processAnimx()
    {
        ImageView img=getImageView();

        img.setBackground(getDrawable());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutBubble.removeView(v);
                txtScore.setText("Điểm của bạn : "+(score+=1));
            }
        });
        objectAnimator=(ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.bubbleanimationx);
        objectAnimator.setDuration(random.nextInt(1000)+2000);
        objectAnimator.setTarget(img);
        layoutBubble.addView(img,params);
        objectAnimator.addListener(new Animator.AnimatorListener()
        {

            @Override
            public void onAnimationStart(Animator animation) {


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                layoutBubble.removeView((View) ((ObjectAnimator)animation).getTarget());
                txtScore.setText("Bạn đã thua cuộc hãy thử lại ^^ ");
                hienbtn();
                if(score==6)
                {
                    txtScore.setText("Chúc mừng bạn chiến thắng : Điểm 6");
                }
                else if(score==9)
                {
                    txtScore.setText("Chúc mừng bạn chiến thắng : Điểm 9");
                }
                else if(score==12)
                {
                    txtScore.setText("Chúc mừng bạn chiến thắng : Điểm 12");
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();
    }
    private Drawable getDrawable()
    {
        Drawable drawable;
        int i=random.nextInt(10);
        switch (i)
        {
            case 0: drawable=getResources().getDrawable(R.drawable.b1);
            break;
            case 1: drawable=getResources().getDrawable(R.drawable.b2);
                break;
            case 2: drawable=getResources().getDrawable(R.drawable.b3);
                break;
            case 3: drawable=getResources().getDrawable(R.drawable.b4);
                break;
            case 4: drawable=getResources().getDrawable(R.drawable.b5);
                break;
            case 5: drawable=getResources().getDrawable(R.drawable.b6);
                break;
            default: drawable=getResources().getDrawable(R.drawable.b7);
                break;
        }

        return drawable;
    }

    public ImageView getImageView()
    {
        ImageView img=new ImageView(MainActivity.this);

        img.setX(random.nextFloat());
        return img;
    }
    private void hienbtn()
    {
        btnlevel1.setVisibility(View.VISIBLE);
        btnlevel2.setVisibility(View.VISIBLE);
        btnlevel3.setVisibility(View.VISIBLE);
    }
    private void anbtn()
    {
        btnlevel1.setVisibility(View.INVISIBLE);
        btnlevel2.setVisibility(View.INVISIBLE);
        btnlevel3.setVisibility(View.INVISIBLE);
    }
}