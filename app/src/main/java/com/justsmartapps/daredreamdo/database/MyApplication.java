package com.justsmartapps.daredreamdo.database;

import android.app.Application;

import com.justsmartapps.daredreamdo.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by jagadeshseeram on 4/10/17.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Salsa-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
