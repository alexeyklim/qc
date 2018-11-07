package QuakeChampions.json.playerstats;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Duel {
    @SerializedName("rating")
    private int rating;

    @SerializedName("gamesCount")
    private int gamesCount;

    @SerializedName("history")
    private List<GamesHistory> gamesHistoryList;
}
