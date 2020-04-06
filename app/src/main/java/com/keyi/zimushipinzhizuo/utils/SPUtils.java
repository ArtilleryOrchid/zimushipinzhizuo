package com.keyi.zimushipinzhizuo.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {
    private static SPUtils spUtils = null;
    private Context context;
    private SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public void init(Context context, String fileName) {
        this.context = context;
        preferences = context.getSharedPreferences(fileName, context.MODE_PRIVATE);
    }

    public static SPUtils getInstance() {
        if (spUtils == null) {
            synchronized (SPUtils.class) {
                if (spUtils == null) {
                    spUtils = new SPUtils();
                }
            }
        }
        return spUtils;
    }

    /**
     * 向SP存入指定key对应的数据
     * 其中value可以是String、boolean、float、int、long等各种基本类型的值
     *
     * @param key
     * @param value
     */
    public void putString(String key, String value) {
        editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void putBoolean(String key, boolean value) {
        editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void putFloat(String key, float value) {
        editor = preferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public void putInt(String key, int value) {
        editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void putLong(String key, long value) {
        editor = preferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * 清空SP里所以数据
     */
    public void clear() {
        editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * 删除SP里指定key对应的数据项
     *
     * @param key
     */
    public void remove(String key) {
        editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 获取SP数据里指定key对应的value。如果key不存在，则返回默认值defValue。
     *
     * @param key
     * @param defValue
     * @return
     */
    public String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return preferences.getFloat(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }

    /**
     * 判断SP是否包含特定key的数据
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return preferences.contains(key);
    }
}
