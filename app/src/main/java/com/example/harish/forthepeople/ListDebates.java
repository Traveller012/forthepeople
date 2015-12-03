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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_debates);
        ListView mlistView = (ListView) findViewById(R.id.listDebates);
        mlistView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                new String[] {"GOP Debate", "Republican Debate", "Democratic Debate"}));
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text Game, Help, Home
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT);//.show();
                String sText = ((TextView) view).getText().toString();
                Intent intent = null;
                if (sText.equals("GOP Debate"))
                    intent = new Intent(getBaseContext(),
                            VideoActivity.class);
                //else if(sText.equals("Help")) ..........

                if (intent != null)
                    startActivity(intent);
            }
        });

    }
}
