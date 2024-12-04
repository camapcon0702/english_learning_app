//package com.example.elitte.JWT;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//public class TokenManager {
//    private static final String PREF_NAME = "AuthPrefs";
//    private static final String TOKEN_KEY = "jwt_token";
//
//    public static void saveToken(Context context, String token) {
//        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putString(TOKEN_KEY, token);
//        editor.apply();
//    }
//
//        public static String getToken(Context context) {
//            SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
//            return prefs.getString(TOKEN_KEY, null);
//        }
//
//        public static void clearToken(Context context) {
//            SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
//        prefs.edit().remove(TOKEN_KEY).apply();
//    }
//}

package com.example.elitte.JWT;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager {
    private static final String PREF_NAME = "AuthPrefs";
    private static final String TOKEN_KEY = "jwt_token";
    private static final String USER_ID_KEY = "user_id";

    // Lưu token
    public static void saveToken(Context context, String token) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(TOKEN_KEY, token);
        editor.apply();
    }

    // Lấy token
    public static String getToken(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString(TOKEN_KEY, null);
    }

    // Xóa token
    public static void clearToken(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().remove(TOKEN_KEY).apply();
        prefs.edit().remove(USER_ID_KEY).apply();
    }

    // Lưu userId
    public static void saveUserId(Context context, int userId) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(USER_ID_KEY, userId);
        editor.apply();
    }

    // Lấy userId
    public static int getUserId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getInt(USER_ID_KEY, -1);  // Trả về -1 nếu không có giá trị
    }
}
