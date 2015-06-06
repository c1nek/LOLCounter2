package com.dzordan.lolcounter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Marcin on 2015-06-05.
 */
public class items_activity extends login_activity{

    Vibrator vibra;

    ImageView[] items_tab = new ImageView[34];
    int[] values_tab = new int[]{10,20,10,10,10,25,10,10,10,10,20,10,20,10,15,10,10,10,20,15,10,20,20,10,10,10,20,10,10,10,10,10,20,10};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_grid);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        items_tab[0] = (ImageView) findViewById(R.id.item1);
        items_tab[1] = (ImageView) findViewById(R.id.item2);
        items_tab[2] = (ImageView) findViewById(R.id.iitem3);
        items_tab[3] = (ImageView) findViewById(R.id.item4);
        items_tab[4] = (ImageView) findViewById(R.id.item5);
        items_tab[5] = (ImageView) findViewById(R.id.item6);
        items_tab[6] = (ImageView) findViewById(R.id.item7);
        items_tab[7] = (ImageView) findViewById(R.id.item8);
        items_tab[8] = (ImageView) findViewById(R.id.item9);
        items_tab[9] = (ImageView) findViewById(R.id.item10);
        items_tab[10] = (ImageView) findViewById(R.id.item11);
        items_tab[11] = (ImageView) findViewById(R.id.item12);
        items_tab[12] = (ImageView) findViewById(R.id.item13);
        items_tab[13] = (ImageView) findViewById(R.id.item14);
        items_tab[14] = (ImageView) findViewById(R.id.item15);
        items_tab[15] = (ImageView) findViewById(R.id.item16);
        items_tab[16] = (ImageView) findViewById(R.id.item17);
        items_tab[17] = (ImageView) findViewById(R.id.item18);
        items_tab[18] = (ImageView) findViewById(R.id.item19);
        items_tab[19] = (ImageView) findViewById(R.id.item20);
        items_tab[20] = (ImageView) findViewById(R.id.item21);
        items_tab[21] = (ImageView) findViewById(R.id.item22);
        items_tab[22] = (ImageView) findViewById(R.id.item23);
        items_tab[23] = (ImageView) findViewById(R.id.item24);
        items_tab[24] = (ImageView) findViewById(R.id.item25);
        items_tab[25] = (ImageView) findViewById(R.id.item26);
        items_tab[26] = (ImageView) findViewById(R.id.item27);
        items_tab[27] = (ImageView) findViewById(R.id.item28);
        items_tab[28] = (ImageView) findViewById(R.id.item29);
        items_tab[29] = (ImageView) findViewById(R.id.item30);
        items_tab[30] = (ImageView) findViewById(R.id.item31);
        items_tab[31] = (ImageView) findViewById(R.id.item32);
        items_tab[32] = (ImageView) findViewById(R.id.item33);
        items_tab[33] = (ImageView) findViewById(R.id.item34);

        for(int i = 1; i<35; i++){
            String imageUri = "drawable/item" + i;
            int imageResource = getResources().getIdentifier(imageUri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            items_tab[i-1].setImageDrawable(res);
            items_tab[i-1].setOnClickListener(itemClickHandler);
        }


    }

    View.OnClickListener itemClickHandler = new View.OnClickListener() {
        public void onClick(View v) {
            vibra(50);
            int buttonID = v.getId();

        }};

    public void vibra(int time) {
        vibra = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibra.vibrate(time);
    }
}
