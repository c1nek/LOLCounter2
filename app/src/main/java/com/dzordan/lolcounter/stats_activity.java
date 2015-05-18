package com.dzordan.lolcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-04-27.
 */
public class stats_activity extends login_activity {

    TableLayout table;
    TextView[] champname_field_tab = new TextView[5];
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
            champname_field_tab[0] = (TextView) findViewById(R.id.champ1name);
            champname_field_tab[1] = (TextView) findViewById(R.id.champ2name);
            champname_field_tab[2] = (TextView) findViewById(R.id.champ3name);
            champname_field_tab[3] = (TextView) findViewById(R.id.champ4name);
            champname_field_tab[4] = (TextView) findViewById(R.id.champ5name);




            checkGametype(gameStatsActivity.gameType);
            setChampNames();
        }




    }

    private void checkGametype(int type){
        if(type == 3){
            set3v3();
        }
        else if(type == 5){
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

    private void setChampNames(){

        for(int i =0; i<gameStatsActivity.gameType; i++){
            if(champname_field_tab[i].getVisibility() == View.VISIBLE){
                champname_field_tab[i].setText(gameStatsActivity.getSummonerInfoList().get(i).summonerName);
            }
        }
    }


}
