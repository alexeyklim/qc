package QuakeChampions.util;

import java.io.File;

public class Config {

    public static final String DEFAULT_PATH = new File("").getAbsolutePath();
    public static final String CHAMPION_IMAGES_PATH = DEFAULT_PATH + "\\resources\\images\\champions\\";
    public static final String MAPS_IMAGES_PATH = DEFAULT_PATH + "\\resources\\images\\maps\\";

    public static final String GAME_SUMMARY_URL = "https://stats.quake.com/api/v2/Player/GamesSummary?name=";
    public static final String PLAYER_STATS = "https://stats.quake.com/api/v2/Player/Stats?name=";
    public static final String PLAYER_SEARCH = "https://stats.quake.com/api/v2/Player/Search?term=";
    public static final String GAME_RESULTS = "https://stats.quake.com/api/v2/Player/Games?id=";




}
