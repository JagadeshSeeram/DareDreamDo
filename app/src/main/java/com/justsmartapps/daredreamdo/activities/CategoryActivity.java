package com.justsmartapps.daredreamdo.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.justsmartapps.daredreamdo.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class CategoryActivity extends AppCompatActivity {

    private TextView dareInfoTV;
    private TextView doInfoTV;
    private TextView dreamInfoTV;
    private TextView dominateInfoTV;
    private ImageView cateInfo;
    private TextView imageInfoTV;
    private int category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dareInfoTV = (TextView) findViewById(R.id.dare_info);
        doInfoTV = (TextView) findViewById(R.id.do_info);
        dreamInfoTV = (TextView) findViewById(R.id.dream_info);
        dominateInfoTV = (TextView) findViewById(R.id.dominate_info);
        cateInfo = (ImageView) findViewById(R.id.category_image);
        imageInfoTV = (TextView) findViewById(R.id.image_info);
        YoYo.with(Techniques.FadeIn)
                .duration(300)
                .repeat(Integer.MAX_VALUE)
                .playOn(imageInfoTV);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setUpData();

    }

    private void setUpData() {
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            category = extras.getInt("CATEGORY");
        }
        String imageInfo = null,dareInfoText = null,doInfoText = null, dreamInfoText = null, dominateInfoText = null,title = null;
        switch (category){
            // MFG Technology
            case 1:
                title = "";
                dareInfoText = "To Fly High.";
                doInfoText = "Quantum leap with acceleration leads to exponential changes in results with extra ordinary ease.";
                dreamInfoText = "Small seeds of thought lead to mighty dreams.";
                dominateInfoText = "Go out, Conquer.";
                imageInfo = "Watch our Process Improvement and VUCA PREPAREDNESS and Plan for FY17-18 in our INSCAPE Stall";
                break;
            // EAM
            case 2:
                dareInfoText = "To be Different.";
                doInfoText = "Thoughts lead to action, action leads to achievement, achievement leads to fulfillment.";
                dreamInfoText = "Mind is a garden, thoughts are seeds, dreams are flowers that are waiting to blossom.";
                dominateInfoText = "Imbibe, Inspire, Innovate.";
                imageInfo = "How EAM & EWM help us? You want to know? Wait. We will explain in our INSCAPE Stall";
                break;
            // Bar code
            case 3:
                dreamInfoText = "Every thought, every dream is creating our future.";
                doInfoText = "Raise the Bar.";
                dareInfoText = "Foot prints of Excellence.";
                dominateInfoText = "The field of all possibilities is the source of all solutions.";
                imageInfo = "Why Barcode? What is our Productivity benefit? You want to know …..? Visit our INSCAPE Stall";
                break;
            // Purchase work bench
            case 4:
                dreamInfoText = "Higher than the sky and deeper than the Ocean.";
                doInfoText = "Be the Catalyst for Change.";
                dareInfoText = "To Dive deep and find Treasure of Gold.";
                dominateInfoText = "Seamless Approach.";
                imageInfo = "How IT is taking Lead in Purchase workbench? we will present in our INSCAPE Stall.";
                break;
            // OEE Resin
            case 5:
                dreamInfoText = "No star is too high, no goal is distant. Dreams are new that come true.";
                doInfoText = "Always do the impossible.";
                dareInfoText = "To traverse the unknown path.";
                dominateInfoText = "Trend setter.";
                imageInfo = "What is this Jargons? How it is related to Productivity and Scalability? We will explain to you in our INSCAPESCAPE stall";
                break;
            case 6:
                dreamInfoText = "Big, Have courage to pursue your dreams.";
                doInfoText = "Action speaks louder than Words.";
                dareInfoText = "To challenge your limits.";
                dominateInfoText = "Stir your Imagination.";
                imageInfo = "Change the Status Quo. Why don’t we explore concepts like VMI to manage Inventory Visit our INSCAPE Stall";
                break;
            // MFG Technology
            default:
                dareInfoText = "To Fly High.";
                doInfoText = "Quantum leap with acceleration leads to exponential changes in results with extra ordinary ease.";
                dreamInfoText = "Small seeds of thought lead to mighty dreams.";
                dominateInfoText = "Go out, Conquer.";
                imageInfo = "Watch our Process Improvement and VUCA PREPAREDNESS and Plan for FY17-18 in our INSCAPE Stall";
                break;

        }
        setTitle(title);
        dareInfoTV.setText(dareInfoText);
        doInfoTV.setText(doInfoText);
        dreamInfoTV.setText(dreamInfoText);
        dominateInfoTV.setText(dominateInfoText);
        imageInfoTV.setText(imageInfo);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
                // if this doesn't work as desired, another possibility is to call `finish()` here.
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
