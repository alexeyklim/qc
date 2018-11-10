package QuakeChampions.json.playerstats;

import com.google.gson.annotations.SerializedName;

public class PlayerRatings {

    @SerializedName("duel")
    private Duel duel;

    public Duel getDuel() {
        return duel;
    }

    public void setDuel(Duel duel) {
        this.duel = duel;
    }
}
