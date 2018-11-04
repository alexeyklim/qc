package QuakeChampions;

public enum Maps {
    AWOKEN("Awoken"),
    BLOOD_COVENANT("dm6"),
    BLOOD_RUN("ztn"),
    CORRUPTED_KEEP("corrupted"),
    MOLTEN_FALLS("molten"),
    VALE_OF_PNATH("vale");

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
