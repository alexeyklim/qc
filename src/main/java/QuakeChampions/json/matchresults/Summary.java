package QuakeChampions.json.matchresults;

import com.google.gson.annotations.SerializedName;

public class Summary {

    @SerializedName("id")
    private String id;

    @SerializedName("mapName")
    private String mapName;

    @SerializedName("rank")
    private int rank;

    @SerializedName("won")
    private boolean won;

    @SerializedName("xp")
    private int xp;

    @SerializedName("kdr")
    private int kdr;

    @SerializedName("totalDamage")
    private int totalDamage;
}
