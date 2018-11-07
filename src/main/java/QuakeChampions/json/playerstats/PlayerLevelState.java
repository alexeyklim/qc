package QuakeChampions.json.playerstats;

import com.google.gson.annotations.SerializedName;

public class PlayerLevelState {
    @SerializedName("level")
    private int level;

    @SerializedName("exp")
    private int exp;
}
