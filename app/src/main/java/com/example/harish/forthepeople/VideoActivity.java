package com.example.harish.forthepeople;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        userID = getIntent().getIntExtra("userID",-1);

        final VideoView vidView = (VideoView)findViewById(R.id.myVideo);
        //String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";

        String vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.debate_video; //do not add any extension

        Uri vidUri = Uri.parse(vidAddress);

        vidView.setVideoURI(vidUri);
        vidView.requestFocus();
        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);
        vidView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer arg0) {
                vidView.start();
            }
        });
        vidView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent myIntent = new Intent(VideoActivity.this, Poll.class);
                myIntent.putExtra("userID", userID); //Optional parameters
                VideoActivity.this.startActivity(myIntent);
            }
        });
//
//        ImageView ib1=(ImageView)findViewById(R.id.imageView);
//        View.OnClickListener ibLis1=new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //START YOUR ACTIVITY HERE AS
//                Toast.makeText(getApplicationContext(), "Happy !! "+vidView.getCurrentPosition()/1000.0+"s",
//                        Toast.LENGTH_LONG).show();
//            }
//        };
//        ImageView ib2=(ImageView)findViewById(R.id.imageView2);
//        View.OnClickListener ibLis2=new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //START YOUR ACTIVITY HERE AS
//                Toast.makeText(getApplicationContext(), "Fear !! "+vidView.getCurrentPosition()/1000.0+"s",
//                        Toast.LENGTH_LONG).show();
//            }
//        };
//        ImageView ib3=(ImageView)findViewById(R.id.imageView3);
//        View.OnClickListener ibLis3=new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //START YOUR ACTIVITY HERE AS
//                Toast.makeText(getApplicationContext(), "Sad !! "+vidView.getCurrentPosition()/1000.0+"s",
//                        Toast.LENGTH_LONG).show();
//            }
//        };
//        ImageView ib4=(ImageView)findViewById(R.id.imageView4);
//        View.OnClickListener ibLis4=new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //START YOUR ACTIVITY HERE AS
//                Toast.makeText(getApplicationContext(), "Disgust !! "+vidView.getCurrentPosition()/1000.0+"s",
//                        Toast.LENGTH_LONG).show();
//            }
//        };
//        ImageView ib5=(ImageView)findViewById(R.id.imageView5);
//        View.OnClickListener ibLis5=new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //START YOUR ACTIVITY HERE AS
//                Toast.makeText(getApplicationContext(), "Anger !! "+vidView.getCurrentPosition()/1000.0+"s",
//                        Toast.LENGTH_LONG).show();
//            }
//        };
//        ib1.setOnClickListener(ibLis1);
//        ib2.setOnClickListener(ibLis2);
//        ib3.setOnClickListener(ibLis3);
//        ib4.setOnClickListener(ibLis4);
//        ib5.setOnClickListener(ibLis5);


        final ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    image.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());

                    Log.d("d",vidView.getCurrentPosition()/1000.0+"s");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    image.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        image.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });

        final ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        image2.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    image2.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());

                    Log.d("d",vidView.getCurrentPosition()/1000.0+"s");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    image2.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        image2.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });

        final ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        image.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    image3.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());

                    Log.d("d",vidView.getCurrentPosition()/1000.0+"s");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    image3.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        image3.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });

        final ImageView image4 = (ImageView) findViewById(R.id.imageView4);
        image.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    image4.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());

                    Log.d("d",vidView.getCurrentPosition()/1000.0+"s");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    image4.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        image4.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });

        final ImageView image5 = (ImageView) findViewById(R.id.imageView5);
        image.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    image5.setColorFilter(Color.argb(50, 0, 0, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());

                    Log.d("d",vidView.getCurrentPosition()/1000.0+"s");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    image5.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                        image5.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
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
