package com.dzordan.lolcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created by Marcin on 2015-04-27.
 */
public class stats_activity extends login_activity {

    TableLayout table;


    LinearLayout lay1,lay2,lay3,lay4,lay5;
    TableRow row;

    View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity_layout);

        table = (TableLayout) findViewById(R.id.mainTable);
        lay1 = (LinearLayout) findViewById(R.id.lay1);
        lay2 = (LinearLayout) findViewById(R.id.lay2);
        lay3 = (LinearLayout) findViewById(R.id.lay3);
        lay4 = (LinearLayout) findViewById(R.id.lay4);
        lay5 = (LinearLayout) findViewById(R.id.lay5);

        showThree();


        //linearLay = (LinearLayout) findViewById(R.id.linearLay);

        //row = (TableRow) findViewById(R.id.champLay);

        //row.

        int BASEID=200;

        //View v = mLayoutInflator.inflate(R.layout.myRelativeLayout, null);


       // table.

        // Get the message from the intent
       // Intent intent = getIntent();
       // String message = intent.getStringExtra(login_activity.EXTRA_MESSAGE);

        // Create the text view
       // TextView textView = new TextView(this);
       // textView.setTextSize(40);
        //textView.setText(message);

        // Set the text view as the activity layout
       // setContentView(textView);
    }


    public void showAll(){
        lay1.setVisibility(View.VISIBLE);
        lay2.setVisibility(View.VISIBLE);
        lay3.setVisibility(View.VISIBLE);
        lay4.setVisibility(View.VISIBLE);
        lay5.setVisibility(View.VISIBLE);
    }

    public void showThree(){
        lay1.setVisibility(View.VISIBLE);
        lay2.setVisibility(View.VISIBLE);
        lay3.setVisibility(View.VISIBLE);
        lay4.setVisibility(View.INVISIBLE);
        lay5.setVisibility(View.INVISIBLE);

    }


}
