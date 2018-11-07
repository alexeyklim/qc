package QuakeChampions.json.matchresults;

import com.google.gson.annotations.SerializedName;

public class BattlePersonalStatistics {

    @SerializedName("userId")
    private String userId;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("averageLifetime")
    private int averageLifetime;

    @SerializedName("totalDamage")
    private int totalDamage;

    @SerializedName("kills")
    private int kills;

    @SerializedName("deaths")
    private int deaths;

    @SerializedName("megaHealthPickups")
    private int megaHealthPickups;

    @SerializedName("heavyArmorPickups")
    private int getMegaHealthPickups;

    @SerializedName("smallArmorPickups")
    private int smallArmorPickups;

    @SerializedName("bestWeapon")
    private String bestWeapon;

    @SerializedName("bestWeaponAccuracyPercent")
    private int bestWeaponAccuracyPercent;

    @SerializedName("bestWeaponDamage")
    private int bestWeaponDamage;


}
