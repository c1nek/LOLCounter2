package com.dzordan.lolcounter;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Marcin on 2015-05-13.
 */
class rune implements Serializable{

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

class master implements Serializable {

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

public class summoner_info implements Serializable {

    String summonerName;

    byte[] summonerIcon;

    int championId;
    int spell1ID;
    int spell1Cooldown;
    double spell1CooldownX;
    int spell2ID;
    int spell2Cooldown;
    double spell2CooldownX;

    List<rune> runesList = new ArrayList<rune>();
    List<master> masteriesList = new ArrayList<master>();


    public double getSpell2CooldownX() {
        return spell2CooldownX;
    }

    public void setSpell2CooldownX(double spell2CooldownX) {
        this.spell2CooldownX = spell2CooldownX;
    }

    public double getSpell1CooldownX() {
        return spell1CooldownX;
    }

    public void setSpell1CooldownX(double spell1CooldownX) {
        this.spell1CooldownX = spell1CooldownX;
    }

    public int getSpell1Cooldown() {
        return spell1Cooldown;
    }

    public void setSpell1Cooldown(int spell1Cooldown) {
        this.spell1Cooldown = spell1Cooldown;
    }

    public double getSpell2Cooldown() {
        return spell2Cooldown;
    }

    public void setSpell2Cooldown(int spell2Cooldown) {
        this.spell2Cooldown = spell2Cooldown;
    }

    public byte[] getSummonerIcon() {
        return summonerIcon;
    }

    public void setSummonerIcon(byte[] summonerIcon) {
        this.summonerIcon = summonerIcon;
    }

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

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
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
