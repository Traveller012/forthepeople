package com.example.harish.forthepeople;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

public class Poll extends AppCompatActivity {

    int userID;
    int politician_selected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);

        userID = getIntent().getIntExtra("userID",-1);

        final ImageView ben_carson=(ImageView)findViewById(R.id.politician1);
        final ImageView trump=(ImageView)findViewById(R.id.politician2);
        final ImageView carly=(ImageView)findViewById(R.id.politician3);

        ben_carson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ben_carson.setImageResource(R.drawable.ben_grey);
                trump.setImageResource(R.drawable.donald_trump);
                carly.setImageResource(R.drawable.carly_fi);
                politician_selected = 1;

            }
        });


        trump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ben_carson.setImageResource(R.drawable.ben_carson);
                trump.setImageResource(R.drawable.trump_grey);
                carly.setImageResource(R.drawable.carly_fi);
                politician_selected = 2;


            }
        });

        carly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ben_carson.setImageResource(R.drawable.ben_carson);
                trump.setImageResource(R.drawable.donald_trump);
                carly.setImageResource(R.drawable.carly_grey);

                politician_selected = 3;

            }
        });


        Button pollResultsBtn=(Button)findViewById(R.id.pollResults);

        pollResultsBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent myIntent = new Intent(Poll.this, PollResult.class);
                myIntent.putExtra("userID", userID); //Optional parameters
                myIntent.putExtra("politician_selected", politician_selected); //Optional parameters

                RatingBar bar = (RatingBar) findViewById(R.id.ratingBar);

                myIntent.putExtra("moderator_rating", bar.getRating()); //Optional parameters


                SQLiteDatabase db = openOrCreateDatabase("forThePeopleDB", MODE_PRIVATE, null);

                db.execSQL("CREATE TABLE IF NOT EXISTS myPollTable( userID int(3), politician_selected int(6), moderator_rating float(3))");
                db.execSQL("INSERT INTO myPollTable VALUES(" + userID + "," + politician_selected + "," + bar.getRating() + ");");


                db.close();

                Poll.this.startActivity(myIntent);
            }
        });

    }
}
