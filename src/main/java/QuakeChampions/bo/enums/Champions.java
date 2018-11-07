package QuakeChampions.bo.enums;

public enum Champions {
    NONE("none"),
    RANGER("Ranger"),
    DEATH_KNIGHT("DK"),
    ATHENA("Athena"),
    SCALEBEARER("Scalebearer"),
    DOOM_SLAYER("Doom"),
    GALENA("Galena"),
    BJ_BLAZKOWICZ("BJ"),
    VISOR("Visor"),
    NYX("Nyx"),
    STROGG_AND_PEEKER("Strogg"),
    KEEL("Keel"),
    SORLAG("Sorlag"),
    SLASH("Slash"),
    ANARKI("Anarki"),
    CLUTCH("Clutch");

    private String championName;

    Champions(final String championName) {
        this.championName = championName;
    }

    public String getChampionName() {
        return this.championName;
    }

    public static Champions getChampionByName(String name) {
        for (Champions champion : Champions.values()) {
            if (champion.getChampionName().equalsIgnoreCase(name)) {
                return champion;
            }
        }
        return null;
    }
}
