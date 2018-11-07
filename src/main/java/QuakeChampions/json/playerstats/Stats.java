package QuakeChampions.json.playerstats;

import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("name")
    private String name;

    @SerializedName("playerRatings")
    private PlayerRatings playerRatings;

    @SerializedName("playerLevelState")
    private PlayerLevelState playerLevelState;

}
