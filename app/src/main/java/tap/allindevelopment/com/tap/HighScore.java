package tap.allindevelopment.com.tap;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by barrie_j on 04/05/15.
 */
public class HighScore {
        private static final String PREFS_NAME = "TapBestScore";
        public static final String PREFS_SCORE = "prefs_score";

        public static void saveScore(Context context, String score) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(PREFS_SCORE, score);
            editor.apply();
        }

        public static String getPreferences(Context context, String key) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
            return sharedPreferences.getString(key, "");
        }
}
