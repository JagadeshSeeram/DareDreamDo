package com.justsmartapps.daredreamdo.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.justsmartapps.daredreamdo.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class QuestionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Questions");
        ListView list = (ListView) findViewById(R.id.questions_header_list);

        final ArrayList<QAItem> qaItems = prepareData();
        QuestionAdapter questionAdapter = new QuestionAdapter(qaItems);
        list.setAdapter(questionAdapter);
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                QAItem qaItem = qaItems.get(position);
                Intent intent = new Intent(QuestionsActivity.this,
                        SubQuestionsActivity.class);
                intent.putExtra("QUESTION", position);
                intent.putExtra("TITLE", qaItem.title);

                startActivity(intent);
            }
        });
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

    class QuestionAdapter extends BaseAdapter {

        private ArrayList<QAItem> qualityQuestions;

        public QuestionAdapter(ArrayList<QAItem> qaItems) {
            this.qualityQuestions = qaItems;
        }

        @Override
        public int getCount() {
            return qualityQuestions.size();
        }

        @Override
        public Object getItem(int position) {
            return qualityQuestions.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class ViewHolder {
            TextView question;
        }

        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = getLayoutInflater().inflate(R.layout.header_item,
                        parent, false);
                holder.question = (TextView) convertView
                        .findViewById(R.id.question_header);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            QAItem question = qualityQuestions.get(position);
            holder.question.setText(question.title);
            return convertView;
        }

    }

    private ArrayList<QAItem> prepareData() {
        ArrayList<QAItem> qaItems = new ArrayList<QAItem>();
        for (int i = 0; i < 6; i++) {
            QAItem qaItem = new QAItem();
            qaItem.id = i;
            switch (i) {
                case 0:
                    qaItem.title = "Quality";
                    break;
                case 1:
                    qaItem.title = "Engineering";
                    break;
                case 2:
                    qaItem.title = "Production";
                    break;
                case 3:
                    qaItem.title = "PPG AP";
                    break;
                case 4:
                    qaItem.title = "HR";
                    break;
                case 5:
                    qaItem.title = "Admin";
                    break;
                default:
                    break;
            }
            qaItems.add(qaItem);
        }
        return qaItems;
    }

}
