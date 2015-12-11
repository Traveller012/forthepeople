package com.example.harish.forthepeople;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListDebates extends AppCompatActivity {

    int userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_debates);
        ListView mlistView = (ListView) findViewById(R.id.listDebates);

        userID = getIntent().getIntExtra("userID",-1);


        mlistView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                new String[] {"Watch Debate", "Play Vote Tinder"}));
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String sText = ((TextView) view).getText().toString();
                Intent intent = null;
                if (sText.equals("Watch Debate")) {
                    intent = new Intent(getBaseContext(),
                            VideoActivity.class);
                    intent.putExtra("userID",userID);
                }
                else if(sText.equals("Play Vote Tinder")) {
                    intent = new Intent(getBaseContext(),
                            VoteTinder.class);
                    intent.putExtra("userID",userID);
                }

                if (intent != null)
                    startActivity(intent);
            }
        });

    }
}
