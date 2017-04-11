package com.justsmartapps.daredreamdo.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.justsmartapps.daredreamdo.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void sendSecond(View view){
        Intent intent = new Intent(this, CategoryActivity.class);
        switch (view.getId()){
            case R.id.first_item:
                intent.putExtra("CATEGORY",1);
                break;
            case R.id.second_item:
                intent.putExtra("CATEGORY",2);
                break;
            case R.id.three_item:
                intent.putExtra("CATEGORY",3);
                break;
            case R.id.four_item:
                intent.putExtra("CATEGORY",4);
                break;
            case R.id.five_item:
                intent.putExtra("CATEGORY",5);
                break;
            case R.id.six_item:
                intent.putExtra("CATEGORY",6);
                break;
            case R.id.seven_item:
                intent = new Intent(this,SubQuestionsActivity.class);
                intent.putExtra("CATEGORY",6);
                break;
        }
        startActivity(intent);
    }
}
