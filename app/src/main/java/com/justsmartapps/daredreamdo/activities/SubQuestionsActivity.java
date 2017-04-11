package com.justsmartapps.daredreamdo.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.justsmartapps.daredreamdo.R;

public class SubQuestionsActivity extends AppCompatActivity {
	private ArrayList<Question> qualityQuestions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_layout);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		toolbar.setTitle("Questions");
		Button done = (Button) findViewById(R.id.done_button);
		done.setVisibility(View.VISIBLE);
		done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences preferences = getSharedPreferences("MyPref",
						MODE_PRIVATE);
				preferences.edit().putBoolean("VALUE", true).commit();
				int count = 0;
				for (Question question : qualityQuestions) {
					if (question.selectedAnswer == question.rightAnswer) {
						count++;
					}
				}
				new CongratsDilaog(SubQuestionsActivity.this, count,
						qualityQuestions.size()).show();
			}
		});
		ListView listView = (ListView) findViewById(R.id.questions_header_list);
		qualityQuestions = prepareQualityQuestions();
		QuestionAdapter adapter = new QuestionAdapter(qualityQuestions);
		listView.setAdapter(adapter);
	}


	private ArrayList<Question> prepareQualityQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question one = new Question();
		one.question = "1. Number of TSD Phase in Chennai Express?";
		one.answers[0] = "3";
		one.answers[1] = "4";
		one.answers[2] = "5";
		one.answers[3] = "Single Pass";
		one.rightAnswer = 1;
		questions.add(one);

		Question two = new Question();
		two.question = "2. Application of Bar coding is?";
		two.answers[0] = "True";
		two.answers[1] = "False";
		two.answers[2] = "Dont Know";
		two.answers[3] = "Incorrect Question";
		two.rightAnswer = 1;
		questions.add(two);

		Question three = new Question();
		three.question = "3. RI not applicable for Emulsions?";
		three.answers[0] = "True";
		three.answers[1] = "False";
		three.answers[2] = "Dont Know";
		three.answers[3] = "Incorrect Question";
		three.rightAnswer = 3;
		questions.add(three);

		Question four = new Question();
		four.question = "4.	Which Plant is highest OEE?";
		four.answers[0] = "Kasna";
		four.answers[1] = "Sri";
		four.answers[2] = "PAT";
		four.answers[3] = "Rothak";
		four.rightAnswer = 1;
		questions.add(four);

		Question five = new Question();
		five.question = "5.	Bar Code is not applicable for Bulk packs?";
		five.answers[0] = "True";
		five.answers[1] = "False";
		five.answers[2] = "Dont Know";
		five.answers[3] = "Incorrect Question";
		five.rightAnswer = 3;
		questions.add(five);

		Question six = new Question();
		six.question = "6. VMI is implemented in which Plant?";
		six.answers[0] = "Kasna";
		six.answers[1] = "Sri";
		six.answers[2] = "PAT";
		six.answers[3] = "Rothak";
		six.rightAnswer = 2;
		questions.add(six);

		Question seven = new Question();
		seven.question = "7. VMI is implemented in which Plant?";
		seven.answers[0] = "True";
		seven.answers[1] = "False";
		seven.answers[2] = "Dont Know";
		seven.answers[3] = "Incorrect Question";
		seven.rightAnswer = 2;
		questions.add(seven);

		Question eight = new Question();
		eight.question = "8. SETU increases change over time?";
		eight.answers[0] = "True";
		eight.answers[1] = "False";
		eight.answers[2] = "Dont Know";
		eight.answers[3] = "Incorrect Question";
		eight.rightAnswer = 2;
		questions.add(eight);
		return questions;
	}

	private ArrayList<Question> prepareHRQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question one = new Question();
		one.question = "1. Audacious goal taken by PAT plant in year 15-16?";
		one.answers[0] = "Faster Grievance redressal";
		one.answers[1] = "Reduction in man power absenteeism by 50%";
		one.answers[2] = "20 Promotions ";
		one.answers[3] = "Faster completion of settlement negotiation";
		one.rightAnswer = 3;
		questions.add(one);

		Question two = new Question();
		two.question = "2.	Maximum period for addressing the resolving the grievances?";
		two.answers[0] = "<15 Days";
		two.answers[1] = "<30 Days";
		two.answers[2] = "<7 Days";
		two.answers[3] = "On same day itself";
		two.rightAnswer = 1;
		questions.add(two);

		return questions;
	}

	private ArrayList<Question> preparePPGQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question one = new Question();
		one.question = "1. IPU comes under which business group?";
		one.answers[0] = "JV1";
		one.answers[1] = "JV2";
		one.answers[2] = "DBU";
		one.answers[3] = "GBU";
		one.rightAnswer = 1;
		questions.add(one);

		Question two = new Question();
		two.question = "2. What is the Highest priority with regards to IPU QA for year 15 � 16?";
		two.answers[0] = "Reduction of stuckup Batches";
		two.answers[1] = "Zero Ncip";
		two.answers[2] = "Cycle time";
		two.answers[3] = "All";
		two.rightAnswer = 1;
		questions.add(two);

		Question three = new Question();
		three.question = "3. In PAT vision statement what is the volume of IPU products we ar looking at?";
		three.answers[0] = "2500";
		three.answers[1] = "4200";
		three.answers[2] = "3700";
		three.answers[3] = "4500";
		three.rightAnswer = 2;
		questions.add(three);

		Question four = new Question();
		four.question = "4.	Which of the following product declared as NCIP due to cissing?";
		four.answers[0] = "School Yellow";
		four.answers[1] = "Passion Red";
		four.answers[2] = "RC Pink";
		four.answers[3] = "Top Coat Clear";
		four.rightAnswer = 1;
		questions.add(four);

		Question five = new Question();
		five.question = "5.	Number of NCIPs in IPU for the year of 14-15?";
		five.answers[0] = "2";
		five.answers[1] = "3";
		five.answers[2] = "4";
		five.answers[3] = "5";
		five.rightAnswer = 3;
		questions.add(five);

		return questions;
	}


	class QuestionAdapter extends BaseAdapter {

		public QuestionAdapter(ArrayList<Question> qualityQuestions) {
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
			RadioGroup radioGroup;
			RadioButton radio1;
			RadioButton radio2;
			RadioButton radio3;
			RadioButton radio4;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			ViewHolder holder = null;
			// if (convertView == null) {
			// holder = new ViewHolder();
			// convertView = getLayoutInflater().inflate(
			// R.layout.question_item, parent, false);
			// holder.question = (TextView) convertView
			// .findViewById(R.id.question);
			// holder.radioGroup = (RadioGroup) convertView
			// .findViewById(R.id.answers);
			// holder.radio1 = (RadioButton) convertView
			// .findViewById(R.id.radio0);
			// holder.radio1.setId(1);
			// holder.radio2 = (RadioButton) convertView
			// .findViewById(R.id.radio1);
			// holder.radio2.setId(2);
			// holder.radio3 = (RadioButton) convertView
			// .findViewById(R.id.radio2);
			// holder.radio3.setId(3);
			// holder.radio4 = (RadioButton) convertView
			// .findViewById(R.id.radio3);
			// holder.radio4.setId(4);
			// convertView.setTag(holder);
			//
			// } else {
			// holder = (ViewHolder) convertView.getTag();
			// }
			holder = new ViewHolder();
			convertView = getLayoutInflater().inflate(R.layout.question_item,
					parent, false);
			holder.question = (TextView) convertView
					.findViewById(R.id.question);
			holder.radioGroup = (RadioGroup) convertView
					.findViewById(R.id.answers);
			holder.radio1 = (RadioButton) convertView.findViewById(R.id.radio0);
			holder.radio1.setId(1);
			holder.radio2 = (RadioButton) convertView.findViewById(R.id.radio1);
			holder.radio2.setId(2);
			holder.radio3 = (RadioButton) convertView.findViewById(R.id.radio2);
			holder.radio3.setId(3);
			holder.radio4 = (RadioButton) convertView.findViewById(R.id.radio3);
			holder.radio4.setId(4);
			convertView.setTag(holder);
			Question question = qualityQuestions.get(position);
			holder.question.setText(question.question);
			holder.radio1.setText(question.answers[0]);
			holder.radio2.setText(question.answers[1]);
			holder.radio3.setText(question.answers[2]);
			holder.radio4.setText(question.answers[3]);
			if (question.selectedAnswer > 0) {
				RadioButton r = (RadioButton) holder.radioGroup
						.getChildAt(question.selectedAnswer - 1);
				r.setChecked(true);
				// holder.radioGroup.check(question.selectedAnswer);
			} else {
				holder.radioGroup.clearCheck();
			}
			holder.radioGroup.setTag(position);
			holder.radioGroup
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(RadioGroup group,
								int checkedId) {
							if (checkedId == 0) {
								return;
							}
							int tag = (int) group.getTag();
							Question selectedQuestion = qualityQuestions
									.get(tag);
							selectedQuestion.selectedAnswer = checkedId;
						}
					});
			return convertView;
		}

	}
}
