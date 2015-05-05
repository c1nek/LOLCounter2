package com.dzordan.lolcounter;

/**
 * Created by Marcin on 2015-05-04.
 */
public class game_stats {

    int summonerID;
    String summonerName;
    int summonerProfileIconID;
    int summonerLvl;

    public game_stats() {
    }

    public int getSummonerID() {
        return summonerID;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public int getSummonerProfileIconID(int profileIconId) {
        return summonerProfileIconID;
    }

    public int getSummonerLvl() {
        return summonerLvl;
    }

    public void setSummonerID(int summonerID) {
        this.summonerID = summonerID;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public void setSummonerProfileIconID(int summonerProfileIconID) {
        this.summonerProfileIconID = summonerProfileIconID;
    }

    public void setSummonerLvl(int summonerLvl) {
        this.summonerLvl = summonerLvl;
    }


}
