package tap.allindevelopment.com.tap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
            final ImageView again = (ImageView) findViewById(R.id.replay);
            TextView score = (TextView) findViewById(R.id.points);
            RoundCornerProgressBar barProg = (RoundCornerProgressBar) findViewById(R.id.progress_1);

            barProg.setVisibility(View.INVISIBLE);
            image.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.INVISIBLE);
            image3.setVisibility(View.INVISIBLE);
            image4.setVisibility(View.INVISIBLE);
            moveLogo(tapLogo);
            moveScore(score);
            score.setTextSize(40);
            again.setVisibility(View.VISIBLE);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    // Actions to do after 10 seconds
                }
            }, 400);;
            again.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveLogo2(tapLogo);
                    moveScore2(again);
                    displayMap(0);
                }
            });
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
        TranslateAnimation anim = new TranslateAnimation( 0, 0, 0, 600);
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

                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (image.getImageAlpha() == 255) {
                                image.setImageAlpha(0);
                                Random r = new Random();
                                globalPoints += 1;
                                totalpoints.setText("Score: " + Integer.toString(globalPoints));
                                int i = r.nextInt(3);
                                if (i == 0) {
                                    image2.setImageAlpha(255);
                                } else if (i == 1) {
                                    image3.setImageAlpha(255);
                                } else if (i == 2) {
                                    image4.setImageAlpha(255);
                                }
                            } else {
                                EndGame();
                            }
                        }
                    });

                    image2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (image2.getImageAlpha() == 255) {
                                image2.setImageAlpha(0);
                                Random r = new Random();
                                globalPoints += 1;
                                totalpoints.setText("Score: " + Integer.toString(globalPoints));
                                int i = r.nextInt(3);
                                if (i == 0) {
                                    image.setImageAlpha(255);
                                } else if (i == 1) {
                                    image3.setImageAlpha(255);
                                } else if (i == 2) {
                                    image4.setImageAlpha(255);
                                }
                            } else {
                                EndGame();
                            }
                        }
                    });

                    image3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (image3.getImageAlpha() == 255) {
                                image3.setImageAlpha(0);
                                Random r = new Random();
                                globalPoints += 1;
                                totalpoints.setText("Score: " + Integer.toString(globalPoints));
                                int i = r.nextInt(3);
                                if (i == 0) {
                                    image.setImageAlpha(255);
                                } else if (i == 1) {
                                    image2.setImageAlpha(255);
                                } else if (i == 2) {
                                    image4.setImageAlpha(255);
                                }
                            } else {
                                EndGame();
                            }
                        }
                    });
                    image4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (image4.getImageAlpha() == 255) {
                                image4.setImageAlpha(0);
                                Random r = new Random();
                                globalPoints += 1;
                                totalpoints.setText("Score: " + Integer.toString(globalPoints));
                                int i = r.nextInt(3);
                                if (i == 0) {
                                    image.setImageAlpha(255);
                                } else if (i == 1) {
                                    image2.setImageAlpha(255);
                                } else if (i == 2) {
                                    image3.setImageAlpha(255);
                                }
                            } else {
                                EndGame();
                            }
                        }
                    });
                    int test = 100;
                    new CountDownTimer(20000, 100) {

                        public void onTick(long millisUntilFinished) {
                            RoundCornerProgressBar progress2 = (RoundCornerProgressBar) findViewById(R.id.progress_1);
                            progress2.setVisibility(View.VISIBLE);
                            double progress1 = (millisUntilFinished  / 1000.000) *  5.000;
                            progress2.setProgress((float)progress1);
                        }

                        public void onFinish() {
                            RoundCornerProgressBar progress2 = (RoundCornerProgressBar) findViewById(R.id.progress_1);
                            progress2.setProgress(0);
                            EndGame();
                            Log.i("temps :", "done!");
                        }
                    }.start();
                }
            });
        }
}
