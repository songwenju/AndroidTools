package com.songwenju.androidtools.util;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtil
 *
 */
public class ToastUtil {
    private static Toast toast = null; //Toast的对象！

    public static void showToast(Context mContext, String id) {
        if (toast == null) {
            toast = Toast.makeText(mContext, id, Toast.LENGTH_SHORT);
        }
        else {
            toast.setText(id);
        }
        toast.show();
    }
}
