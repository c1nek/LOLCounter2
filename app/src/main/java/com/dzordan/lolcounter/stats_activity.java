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


    LinearLayout linearLay;
    TableRow row;

    View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity_layout);

        table = (TableLayout) findViewById(R.id.mainTable);
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


}
