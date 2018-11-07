package QuakeChampions.bo.enums;

public enum Maps {
    AWOKEN("awoken"),
    BLOOD_COVENANT("blood_covenant"),
    BLOOD_RUN("bloodrun"),
    CORRUPTED_KEEP("corrupted_keep"),
    MOLTEN_FALLS("molten_falls"),
    VALE_OF_PNATH("vale_of_pnath"),
    RUINS_OF_SARNATH("ruins_of_sarnath");

    private String mapName;

    Maps(String mapName) {
        this.mapName = mapName;
    }

    public String getMapName() {
        return this.mapName;
    }

    public static Maps getMapByName(String mapName) {
        for (Maps map: Maps.values()) {
            if(map.getMapName().equalsIgnoreCase(mapName)) {
                return map;
            }
        }
        return null;
    }

}
