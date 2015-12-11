package com.example.harish.forthepeople;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;

public class PollResult extends AppCompatActivity {

    int userID;
    float moderator_rating;
    int politician_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        userID = getIntent().getIntExtra("userID", -1);
        moderator_rating = getIntent().getFloatExtra("moderator_rating", -1);
        politician_selected = getIntent().getIntExtra("politician_selected", -1);

        Log.d("d", "" + userID + " " + moderator_rating + " " + politician_selected);


        Button pollResultsBtn=(Button)findViewById(R.id.playVoteTinderBtn);

        pollResultsBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent myIntent = new Intent(PollResult.this, VoteTinder.class);
                myIntent.putExtra("userID", userID); //Optional parameters
                PollResult.this.startActivity(myIntent);
            }
        });



        SQLiteDatabase db= openOrCreateDatabase("forThePeopleDB", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS myPollTable( userID int(3), politician_selected int(6), moderator_rating float(3))");


        Cursor c=db.rawQuery("select * from myPollTable", null);

        c.moveToFirst();

        Log.d("d", c.toString());

        int[] politicians = new int[4];
        if (c != null) {
            while (c.moveToNext()) {
                Log.d("user ID: ",c.getString(c.getColumnIndex("userID")));
                Log.d("politician selected: ",c.getString(c.getColumnIndex("politician_selected")));
                Log.d("moderator rating: ", c.getString(c.getColumnIndex("moderator_rating")));
                politicians[c.getInt(c.getColumnIndex("politician_selected"))]++;
            }
            c.close();
        }

        int n1 = politicians[1];
        int n2 = politicians[2];
        int n3 = politicians[3];

        int politician_selected = -1;

        if(n1>=n2 && n1>=n3)
            politician_selected = 1;
        else if(n2>=n3 && n2>=n1)
            politician_selected = 2;
        else
            politician_selected = 3;



        c=db.rawQuery("select avg(moderator_rating) as Result from myPollTable", null);
        c.moveToFirst();

        Float moderator_rating=c.getFloat(c.getColumnIndex("Result"));
        Log.d("d", moderator_rating+"");

//        while(c!=null && ifused=="true")
//        {
//            c.moveToNext();
//        }
//
//        if(c==null)
//        {
//            db.execSQL("update mydbNEW set used='false' where used='true'");
//        }
//        else
//        {
//            para=c.getString(c.getColumnIndex("para"));
//            para=para.replace("*X",names[player_no]);
//        }
//
//        for(int i=0;i<names.length ;i++)
//        {
//            Log.d("blah", i + " "+player_no+ gender[player_no]+" "+gender[i]);
//
//            if( i!=player_no & gender[player_no]!=gender[i])
//                para=para.replace("*G",names[i]);
//        }
//        EditText et= (EditText) findViewById(R.id.mytext);
//        et.setText(para);


        db.close();


        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar);;
        bar.setRating(moderator_rating); //Optional parameters
        ImageView winner=(ImageView)findViewById(R.id.winner);

        switch (politician_selected) {
            case 1:
                winner.setImageResource(R.drawable.ben_carson);
                break;
            case 2:
                winner.setImageResource(R.drawable.donald_trump);
                break;
            case 3:
                winner.setImageResource(R.drawable.carly_fi);
                break;
        }


    }
}
