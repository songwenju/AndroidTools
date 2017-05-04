package com.songwenju.androidtoolslibrary.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * sharedPreferences的管理类
 */
public class SpUtil {
    private static SharedPreferences mSp;


    /**
     * 获得sharePreferences
     *
     * @return
     */
    public static SharedPreferences getInstance(Context context) {
        if (mSp == null) {
            mSp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return mSp;
    }

    /**
     * 使用sharedPreferences存入String类型的数据
     *
     * @param key   key
     * @param value value
     */
    public static void putString(Context context, String key, String value) {
        mSp = getInstance(context);
        if (!TextUtils.isEmpty(key)) {
            mSp.edit().putString(key, value).apply();
        }
    }


    /**
     * 使用sharedPreferences存入String类型的数据,并设置默认值
     *
     * @param key          key
     * @return 获得的String类型的数据
     */
    public static String getString(Context context, String key) {
        mSp = getInstance(context);
        String result = null;
        if (!TextUtils.isEmpty(key)) {
            result = mSp.getString(key, null);
        }
        return result;
    }
    /**
     * 使用sharedPreferences存入String类型的数据,并设置默认值
     *
     * @param key          key
     * @param defaultValue defaultValue
     * @return 获得的String类型的数据
     */
    public static String getString(Context context, String key, String defaultValue) {
        mSp = getInstance(context);
        String result = defaultValue;
        if (!TextUtils.isEmpty(key)) {
            result = mSp.getString(key, defaultValue);
        }
        return result;
    }

    /**
     * 使用sharedPreferences存入boolean类型的数据
     *
     * @param key   key
     * @param value value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        mSp = getInstance(context);
        if (!TextUtils.isEmpty(key)) {
            mSp.edit().putBoolean(key, value).apply();
        }
    }

    /**
     * 使用sharedPreferences存入boolean类型的数据,并设置默认值
     *
     * @param key          key
     * @param defaultValue defaultValue
     * @return 获得的boolean类型的数据
     */
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        mSp = getInstance(context);
        boolean result = defaultValue;
        if (!TextUtils.isEmpty(key)) {
            result = mSp.getBoolean(key, defaultValue);
        }
        return result;
    }

    /**
     * 使用sharedPreferences存入int类型的数据
     *
     * @param key   key
     * @param value value
     */
    public static void putInt(Context context, String key, int value) {
        mSp = getInstance(context);
        if (!TextUtils.isEmpty(key)) {
            mSp.edit().putInt(key, value).apply();
        }
    }

    /**
     * 使用sharedPreferences获得的int类型的数据,并设置默认值
     *
     * @param key          key
     * @param defaultValue defaultValue
     * @return 获得的int类型的数据
     */
    public static int getInt(Context context, String key, int defaultValue) {
        mSp = getInstance(context);
        int result = defaultValue;
        if (!TextUtils.isEmpty(key)) {
            result = mSp.getInt(key, defaultValue);
        }
        return result;
    }

    /**
     * 使用sharedPreferences存入set类型的数据
     *
     * @param context 上下文
     * @param key     key
     * @param value   value
     */
    public static void putStringSet(Context context, String key, Set<String> value) {
        mSp = getInstance(context);
        if (!TextUtils.isEmpty(key)) {
            mSp.edit().putStringSet(key, value).apply();
        }
    }

    /**
     * 使用sharedPreferences获得的set数据
     *
     * @param context context
     * @param key     key
     * @return
     */
    public static Set<String> getStringSet(Context context, String key) {
        mSp = getInstance(context);
        Set<String> set = null;
        if (!TextUtils.isEmpty(key)) {
            set = mSp.getStringSet(key, null);
        }
        return set;
    }

    /**
     * 使用sharedPreferences获得的set数据
     *
     * @param context      context
     * @param key          key
     * @param defaultValue defaultValue
     * @return
     */
    public static Set<String> getStringSet(Context context, String key, Set<String> defaultValue) {
        mSp = getInstance(context);
        Set<String> set = defaultValue;
        if (!TextUtils.isEmpty(key)) {
            set = mSp.getStringSet(key, defaultValue);
        }
        return set;
    }

    /**
     * 添加对象
     *
     * @param key key
     * @param t   obj
     */
    public  static <T> void putModel(Context context, String key, T t) {
        mSp = getInstance(context);

        if (!TextUtils.isEmpty(key) && t != null) {
            Gson gson = new Gson();   //GSON
            putString(context, key, gson.toJson(t));
        }
    }

    /**
     * 获取对象
     *
     * @param key
     * @param clazz
     * @return
     */
    public static <T> T getModel(Context context, String key, Class<T> clazz) {
        Gson gson = new Gson();
        String value = null;
        if (!TextUtils.isEmpty(key)) {
            value = getString(context,key);
        }
        return TextUtils.isEmpty(value) ? null : gson.fromJson(value, clazz);
    }

    /**
     * 添加集合
     *
     * @param key
     * @param t
     */
    public static <T> void putModels(Context context, String key, List<T> t) {
        Gson gson = new Gson();
        if (!TextUtils.isEmpty(key) && t != null && t.size() > 0) {
            putString(context,key, gson.toJson(t));
        }
    }

    /**
     * 获取集合
     *
     * @param key
     * @param clazz
     * @return
     */
    public static <T> List<T> getModels(Context context, String key, Class<T> clazz) {
        String value = null;
        Gson gson = new Gson();
        if (!TextUtils.isEmpty(key)) {
            value = getString(context,key);
        }
        return TextUtils.isEmpty(value) ? null : (List<T>) gson.fromJson(value, clazz);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        mSp = getInstance(context);
        return mSp.contains(key);
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param key
     */
    public static void remove(Context context, String key) {
        mSp = getInstance(context);

        mSp.edit().remove(key).apply();
    }

    /**
     * 清除所有数据
     */
    public static void clear(Context context) {
        mSp = getInstance(context);

        mSp.edit().clear().apply();
    }

    /**
     * 返回所有的键值对
     *
     * @return
     */
    public static Map<String, ?> getAll(Context context) {
        mSp = getInstance(context);
        return mSp.getAll();
    }

    /**
     * 日志输出所有键值对
     */
    public static void selectKeyAll(Context context) {
        mSp = getInstance(context);
        Map<String, Object> map = (Map<String, Object>) mSp.getAll();
        for (String key : map.keySet()) {
           LogUtil.i("SpUtil", "key= " + key + " and value= " + map.get(key));
        }
    }
}
