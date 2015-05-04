package tap.allindevelopment.com.tap;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import java.util.Random;

/**
 * Created by Kevin on 27/02/15.
 */
public class GameActivity extends Activity {

    ImageView image;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    TextView totalpoints;
    Typeface fontPoints;
    Integer   globalPoints;
    CountDownTimer lol;
    int check_final = 0;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game);

            displayMap(0);
        }

        public void EndGame()
        {
            final ImageView tapLogo = (ImageView) findViewById(R.id.logo);
            final ImageView image = (ImageView) findViewById(R.id.imageView);
            final ImageView image2 = (ImageView) findViewById(R.id.imageView2);
            final ImageView image3 = (ImageView) findViewById(R.id.imageView3);
            final ImageView image4 = (ImageView) findViewById(R.id.imageView4);
            TextView score = (TextView) findViewById(R.id.points);
            RoundCornerProgressBar barProg = (RoundCornerProgressBar) findViewById(R.id.progress_1);
            barProg.setProgress(0);
            if (check_final == 1)
                lol.onFinish();
            barProg.setVisibility(View.INVISIBLE);
            image.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.INVISIBLE);
            image3.setVisibility(View.INVISIBLE);
            image4.setVisibility(View.INVISIBLE);
            moveLogo(tapLogo);
            moveScore(score);
            score.setTextSize(40);
        }

        private void moveLogo( View view )
        {
            TranslateAnimation anim = new TranslateAnimation( 0, 0, 0, -600);
            anim.setDuration(700);
            anim.setFillAfter(true);
            view.startAnimation(anim);
        }

    private void moveLogo2( View view )
    {
        Display display = getWindowManager().getDefaultDisplay();
        double height = (display.getHeight()) * -1;
        TranslateAnimation anim = new TranslateAnimation( 0, 0, 0, (float)height);
        anim.setDuration(700);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }

    private void moveScore( View view )
    {
        TranslateAnimation anim = new TranslateAnimation( 0, 0, 0, 500);
        anim.setDuration(700);
        anim.setFillAfter( true );
        view.startAnimation(anim);
    }


    private void moveScore2( View view )
    {
        TranslateAnimation anim = new TranslateAnimation( 0, 0, 0, -500);
        anim.setDuration(700);
        anim.setFillAfter( true );
        view.startAnimation(anim);
    }

    private void setMyCube(ImageView img, Integer not)
    {
        if (img.getImageAlpha() == 255) {
            img.setImageAlpha(0);
            Random r = new Random();
            globalPoints += 1;
            totalpoints.setText("Score: " + Integer.toString(globalPoints));
            int i = r.nextInt(4);
            while (i == not - 1)
                i = r.nextInt(4);
            if (i == 0) {
                image.setImageAlpha(255);
            } else if (i == 1) {
                image2.setImageAlpha(255);
            } else if (i == 2) {
                image3.setImageAlpha(255);
            } else if (i == 3) {
                image4.setImageAlpha(255);
            }
        } else {
            check_final = 1;
            EndGame();
        }
    }

    public void displayMap(int pos)
        {
            ImageView square = (ImageView) findViewById(R.id.square);
            square.setVisibility(View.VISIBLE);
            square.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    ImageView square = (ImageView) findViewById(R.id.square);
                    square.setVisibility(View.INVISIBLE);
                    square.setClickable(false);

                    fontPoints = Typeface.createFromAsset(getAssets(), "fonts/pixel.ttf");

                    globalPoints = 0;
                    totalpoints = (TextView) findViewById(R.id.points);
                    totalpoints.setTypeface(fontPoints);
                    totalpoints.setText("Score: " + Integer.toString(globalPoints));
                    image = (ImageView) findViewById(R.id.imageView);
                    image2 = (ImageView) findViewById(R.id.imageView2);
                    image3 = (ImageView) findViewById(R.id.imageView3);
                    image4 = (ImageView) findViewById(R.id.imageView4);
                    image.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.VISIBLE);
                    image3.setVisibility(View.VISIBLE);
                    image4.setVisibility(View.VISIBLE);
                    image.setImageResource(R.drawable.square);
                    image2.setImageResource(R.drawable.square);
                    image3.setImageResource(R.drawable.square);
                    image4.setImageResource(R.drawable.square);
                    Random r = new Random();
                    image.setImageAlpha(0);
                    image2.setImageAlpha(0);
                    image3.setImageAlpha(0);
                    image4.setImageAlpha(0);
                    int i = r.nextInt(4);
                    if (i == 0) {
                        image.setImageAlpha(255);
                    } else if (i == 1) {
                        image2.setImageAlpha(255);
                    } else if (i == 2) {
                        image3.setImageAlpha(255);
                    } else if (i == 3) {
                        image4.setImageAlpha(255);
                    }

                    image.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    setMyCube(image, 1);
                                    return true;
                            }
                            return false;
                        }
                    });

                    image2.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    setMyCube(image2, 2);
                                    return true;
                            }
                            return false;
                        }
                    });

                    image3.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    setMyCube(image3, 3);
                                    return true;
                            }
                            return false;
                        }
                    });

                    image4.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    setMyCube(image4, 4);
                                    return true;
                            }
                            return false;
                        }
                    });


                    int test = 100;
                    lol = new CountDownTimer(20000, 100) {

                        public void onTick(long millisUntilFinished) {
                            RoundCornerProgressBar progress2 = (RoundCornerProgressBar) findViewById(R.id.progress_1);
                            double progress1 = (millisUntilFinished  / 1000.000) *  5.000;
                            progress2.setProgress((float)progress1);
                        }

                        public void onFinish() {
                            RoundCornerProgressBar progress2 = (RoundCornerProgressBar) findViewById(R.id.progress_1);
                            progress2.setProgress(0);
                            if (check_final == 0)
                                EndGame();
                            Log.i("temps :", "done!");
                        }
                    }.start();
                }
            });
        }
}
