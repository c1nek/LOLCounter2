package com.dzordan.lolcounter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-05-04.
 */
public class game_stats implements Serializable {

    int summonerID;
    String summonerName;
    int summonerProfileIconID;
    int summonerLvl;

    int gameType;   //5- 5v5, 3- 3v3

    List<summoner_info> summonerInfoList = new ArrayList<summoner_info>();

    public game_stats() {
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public List<summoner_info> getSummonerInfoList() {
        return summonerInfoList;
    }

    public void setSummonerInfoList(List<summoner_info> summonerInfoList) {
        this.summonerInfoList = summonerInfoList;
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
