package com.songwenju.androidtoolslibrary.util;

import android.app.Application;
import android.widget.Toast;

/**
 * Application单利工具类
 */
public class App {

    public static final Application INSTANCE;

    static {
        Application app = null;
        try {
            app = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
            if (app == null)
                throw new IllegalStateException("Static initialization of Applications must be on main thread.");
        } catch (final Exception e) {

            try {
                app = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            INSTANCE = app;
        }
    }

    public static void toast(String msg) {
        Toast.makeText(INSTANCE, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toast(int msgId) {
        Toast.makeText(INSTANCE, msgId, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(String msg) {
        Toast.makeText(INSTANCE, msg, Toast.LENGTH_LONG).show();
    }
}