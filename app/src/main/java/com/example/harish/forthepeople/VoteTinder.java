package com.example.harish.forthepeople;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class VoteTinder extends AppCompatActivity {
    int feeling;
    int curr_ind = 0;
    ArrayList<CharSequence> questions = new ArrayList<CharSequence>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<CharSequence> in_favor = new ArrayList<CharSequence>(); //Argument in Favor:
        ArrayList<CharSequence> opposed = new ArrayList<CharSequence>(); //Argument Opposed:

        questions.add("Should More Police Officers Have Body Cameras?");
        in_favor.add("Body cameras will help with evidence collection in addition to reducing the use of excessive force by police officers. It's a positive for both the general public and for law enforcement officials.");
        opposed.add("Body cameras threaten the privacy of citizens and police officers - especially because there are no standard regulations (at the local or federal level) for how the camera data is stored, used, or destroyed.");

        questions.add("Should \"Terrorism Risk\" Be Considered When Screening People Entering the U.S. Without a Visa?");
        in_favor.add("The Dept. of Homeland Security needs to reform the Visa Waiver Program screening process to ensure it is not exploited by those who want to commit acts of terrorism. DHS needs to be able to suspend countries that don't cooperate in security measures.");
        opposed.add("The Visa Waiver Program helps the economy by allowing travelers from select countries to come to the U.S. for business and tourism. DHS shouldn't be able to unilaterally suspend a given country from the program without Congress' approval.");

        questions.add("Should we allow guns in schools?");
        in_favor.add("Gun free zones prevent law abiding citizens from protecting themselves, and create vulnerable populations that are targeted by criminals.");
        opposed.add("Allowing guns into school will not them safer. Gun violence in schools won't stop until guns are completely out of the picture.");


        questions.add("Should the minimum wage should be raised to $15 an hour?");
        questions.add("Is income equality in America a problem?");
        questions.add("Do you think the media is obsessed with inconsistencies and exaggerations in candidates’ life stories?");
        questions.add("Should America build a wall to prevent illegal immigration?");
        questions.add("Should America deport illegal immigrants?");
        questions.add("Should we raise the age of retirement?");
        questions.add("Should America reduce benefits for future retirees?");
        questions.add("Should America maintain a no fly zone over Syria?");
        questions.add("If there was another financial crisis, should America bail out banks?");

        questions.add("Is abortion is a woman’s unrestricted right?");
        questions.add("Should we legally require hiring more women and minorities?");
        questions.add("Should voter registration be easier?");
        questions.add("Should America prioritize green energy?");
        questions.add("Should we raise taxes?");
        questions.add("Is Islamic Extremism the most important issue facing America?");
        questions.add("Your Vote Has Been Counted!");

        setContentView(R.layout.activity_vote_tinder);
        ImageButton yes = (ImageButton) findViewById(R.id.yes);
        ImageButton no = (ImageButton) findViewById(R.id.no);
        CardView info_card = (CardView) findViewById(R.id.info_card);
        TextView text = (TextView) findViewById(R.id.info_text);
        text.setText(questions.get(curr_ind));

        SeekBar feeling_strength = (SeekBar) findViewById(R.id.feeling_strength);

        //this should be implementation of getting more card info
        info_card.setOnLongClickListener(new View.OnLongClickListener() {

            // Defines the one method for the interface, which is called when the View is long-clicked
            public boolean onLongClick(View v) {
                //give more info on the card
                return true;
            }
        });

        //stores value of feeling strength
        feeling_strength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                feeling = progress;
            }
        });

        //defines actions for drag listeners
        class MyDragListener implements View.OnDragListener {
            //Drawable enterShape = ResourcesCompat.getDrawable(getResources(), R.drawable.shape_droptarget, null);
            //Drawable normalShape = ResourcesCompat.getDrawable(getResources(), R.drawable.shape, null);

            @Override
            public boolean onDrag(View v, DragEvent event)
            {
                TextView text = (TextView) findViewById(R.id.info_text);
                CharSequence curr = text.getText();

                CharSequence next = curr_ind+1<questions.size()?questions.get(curr_ind+1):curr;
                int action = event.getAction();
                int sdk = android.os.Build.VERSION.SDK_INT;

                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        if(v.getId() == R.id.hold_yes)
                            ((ImageView) v.findViewById(R.id.yes)).setImageResource(R.mipmap.ic_green_thumb_up);
                            //v.setBackgroundResource(R.mipmap.ic_green_thumb_up);
                        else if(v.getId() == R.id.hold_no)
                            ((ImageView) v.findViewById(R.id.no)).setImageResource(R.mipmap.ic_red_thumb_down);
                        //else
                        //v.setBackgroundResource(R.mipmap.ic_red_thumb_down);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        if(v.getId() == R.id.hold_yes)
                            ((ImageView) v.findViewById(R.id.yes)).setImageResource(R.mipmap.ic_thumbs_up);
                        else if(v.getId() == R.id.hold_no)
                            ((ImageView) v.findViewById(R.id.no)).setImageResource(R.mipmap.ic_thumb_down);
                        break;
                    //v.setBackground(normalShape);
                    case DragEvent.ACTION_DROP:
                        //reassign View to ViewGroup =>>> BAD, want to not show it at all, don't need this
                        //need to display different card instead - maybe RecycleCard
                        View view = (View) event.getLocalState();
                        //ViewGroup owner = (ViewGroup) view.getParent();
                        //owner.removeView(view);
                        //LinearLayout container = (LinearLayout) v;
                        //container.addView(view);
                        //view.setVisibility(View.INVISIBLE);
                        text.setText(next);
                        curr_ind++;
                        if(v.getId() == R.id.hold_no)
                            sendData(feeling, "no", curr);
                        else if(v.getId()==R.id.hold_yes)
                            sendData(feeling, "yes", curr);
                        else
                            //v.setBackgroundResource(R.mipmap.ic_green_thumb_up);
                            sendData(feeling, null, curr);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        if(v.getId() == R.id.hold_yes)
                            ((ImageView) v.findViewById(R.id.yes)).setImageResource(R.mipmap.ic_thumbs_up);
                        else if(v.getId() == R.id.hold_no)
                            ((ImageView) v.findViewById(R.id.no)).setImageResource(R.mipmap.ic_thumb_down);
                        break;
                    //v.setBackground(normalShape);
                    default:
                        break;
                }
                return true;
            }
        }

        findViewById(R.id.info_card).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.hold_yes).setOnDragListener(new MyDragListener());
        findViewById(R.id.hold_no).setOnDragListener(new MyDragListener());
        findViewById(R.id.hold_indifferent).setOnDragListener(new MyDragListener());
    }

    boolean sendData(int feeling, String response, CharSequence issue)
    {
        return true;
    }

    String getData()
    {
        return "This thing will benefit New York.";
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
