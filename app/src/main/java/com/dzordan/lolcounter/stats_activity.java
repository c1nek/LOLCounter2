package com.dzordan.lolcounter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Marcin on 2015-04-27.
 */
public class stats_activity extends login_activity {

    InterstitialAd mInterstitialAd;

    TableLayout table;
    TextView[] champname_field_tab = new TextView[5];
    ImageView[] champico_filed_tab = new ImageView[5];
    TextView[][] spellico_field_tab = new TextView[5][2];
    ImageView[][] items_tab = new ImageView[5][6];
    int[] values_tab = new int[]{10,20,10,10,10,25,10,10,10,10,20,10,20,10,15,10,10,10,20,15,10,20,20,10,10,10,20,10,10,10,10,10,20,10};
    LinearLayout linearLay4, linearLay5;

    game_stats gameStatsActivity;

    Vibrator vibra;

    int itemID;
    int buttonID;

    int backPressCount = 0;
    boolean itemsPressed = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity_layout);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-0550874854139886/2307097219");
        requestNewInterstitial();

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

            champico_filed_tab[0] = (ImageView) findViewById(R.id.champ1ico);
            champico_filed_tab[1] = (ImageView) findViewById(R.id.champ2ico);
            champico_filed_tab[2] = (ImageView) findViewById(R.id.champ3ico);
            champico_filed_tab[3] = (ImageView) findViewById(R.id.champ4ico);
            champico_filed_tab[4] = (ImageView) findViewById(R.id.champ5ico);

            spellico_field_tab[0][0] = (TextView) findViewById(R.id.spell11Image);
            spellico_field_tab[0][0].setOnClickListener(spellClickHandler);
            spellico_field_tab[0][1] = (TextView) findViewById(R.id.spell12Image);
            spellico_field_tab[0][1].setOnClickListener(spellClickHandler);
            spellico_field_tab[1][0] = (TextView) findViewById(R.id.spell21Image);
            spellico_field_tab[1][0].setOnClickListener(spellClickHandler);
            spellico_field_tab[1][1] = (TextView) findViewById(R.id.spell22Image);
            spellico_field_tab[1][1].setOnClickListener(spellClickHandler);
            spellico_field_tab[2][0] = (TextView) findViewById(R.id.spell31Image);
            spellico_field_tab[2][0].setOnClickListener(spellClickHandler);
            spellico_field_tab[2][1] = (TextView) findViewById(R.id.spell32Image);
            spellico_field_tab[2][1].setOnClickListener(spellClickHandler);
            spellico_field_tab[3][0] = (TextView) findViewById(R.id.spell41Image);
            spellico_field_tab[3][0].setOnClickListener(spellClickHandler);
            spellico_field_tab[3][1] = (TextView) findViewById(R.id.spell42Image);
            spellico_field_tab[3][1].setOnClickListener(spellClickHandler);
            spellico_field_tab[4][0] = (TextView) findViewById(R.id.spell51Image);
            spellico_field_tab[4][0].setOnClickListener(spellClickHandler);
            spellico_field_tab[4][1] = (TextView) findViewById(R.id.spell52Image);
            spellico_field_tab[4][1].setOnClickListener(spellClickHandler);

            items_tab[0][0] = (ImageView) findViewById(R.id.item11);
            items_tab[0][0].setOnClickListener(itemClickHandler);
            items_tab[0][1] = (ImageView) findViewById(R.id.item12);
            items_tab[0][1].setOnClickListener(itemClickHandler);
            items_tab[0][2] = (ImageView) findViewById(R.id.item13);
            items_tab[0][2].setOnClickListener(itemClickHandler);
            items_tab[0][3] = (ImageView) findViewById(R.id.item14);
            items_tab[0][3].setOnClickListener(itemClickHandler);
            items_tab[0][4] = (ImageView) findViewById(R.id.item15);
            items_tab[0][4].setOnClickListener(itemClickHandler);
            items_tab[0][5] = (ImageView) findViewById(R.id.item16);
            items_tab[0][5].setOnClickListener(itemClickHandler);
            items_tab[1][0] = (ImageView) findViewById(R.id.item21);
            items_tab[1][0].setOnClickListener(itemClickHandler);
            items_tab[1][1] = (ImageView) findViewById(R.id.item22);
            items_tab[1][1].setOnClickListener(itemClickHandler);
            items_tab[1][2] = (ImageView) findViewById(R.id.item23);
            items_tab[1][2].setOnClickListener(itemClickHandler);
            items_tab[1][3] = (ImageView) findViewById(R.id.item24);
            items_tab[1][3].setOnClickListener(itemClickHandler);
            items_tab[1][4] = (ImageView) findViewById(R.id.item25);
            items_tab[1][4].setOnClickListener(itemClickHandler);
            items_tab[1][5] = (ImageView) findViewById(R.id.item26);
            items_tab[1][5].setOnClickListener(itemClickHandler);
            items_tab[2][0] = (ImageView) findViewById(R.id.item31);
            items_tab[2][0].setOnClickListener(itemClickHandler);
            items_tab[2][1] = (ImageView) findViewById(R.id.item32);
            items_tab[2][1].setOnClickListener(itemClickHandler);
            items_tab[2][2] = (ImageView) findViewById(R.id.item33);
            items_tab[2][2].setOnClickListener(itemClickHandler);
            items_tab[2][3] = (ImageView) findViewById(R.id.item34);
            items_tab[2][3].setOnClickListener(itemClickHandler);
            items_tab[2][4] = (ImageView) findViewById(R.id.item35);
            items_tab[2][4].setOnClickListener(itemClickHandler);
            items_tab[2][5] = (ImageView) findViewById(R.id.item36);
            items_tab[2][5].setOnClickListener(itemClickHandler);
            items_tab[3][0] = (ImageView) findViewById(R.id.item41);
            items_tab[3][0].setOnClickListener(itemClickHandler);
            items_tab[3][1] = (ImageView) findViewById(R.id.item42);
            items_tab[3][1].setOnClickListener(itemClickHandler);
            items_tab[3][2] = (ImageView) findViewById(R.id.item43);
            items_tab[3][2].setOnClickListener(itemClickHandler);
            items_tab[3][3] = (ImageView) findViewById(R.id.item44);
            items_tab[3][3].setOnClickListener(itemClickHandler);
            items_tab[3][4] = (ImageView) findViewById(R.id.item45);
            items_tab[3][4].setOnClickListener(itemClickHandler);
            items_tab[3][5] = (ImageView) findViewById(R.id.item46);
            items_tab[3][5].setOnClickListener(itemClickHandler);
            items_tab[4][0] = (ImageView) findViewById(R.id.item51);
            items_tab[4][0].setOnClickListener(itemClickHandler);
            items_tab[4][1] = (ImageView) findViewById(R.id.item52);
            items_tab[4][1].setOnClickListener(itemClickHandler);
            items_tab[4][2] = (ImageView) findViewById(R.id.item53);
            items_tab[4][2].setOnClickListener(itemClickHandler);
            items_tab[4][3] = (ImageView) findViewById(R.id.item54);
            items_tab[4][3].setOnClickListener(itemClickHandler);
            items_tab[4][4] = (ImageView) findViewById(R.id.item55);
            items_tab[4][4].setOnClickListener(itemClickHandler);
            items_tab[4][5] = (ImageView) findViewById(R.id.item56);
            items_tab[4][5].setOnClickListener(itemClickHandler);

            checkGametype(gameStatsActivity.gameType);
            setChampNames();
        }
    }

    @Override
    public void onBackPressed(){
        if(backPressCount==0){
            if (mInterstitialAd.isLoaded()) {
                backPressCount++;
                mInterstitialAd.show();
            }
            else {
                finish();
            }
        }
        else {
            finish();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 7 && resultCode == RESULT_OK && data != null) {
            itemID = data.getIntExtra("itemid", 0);
            Log.i("item ID", String.valueOf(itemID));
            setItem();
        }
    }

    private void setItem(){
        ImageView temp = (ImageView) findViewById(buttonID);

        String imageUri = "drawable/item" + itemID;
        int imageResource = getResources().getIdentifier(imageUri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        temp.setImageDrawable(res);
        temp.setClickable(false);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j<5; j++){
                if(temp == items_tab[i][j]){
                    double cooldown = values_tab[itemID];
                    double spell1value = gameStatsActivity.getSummonerInfoList().get(i).getSpell1CooldownX()*(1-(cooldown/100));
                    double spell2value = gameStatsActivity.getSummonerInfoList().get(i).getSpell2CooldownX()*(1-(cooldown/100));
                    gameStatsActivity.getSummonerInfoList().get(i).setSpell1CooldownX(spell1value);
                    gameStatsActivity.getSummonerInfoList().get(i).setSpell2CooldownX(spell2value);
                    spellico_field_tab[i][0].setText(String.valueOf((int)gameStatsActivity.getSummonerInfoList().get(i).getSpell1CooldownX()));
                    spellico_field_tab[i][1].setText(String.valueOf((int)gameStatsActivity.getSummonerInfoList().get(i).getSpell2CooldownX()));
                    break;
                }
            }
        }
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    View.OnClickListener spellClickHandler = new View.OnClickListener() {
        public void onClick(View v) {
            vibra(50);
            switch(v.getId()) {
                case R.id.spell11Image:
                    spellico_field_tab[0][0].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(0).getSpell1CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[0][0].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[0][0].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(0).getSpell1CooldownX();
                            spellico_field_tab[0][0].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell12Image:
                    spellico_field_tab[0][1].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(0).getSpell2CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[0][1].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[0][1].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(0).getSpell2CooldownX();
                            spellico_field_tab[0][1].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell21Image:
                    spellico_field_tab[1][0].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(1).getSpell1CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[1][0].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[1][0].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(1).getSpell1CooldownX();
                            spellico_field_tab[1][0].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell22Image:
                    spellico_field_tab[1][1].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(1).getSpell2CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[1][1].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[1][1].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(1).getSpell2CooldownX();
                            spellico_field_tab[1][1].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell31Image:
                    spellico_field_tab[2][0].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(2).getSpell1CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[2][0].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[2][0].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(2).getSpell1CooldownX();
                            spellico_field_tab[2][0].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell32Image:
                    spellico_field_tab[2][1].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(2).getSpell2CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[2][1].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[2][1].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(2).getSpell2CooldownX();
                            spellico_field_tab[2][1].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell41Image:
                    spellico_field_tab[3][0].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(3).getSpell1CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[3][0].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[3][0].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(3).getSpell1CooldownX();
                            spellico_field_tab[3][0].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell42Image:
                    spellico_field_tab[3][1].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(3).getSpell2CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[3][1].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[3][1].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(3).getSpell2CooldownX();
                            spellico_field_tab[3][1].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell51Image:
                    spellico_field_tab[4][0].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(4).getSpell1CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[4][0].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[4][0].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(4).getSpell1CooldownX();
                            spellico_field_tab[4][0].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
                case R.id.spell52Image:
                    spellico_field_tab[4][1].setClickable(false);
                    new CountDownTimer((int)gameStatsActivity.getSummonerInfoList().get(4).getSpell2CooldownX()*1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            spellico_field_tab[4][1].setText(String.valueOf(millisUntilFinished / 1000));
                        }

                        public void onFinish() {
                            vibra(300);
                            spellico_field_tab[4][1].setClickable(true);
                            int cooldown = (int)gameStatsActivity.getSummonerInfoList().get(4).getSpell2CooldownX();
                            spellico_field_tab[4][1].setText(String.valueOf(cooldown));
                        }
                    }.start();
                    break;
            }
        }
    };

    View.OnClickListener itemClickHandler = new View.OnClickListener() {
        public void onClick(View v) {
            vibra(50);
            itemsPressed = true;
            final Intent intent=new Intent(stats_activity.this,items_activity.class);
            startActivityForResult(intent, 7);
            buttonID = v.getId();
            }};


    public void vibra(int time) {
        vibra = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibra.vibrate(time);
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

        for(int i =0; i<gameStatsActivity.gameType; i++) {
            if (champname_field_tab[i].getVisibility() == View.VISIBLE) {

                champname_field_tab[i].setText(gameStatsActivity.getSummonerInfoList().get(i).summonerName);

                String imageUri = "drawable/ico" + gameStatsActivity.getSummonerInfoList().get(i).getChampionId();
                int imageResource = getResources().getIdentifier(imageUri, null, getPackageName());
                Drawable res = getResources().getDrawable(imageResource);
                champico_filed_tab[i].setImageDrawable(res);

                String spell1ImageUri = "drawable/spell" + gameStatsActivity.getSummonerInfoList().get(i).getSpell1ID();
                String spell2ImageUri = "drawable/spell" + gameStatsActivity.getSummonerInfoList().get(i).getSpell2ID();
                int imageResourceSpell1 = getResources().getIdentifier(spell1ImageUri, null, getPackageName());
                int imageResourceSpell2 = getResources().getIdentifier(spell2ImageUri, null, getPackageName());
                Drawable resSpell1 = getResources().getDrawable(imageResourceSpell1);
                Drawable resSpell2 = getResources().getDrawable(imageResourceSpell2);
                spellico_field_tab[i][0].setBackground(resSpell1);
                int cooldown1 = (int)gameStatsActivity.getSummonerInfoList().get(i).getSpell1Cooldown();
                spellico_field_tab[i][0].setText(String.valueOf(cooldown1));
                spellico_field_tab[i][0].setShadowLayer(10, 2, 2, Color.BLACK);
                spellico_field_tab[i][1].setBackground(resSpell2);
                int cooldown2 = (int)gameStatsActivity.getSummonerInfoList().get(i).getSpell2Cooldown();
                spellico_field_tab[i][1].setText(String.valueOf(cooldown2));
                spellico_field_tab[i][1].setShadowLayer(10, 2, 2, Color.BLACK);
            }
        }
    }

    public Drawable arrayToDrawable(byte[] array){
        Bitmap bitmap = BitmapFactory.decodeByteArray(array, 0, array.length);
        Drawable d = new BitmapDrawable(getResources(), bitmap);
        return d;
    }





}
