package com.example.harish.forthepeople;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        final VideoView vidView = (VideoView)findViewById(R.id.myVideo);
        String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
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
                //start Previous Activity here

                finish();
            }
        });

        ImageView ib1=(ImageView)findViewById(R.id.imageView);
        View.OnClickListener ibLis1=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //START YOUR ACTIVITY HERE AS
                Toast.makeText(getApplicationContext(), "Happy !! "+vidView.getCurrentPosition()/1000.0+"s",
                        Toast.LENGTH_LONG).show();
            }
        };
        ImageView ib2=(ImageView)findViewById(R.id.imageView2);
        View.OnClickListener ibLis2=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //START YOUR ACTIVITY HERE AS
                Toast.makeText(getApplicationContext(), "Fear !! "+vidView.getCurrentPosition()/1000.0+"s",
                        Toast.LENGTH_LONG).show();
            }
        };
        ImageView ib3=(ImageView)findViewById(R.id.imageView3);
        View.OnClickListener ibLis3=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //START YOUR ACTIVITY HERE AS
                Toast.makeText(getApplicationContext(), "Sad !! "+vidView.getCurrentPosition()/1000.0+"s",
                        Toast.LENGTH_LONG).show();
            }
        };
        ImageView ib4=(ImageView)findViewById(R.id.imageView4);
        View.OnClickListener ibLis4=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //START YOUR ACTIVITY HERE AS
                Toast.makeText(getApplicationContext(), "Disgust !! "+vidView.getCurrentPosition()/1000.0+"s",
                        Toast.LENGTH_LONG).show();
            }
        };
        ImageView ib5=(ImageView)findViewById(R.id.imageView5);
        View.OnClickListener ibLis5=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //START YOUR ACTIVITY HERE AS
                Toast.makeText(getApplicationContext(), "Anger !! "+vidView.getCurrentPosition()/1000.0+"s",
                        Toast.LENGTH_LONG).show();
            }
        };
        ib1.setOnClickListener(ibLis1);
        ib2.setOnClickListener(ibLis2);
        ib3.setOnClickListener(ibLis3);
        ib4.setOnClickListener(ibLis4);
        ib5.setOnClickListener(ibLis5);

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
