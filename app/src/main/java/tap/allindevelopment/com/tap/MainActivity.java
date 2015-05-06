package tap.allindevelopment.com.tap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity {

    ImageView image;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    TextView totalpoints;
    Typeface fontPoints;
    Integer   globalPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(getApplicationContext(), "MainActivity",
          //      Toast.LENGTH_LONG).show();
       ImageView play = (ImageView) findViewById(R.id.play_btn);
        play.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                ImageView test2 = (ImageView) findViewById( R.id.test33 );
                Log.i("log", "object ->  "+test2);
                moveAnim(test2);
                test2 = (ImageView) findViewById( R.id.play_btn );
                moveAnim(test2);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        ImageView test3 = (ImageView) findViewById( R.id.logo);
                        moveAnimLogo(test3);
                        // Actions to do after 10 seconds
                    }
                }, 400);
                Handler handler2 = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        gameNow();   // Actions to do after 10 seconds
                    }
                }, 1400);
            }
        });
    }

    private void gameNow()
    {
        int pos;
        int min = 1;
        int max = 4;

        Random r = new Random();
        pos = r.nextInt(max - min + 1) + min;
        pos = 0;
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void moveAnim(View view)
    {
        Display display = getWindowManager().getDefaultDisplay();
        double height = display.getHeight()/2.1000;
        TranslateAnimation anim = new TranslateAnimation( 0, 0, 0, (float)height);
        anim.setDuration(700);
        anim.setFillAfter( true );
        view.startAnimation(anim);
    }

    private void moveAnimLogo(View view)
    {
        Display display = getWindowManager().getDefaultDisplay();
        double height = display.getHeight()/2.1000;
        TranslateAnimation anim = new TranslateAnimation( 0, 0, 0, (float)height);
        anim.setDuration(1000);
        anim.setFillAfter( true );
        view.startAnimation(anim);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
