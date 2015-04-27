package com.dzordan.lolcounter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Marcin on 2015-04-27.
 */
public class stats_activity extends login_activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity_layout);

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
