package QuakeChampions.json.playerstats;

import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("name")
    private String name;

    @SerializedName("playerRatings")
    private PlayerRatings playerRatings;

    @SerializedName("playerLevelState")
    private PlayerLevelState playerLevelState;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerRatings getPlayerRatings() {
        return playerRatings;
    }

    public void setPlayerRatings(PlayerRatings playerRatings) {
        this.playerRatings = playerRatings;
    }

    public PlayerLevelState getPlayerLevelState() {
        return playerLevelState;
    }

    public void setPlayerLevelState(PlayerLevelState playerLevelState) {
        this.playerLevelState = playerLevelState;
    }
}
