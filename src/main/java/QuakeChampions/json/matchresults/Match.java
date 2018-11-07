package QuakeChampions.json.matchresults;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Match {

    @SerializedName("id")
    private String id;

    @SerializedName("playedDateTime")
    private String playedDateTime;

    @SerializedName("mapName")
    private String mapName;

    @SerializedName("gameMode")
    private String gameMode;

    @SerializedName("summary")
    private Summary summary;

    @SerializedName("battleReportPersonalStatistics")
    private List<BattlePersonalStatistics> battlePersonalStatistics;

}
