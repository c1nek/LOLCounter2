package com.dzordan.lolcounter;

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
    rune[] runesTab;
    master[] masteriesTab;

    public summoner_info(){}

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

    public rune[] getRunesTab() {
        return runesTab;
    }

    public void setRunesTab(rune[] runesTab) {
        this.runesTab = runesTab;
    }

    public master[] getMasteriesTab() {
        return masteriesTab;
    }

    public void setMasteriesTab(master[] masteriesTab) {
        this.masteriesTab = masteriesTab;
    }
}
