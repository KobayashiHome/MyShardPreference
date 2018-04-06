package com.example.linfa.myshardpreference;

/**
 * @author LinFa
 * @date 2018/4/6.
 */

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 此处为单例设计模式
 * 显然单例模式的要点有三个：
 * 1. 是某个类只能有一个实例；
 * 2. 是它必须自行创建这个实例；
 * 3. 是它必须自行向整个系统提供这个实例。
 */
public final class SharedPreferencesUtil {
    private static SharedPreferencesUtil mInStance;
    private final String FILE_NAME = "skylinelin";

    private SharedPreferencesUtil() {
    }

    //最基本的单例模式
    public static SharedPreferencesUtil getmInStance() {
        if (mInStance == null) {
            synchronized (SharedPreferencesUtil.class) {
                if (mInStance == null) {
                    mInStance = new SharedPreferencesUtil();
                }
            }
        }
        return mInStance;
    }

    /**
     * 存储
     */
    public void put(Context context, String key, Object value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String type = value.getClass().getSimpleName();

        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) value);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) value);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) value);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) value);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) value);
        }

        editor.apply();

    }

    /**
     * 读取
     */
    public Object get(Context context, String key, Object rvalue) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        String type = rvalue.getClass().getSimpleName();

        if ("Integer".equals(type)) {
           return sharedPreferences.getInt(key, (Integer) rvalue);
        } else if ("Boolean".equals(type)) {
           return sharedPreferences.getBoolean(key, (Boolean) rvalue);
        } else if ("String".equals(type)) {
           return sharedPreferences.getString(key, (String) rvalue);
        } else if ("Float".equals(type)) {
            return sharedPreferences.getFloat(key, (Float) rvalue);
        } else if ("Long".equals(type)) {
           return sharedPreferences.getLong(key, (Long) rvalue);
        }
        return null;
    }


}
