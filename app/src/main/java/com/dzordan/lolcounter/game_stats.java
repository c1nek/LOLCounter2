package com.dzordan.lolcounter;

/**
 * Created by Marcin on 2015-05-04.
 */
public class game_stats {

    int summonerID;
    String summonerName;
    int summonerProfileIconID;
    int summonerLvl;

    summoner_info[] summonerInfoTab;

    public game_stats() {
    }

    public summoner_info[] getSummonerInfoTab() {
        return summonerInfoTab;
    }

    public void setSummonerInfoTab(summoner_info[] summonerInfoTab) {
        this.summonerInfoTab = summonerInfoTab;
    }

    public int getSummonerProfileIconID() {
        return summonerProfileIconID;
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
