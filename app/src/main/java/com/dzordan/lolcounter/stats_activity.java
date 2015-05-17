package com.dzordan.lolcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Marcin on 2015-04-27.
 */
public class stats_activity extends login_activity {

    TableLayout table;
    TextView champ1name_field, champ2name_field, champ3name_field, champ4name_field, champ5name_field;
    LinearLayout linearLay4, linearLay5;

    game_stats gameStatsActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity_layout);

        gameStatsActivity = (game_stats)getIntent().getSerializableExtra("stats");

        {
            linearLay4 = (LinearLayout) findViewById(R.id.lay4);
            linearLay5 = (LinearLayout) findViewById(R.id.lay5);

            table = (TableLayout) findViewById(R.id.mainTable);
            champ1name_field = (TextView) findViewById(R.id.champ1name);
            champ2name_field = (TextView) findViewById(R.id.champ2name);
            champ3name_field = (TextView) findViewById(R.id.champ3name);
            champ4name_field = (TextView) findViewById(R.id.champ4name);
            champ5name_field = (TextView) findViewById(R.id.champ5name);



            checkGametype(gameStatsActivity.gameType);
        }




    }

    private void checkGametype(int type){
        if(type == 3){
            set3v3();
        }
        else{
            set5v5();
        }
    }

    private void setVisibility (int vis){
        linearLay4.setVisibility(vis);
        linearLay5.setVisibility(vis);
    }

    private void set3v3(){
        setVisibility(View.INVISIBLE);
    }

    private void set5v5(){
        setVisibility(View.VISIBLE);
    }


}
