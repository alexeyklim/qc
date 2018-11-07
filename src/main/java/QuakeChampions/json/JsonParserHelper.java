package QuakeChampions.json;

import QuakeChampions.util.httpclient.CustomHttpClient;
import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParserHelper {

    private static JsonParserHelper instance = null;

    private final Gson gson;

    private JsonParserHelper() {

        gson = new GsonBuilder()
                .setPrettyPrinting().create();
    }

    public static JsonParserHelper getInstance() {
        if (instance == null) {
            instance = new JsonParserHelper();
        }
        return instance;
    }

    public Gson getGson() {
        return gson;
    }

    public JsonElement getJsonFromFile(final String pathToFile) {
        final File jsonfile = new File(pathToFile);
        JsonElement json = null;
        InputStream is = null;
        try {
            is = new FileInputStream(jsonfile);
            json = getJsonFromInputStream(is);
        } catch (final FileNotFoundException e) {
            System.out.println("File " + pathToFile + " not found " + e.getLocalizedMessage());
        }
        return json;
    }

    public JsonElement getJsonFromInputStream(InputStream is) {
        final JsonParser parser = new JsonParser();
        JsonElement json = null;
        try {
            json = parser.parse(new InputStreamReader(is));
            is.close();
        } catch (final IOException e) {
            System.out.println("Input/Output error " + e.getClass() + ": " +
                    e.getLocalizedMessage());
        }
        return json;
    }

    public JsonElement getJsonFromUrl(final String url) {
        try {
            CustomHttpClient httpClient = new CustomHttpClient();
            return getJsonFromInputStream(httpClient.httpGet(url).getEntity().getContent());
        } catch (Exception e1) {
            System.out.println("Unable to get JSON: " + e1.getMessage() + "\n. From url [" + url + "] " + e1.getLocalizedMessage());
        }
        return null;
    }

    public <T> T getJavaObjectFromJson(final JsonElement element,
                                       final Class<T> classOfT) {
        return gson.fromJson(element, classOfT);
    }

    public <T> T getJavaObjectFromJson(final Gson gson, final JsonElement element,
                                       final Class<T> classOfT) {
        return gson.fromJson(element, classOfT);
    }

    public <T> List<T> getListOfJavaObjectsFromJson(final JsonArray array,
                                                    final Class<T> classOfT) {
        final List<T> list = new ArrayList<T>();
        for (final JsonElement element : array) {
            list.add(this.getJavaObjectFromJson(element, classOfT));
        }
        return list;
    }

    public Boolean verifyFieldPresentInJsonObject(final JsonObject object,
                                                  final String fieldName) {
        return object.get(fieldName) == null ? false : true;
    }


    public int getNumberOfFieldsInJsonObject(final JsonObject object) {
        return object.entrySet().size();
    }

    public Boolean verifyObjectStructureCorrect(final JsonObject object,
                                                final List<String> fieldList) {
        for (final String field : fieldList) {
            if (!verifyFieldPresentInJsonObject(object, field))
                return false;
        }
        return true;
    }

    public Map<String, String> getJsonObjectAsMap(JsonObject object) {
        Map<String, String> data = new HashMap<String, String>();
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            data.put(entry.getKey(), entry.getValue().getAsString());
        }
        return data;
    }

    public <T> Map<String, T> getJsonObjectAsMap(JsonObject object, Class<T> classOfT) {
        Map<String, T> data = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {

            data.put(entry.getKey(), gson.fromJson(entry.getValue(), classOfT));
        }
        return data;
    }
}