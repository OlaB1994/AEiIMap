package pl.polsl.aeiimap.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;

/**
 * Created by Mateusz on 06.03.2017.
 */

public class DataParser {

    public static final int TYP_AULA = 1;
    public static final int TYP_LABORATORIUM = 2;
    public static final int TYP_SALA_CWICZEN = 3;
    public static final int TYP_TOALETA = 4;
    public static final int TYP_POMIESZCZENIA_PRACOWNIKOW = 5;
    public static final int TYP_POMIESZCZENIA_UZYTKOWE = 6;
    public static final int TYP_UNDEFINED = 7;

    private static final String JSON_FILE_NAME = "map.json";
    private static DataParser instance = null;
    private Map map;

    private WeakReference<Context> contextWeakReference;

    public static DataParser getInstance() {
        if (instance == null) {
            instance = new DataParser();
        }
        return instance;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void init(Context context) {
        contextWeakReference = new WeakReference<>(context);
        try {
            setMapFromJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setMapFromJson() throws IOException {
        InputStream inputStream = contextWeakReference.get().getApplicationContext().getAssets().open(JSON_FILE_NAME);
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        Gson gson = new Gson();
        map = gson.fromJson(jsonReader, Map.class);
    }

}
