package com.dzordan.lolcounter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Marcin on 2015-05-13.
 */
class rune{

    int runeID;
    int runeCount;

    public rune(){}

    public int getRuneID() {
        return runeID;
    }

    public void setRuneID(int runeID) {
        this.runeID = runeID;
    }

    public int getRuneCount() {
        return runeCount;
    }

    public void setRuneCount(int runeCount) {
        this.runeCount = runeCount;
    }

}

class master{

    int masteryRank;
    int masteryID;

    public master(){}

    public int getMasteryRank() {
        return masteryRank;
    }

    public void setMasteryRank(int masteryRank) {
        this.masteryRank = masteryRank;
    }

    public int getMasteryID() {
        return masteryID;
    }

    public void setMasteryID(int masteryID) {
        this.masteryID = masteryID;
    }


}

public class summoner_info {

    String summonerName;

    int profileIconID;
    int spell1ID;
    int spell2ID;

    List<rune> runesList = new ArrayList<rune>();
    List<master> masteriesList = new ArrayList<master>();

    public summoner_info(){}

    public List<rune> getRunesList() {
        return runesList;
    }

    public void setRunesList(List<rune> runesList) {
        this.runesList = runesList;
    }

    public List<master> getMasteriesList() {
        return masteriesList;
    }

    public void setMasteriesList(List<master> masteriesList) {
        this.masteriesList = masteriesList;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public int getProfileIconID() {
        return profileIconID;
    }

    public void setProfileIconID(int profileIconID) {
        this.profileIconID = profileIconID;
    }

    public int getSpell1ID() {
        return spell1ID;
    }

    public void setSpell1ID(int spell1ID) {
        this.spell1ID = spell1ID;
    }

    public int getSpell2ID() {
        return spell2ID;
    }

    public void setSpell2ID(int spell2ID) {
        this.spell2ID = spell2ID;
    }

}
