package com.dzordan.lolcounter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mopub.mobileads.MoPubView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Handler;

public class login_activity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.dzordan.lolcounter.stats_activity";
    private final static String API_KEY = "?api_key=7fcce4c3-93f8-4db7-bd11-16dd22ef3996";


    private Handler handler;
    private ProgressDialog dialog;
    Context mContext;


    Button search_button;
    TextView login_field, info_field;
    Spinner server_field;
    String login, regiocode, platformID;
    private MoPubView moPubView;
    public game_stats gameStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_activity);

        mContext = this;

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        moPubView = (MoPubView) findViewById(R.id.adview);
        moPubView.setAdUnitId("db2f44af0f2a44f5b8a1ef45b9c15307");
        moPubView.loadAd();
       // moPubView.setBannerAdListener(this);


        gameStats = new game_stats();

        login_field = (TextView)findViewById(R.id.login_field);
        login_field.setOnClickListener(textViewListener);

        server_field = (Spinner) findViewById(R.id.server_spinner);
        info_field = (TextView) findViewById(R.id.info);

        search_button = (Button) findViewById(R.id.login_button);
        search_button.setOnClickListener(buttonListener);
    }

    protected void onDestroy() {
        moPubView.destroy();
        super.onDestroy();
    }

    protected Button.OnClickListener buttonListener = new Button.OnClickListener() {
        public void onClick(View arg0) {
            if(login_field.getText().toString().length() > 0) {
                login = login_field.getText().toString().toLowerCase();
                getRegionCode(server_field.getSelectedItem().toString());

                try {
                    if(checkHttpCode(regiocode, login) == 200){



                        new Thread(LoadData).start();
                       //

                        handler = new Handler() {
                            public void handleMessage(android.os.Message msg) {

                            }};

                            //intent.putExtra(EXTRA_MESSAGE, login);
                            //intent.putExtra(EXTRA_MESSAGE, server);

                            /////////////////////////////////////////////////

                    }
                    else
                    {
                        setInfoField("Wrong summoner name and/or server");
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
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

    private void getRegionCode(String regionName){
        if(regionName.equals("Brazil")){
            regiocode = "br";
            platformID = "BR1";
        }
        else if(regionName.equals("Europe Nordic and East")){
            regiocode = "eune";
            platformID = "EUN1";
        }
        else if(regionName.equals("Europe")){
            regiocode = "euw";
            platformID = "EUW1";
        }
        else if(regionName.equals("Latin America North")){
            regiocode = "lan";
            platformID = "LA1";
        }
        else if(regionName.equals("North America")){
            regiocode = "na";
            platformID = "NA1";
        }
        else if(regionName.equals("Oceania")){
            regiocode = "oce";
            platformID = "OC1";
        }
        else if(regionName.equals("Russia")){
            regiocode = "ru";
            platformID = "RU";
        }
        else if(regionName.equals("Turkey")){
            regiocode = "tr";
            platformID = "TR1";
        }
        else if(regionName.equals("Republic of Korea")){
            regiocode = "kr";
            platformID = "KR";
        }
        //Log.i("Region Code", regiocode);
        //Log.i("PlatformID", platformID);

    };

    private int checkHttpCode(String region, String summonerName) throws MalformedURLException {
        String url = "httpS://eune.api.pvp.net/api/lol/" + region + "/v1.4/summoner/by-name/" + summonerName + API_KEY;
        URL Url = new URL(url);
        int statusCode = 0;

        try{
            HttpURLConnection http = (HttpURLConnection)Url.openConnection();
            statusCode = http.getResponseCode();
            Log.i("Http status code", Integer.toString(statusCode));
            if(statusCode != 200){
                setInfoField("Wrong Summoner Name");
            }

        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return statusCode;
    }

    private int checkHttpCode(URL url){
        int statusCode = 0;

        try{
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            statusCode = http.getResponseCode();
            Log.i("Http status code", Integer.toString(statusCode));
            if(statusCode != 200){
                setInfoField("Wrong Summoner Name");
            }

        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return statusCode;
    }

    private void getJSON(String region, String summonerName) throws MalformedURLException {

        String url = "https://eune.api.pvp.net/api/lol/" + region + "/v1.4/summoner/by-name/" + summonerName + API_KEY;
        Log.i("Request URL", url);
        URL Url = new URL(url);

        String qResult = null;

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpEntity httpEntity = httpClient.execute(httpGet).getEntity();

            if (httpEntity != null) {
                InputStream inputStream = httpEntity.getContent();
                Reader in = new InputStreamReader(inputStream);
                BufferedReader bufferedreader = new BufferedReader(in);
                StringBuilder stringBuilder = new StringBuilder();

                String stringReadLine = null;

                while ((stringReadLine = bufferedreader.readLine()) != null) {
                    stringBuilder.append(stringReadLine + "\n");
                }

                qResult = stringBuilder.toString();
                Log.i("Request response", qResult);

                readJSONData1(qResult);

            }

        } catch (ClientProtocolException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        getJSON(platformID, gameStats.summonerID);
    }

    private void getJSON(String platformid, int summonerid) throws MalformedURLException {

        String url = "https://eune.api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/" + platformid + "/" + summonerid + API_KEY;
        Log.i("Request URL", url);
        URL Url = new URL(url);

        if(checkHttpCode(Url) == 200) {

            String qResult = null;

            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            try {
                HttpEntity httpEntity = httpClient.execute(httpGet).getEntity();

                if (httpEntity != null) {
                    InputStream inputStream = httpEntity.getContent();
                    Reader in = new InputStreamReader(inputStream);
                    BufferedReader bufferedreader = new BufferedReader(in);
                    StringBuilder stringBuilder = new StringBuilder();

                    String stringReadLine = null;

                    while ((stringReadLine = bufferedreader.readLine()) != null) {
                        stringBuilder.append(stringReadLine + "\n");
                    }

                    qResult = stringBuilder.toString();
                    Log.i("Request response", qResult);

                    readJSONData2(qResult);

                }

            } catch (ClientProtocolException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        else{
            setInfoField("There's no current game");
        }

}

    private void readJSONData1(String jsonResult){
        try
        {
            JSONObject JsonObjectA = new JSONObject(jsonResult);
                JSONObject JsonSummoner = JsonObjectA.getJSONObject(login);
                    gameStats.setSummonerID(JsonSummoner.getInt("id"));
                    gameStats.setSummonerName(JsonSummoner.getString("name"));
                    gameStats.setSummonerLvl(JsonSummoner.getInt("summonerLevel"));
                    gameStats.setSummonerProfileIconID(JsonSummoner.getInt("profileIconId"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    private void readJSONData2(String jsonResult){

        try
        {
            JSONObject JsonObjectA = new JSONObject(jsonResult);
            JSONArray JsonArrayParticipants = JsonObjectA.getJSONArray("participants");

            gameStats.setGameType(JsonArrayParticipants.length()/2);
            for(int i = JsonArrayParticipants.length()/2; i < JsonArrayParticipants.length(); i++) {
                summoner_info tempSummoner = new summoner_info();
                JSONObject JSONObject_onesummoner = JsonArrayParticipants.getJSONObject(i);
                tempSummoner.setSpell1ID(JSONObject_onesummoner.getInt("spell1Id"));
                tempSummoner.setSpell2ID(JSONObject_onesummoner.getInt("spell2Id"));
                tempSummoner.setProfileIconID(JSONObject_onesummoner.getInt("profileIconId"));
                tempSummoner.setSummonerName(JSONObject_onesummoner.getString("summonerName"));

                JSONArray JsonArrayRunes = JSONObject_onesummoner.getJSONArray("runes");
                for(int j = 0; j < JsonArrayRunes.length(); j++) {
                    JSONObject JSONObject_onerune = JsonArrayRunes.getJSONObject(j);
                    rune tempRune = new rune();
                    tempRune.setRuneID(JSONObject_onerune.getInt("runeId"));
                    tempRune.setRuneCount(JSONObject_onerune.getInt("count"));
                    tempSummoner.runesList.add(tempRune);
                }

                JSONArray JsonArrayMasteries = JSONObject_onesummoner.getJSONArray("masteries");
                for(int k = 0; k < JsonArrayMasteries.length(); k++) {
                    JSONObject JSONObject_onemaster = JsonArrayMasteries.getJSONObject(k);
                    master tempMaster = new master();
                    tempMaster.setMasteryRank(JSONObject_onemaster.getInt("rank"));
                    tempMaster.setMasteryID(JSONObject_onemaster.getInt("masteryId"));
                    tempSummoner.masteriesList.add(tempMaster);
                }
                gameStats.summonerInfoList.add(tempSummoner);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        final Intent intent=new Intent(login_activity.this,stats_activity.class);
        intent.putExtra("stats", gameStats);
        startActivity(intent);

    }

    private Runnable LoadData = new Runnable() {

        public void run(){

        runOnUiThread(new Runnable() {
            public void run() {
                dialog = new ProgressDialog(mContext);
                dialog.setMessage("Please Wait!!");
                dialog.setCancelable(false);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();
            }
        });

            try {
                getJSON(regiocode, login);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    dialog.dismiss();
                }
            });


            }
        };

}
