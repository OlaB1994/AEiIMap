package pl.polsl.aeiimap.views;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by abienioszek on 12.07.2016.
 */
public class TypeFace {

    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    public static Typeface get(Context c, String name) {
        synchronized (cache) {
            if (!cache.containsKey(name)) {
                Typeface t = Typeface.createFromAsset(
                        c.getAssets(), name);
                cache.put(name, t);
            }
            return cache.get(name);
        }
    }
}
