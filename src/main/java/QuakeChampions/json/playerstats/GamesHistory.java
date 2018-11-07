package QuakeChampions.json.playerstats;

import com.google.gson.annotations.SerializedName;

public class GamesHistory {
    @SerializedName("gamesPlayed")
    private int gamesPlayed;

    @SerializedName("eloRating")
    private int eloRating;

    @SerializedName("time")
    private String time;

    @SerializedName("result")
    private int result;

    @SerializedName("sessionId")
    private String sessionId;
}
