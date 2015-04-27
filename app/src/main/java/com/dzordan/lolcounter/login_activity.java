package com.dzordan.lolcounter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class login_activity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.dzordan.lolcounter.stats_activity";

    Button search_button;
    TextView login_field, info_field;
    Spinner server_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        login_field = (TextView)findViewById(R.id.login_field);
        login_field.setOnClickListener(textViewListener);

        server_field = (Spinner) findViewById(R.id.server_spinner);
        info_field = (TextView) findViewById(R.id.info);

        search_button = (Button) findViewById(R.id.login_button);
        search_button.setOnClickListener(buttonListener);
    }

    private Button.OnClickListener buttonListener = new Button.OnClickListener() {
        public void onClick(View arg0) {



            if(login_field.getText().toString().length() > 0) {
                Intent intent = new Intent(login_activity.this, stats_activity.class);
                String login = login_field.getText().toString();
                String server = server_field.getSelectedItem().toString();
                intent.putExtra(EXTRA_MESSAGE, login);
                intent.putExtra(EXTRA_MESSAGE, server);
                startActivity(intent);
            }
            else
            {
                setInfoField("Enter summoner name.");
            }

        }
    };

    private TextView.OnClickListener textViewListener = new TextView.OnClickListener(){
        public void onClick(View arg0) {

                clearInfoField();

        }

    };

    private void setInfoField(String msg){
        info_field.setText(msg);
    }
    private void clearInfoField(){
        info_field.setText("");
    }




}
