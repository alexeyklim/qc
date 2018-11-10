package QuakeChampions.json.playerstats;

import com.google.gson.annotations.SerializedName;

public class PlayerLevelState {
    @SerializedName("level")
    private int level;

    @SerializedName("exp")
    private int exp;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
