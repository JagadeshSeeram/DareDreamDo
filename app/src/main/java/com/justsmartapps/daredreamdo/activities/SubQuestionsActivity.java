package com.justsmartapps.daredreamdo.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
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

public class SubQuestionsActivity extends Activity {
	private ArrayList<Question> qualityQuestions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_layout);
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
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			int questionInt = extras.getInt("QUESTION");
			String title = extras.getString("TITLE");
			getActionBar().setTitle(title);
			if (questionInt == 0) {
				qualityQuestions = prepareQualityQuestions();
			} else if (questionInt == 1) {
				qualityQuestions = prepareEnggQuestions();
			} else if (questionInt == 2) {
				qualityQuestions = prepareProductionQuestions();
			} else if (questionInt == 3) {
				qualityQuestions = preparePPGQuestions();
			} else if (questionInt == 4) {
				qualityQuestions = prepareHRQuestions();
			} else if (questionInt == 5) {
				qualityQuestions = prepareAdminQuestions();
			}
		}

		QuestionAdapter adapter = new QuestionAdapter(qualityQuestions);
		listView.setAdapter(adapter);
	}

	private ArrayList<Question> prepareProductionQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question one = new Question();
		one.question = "1. What is the shade in which we are not reaching PRSL in last 5 Months in SBU?";
		one.answers[0] = "Golden Brown";
		one.answers[1] = "Lemon Yellow";
		one.answers[2] = "PGE EB1";
		one.answers[3] = "AMC Magenta";
		one.rightAnswer = 1;
		questions.add(one);

		Question two = new Question();
		two.question = "2. What is the Trade Plan Achievement% in the year 14 - 15 ?";
		two.answers[0] = "94.47%";
		two.answers[1] = "93.01%";
		two.answers[2] = "92.10%";
		two.answers[3] = "98.0%";
		two.rightAnswer = 1;
		questions.add(two);

		Question three = new Question();
		three.question = "3. What is Trade PSI % for the Year 14 -15?";
		three.answers[0] = "96.5%";
		three.answers[1] = "99.82%";
		three.answers[2] = "100%";
		three.answers[3] = "98.99%";
		three.rightAnswer = 2;
		questions.add(three);

		Question four = new Question();
		four.question = "4.	For year 14 -15 which section had met the highest PRSL";
		four.answers[0] = "SPB";
		four.answers[1] = "EPS";
		four.answers[2] = "Stiff";
		four.answers[3] = "IPU";
		four.rightAnswer = 3;
		questions.add(four);

		Question five = new Question();
		five.question = "5.	What is the Highest plant volume produced per month in the year 14 � 15?";
		five.answers[0] = "8200 KL";
		five.answers[1] = "8250 KL";
		five.answers[2] = "8327 KL";
		five.answers[3] = "8400 KL";
		five.rightAnswer = 3;
		questions.add(five);

		Question six = new Question();
		six.question = "6. Plant Highest achieved PRSL in 14-15?";
		six.answers[0] = "98.95";
		six.answers[1] = "99.14";
		six.answers[2] = "98.91";
		six.answers[3] = "98.89";
		six.rightAnswer = 1;
		questions.add(six);
		return questions;
	}

	private ArrayList<Question> prepareAdminQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question one = new Question();
		one.question = "1. Number of detentions in 2014-15?";
		one.answers[0] = "51";
		one.answers[1] = "58";
		one.answers[2] = "55";
		one.answers[3] = "52";
		one.rightAnswer = 4;
		questions.add(one);

		Question two = new Question();
		two.question = "2.	What is the truck turnaround time (TTAT) for 2014-15?";
		two.answers[0] = "8.12Hrs";
		two.answers[1] = "8.19Hrs";
		two.answers[2] = "8.25Hrs";
		two.answers[3] = "8.30Hrs";
		two.rightAnswer = 1;
		questions.add(two);

		Question three = new Question();
		three.question = "3. What is the GR compliance(%) for the year of 2014-15?";
		three.answers[0] = "92.8%";
		three.answers[1] = "91.7%";
		three.answers[2] = "93%";
		three.answers[3] = "95.4%";
		three.rightAnswer = 2;
		questions.add(three);

		Question four = new Question();
		four.question = "4.	What is the approximate FLL of PAT plant in 14-15 against target of 2%?";
		four.answers[0] = "2.54%";
		four.answers[1] = "3.11%";
		four.answers[2] = "2.69%";
		four.answers[3] = "2.81%";
		four.rightAnswer = 1;
		questions.add(four);

		Question five = new Question();
		five.question = "5.	What is the percentage of same day unloading in 14-15?";
		five.answers[0] = "90%";
		five.answers[1] = "91.2%";
		five.answers[2] = "92.6%";
		five.answers[3] = "93.1%";
		five.rightAnswer = 2;
		questions.add(five);

		return questions;
	}

	private ArrayList<Question> prepareQualityQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question one = new Question();
		one.question = "1. What is the No of NCIP figure in the Year 14-15?";
		one.answers[0] = "21";
		one.answers[1] = "23";
		one.answers[2] = "22";
		one.answers[3] = "26";
		one.rightAnswer = 1;
		questions.add(one);

		Question two = new Question();
		two.question = "2. The Plant Average QRI for the Year 14-15 stands at? ";
		two.answers[0] = "9.77";
		two.answers[1] = "9.75";
		two.answers[2] = "9.85";
		two.answers[3] = "9.64";
		two.rightAnswer = 1;
		questions.add(two);

		Question three = new Question();
		three.question = "3. Give the number of statutory legal notices in the year 14 � 15?";
		three.answers[0] = "4";
		three.answers[1] = "6";
		three.answers[2] = "1";
		three.answers[3] = "0";
		three.rightAnswer = 3;
		questions.add(three);

		Question four = new Question();
		four.question = "4.	Hygiene Audit score in 13 �14?";
		four.answers[0] = "91";
		four.answers[1] = "100";
		four.answers[2] = "96";
		four.answers[3] = "none";
		four.rightAnswer = 1;
		questions.add(four);

		Question five = new Question();
		five.question = "5.	Number of Frozen batch at PAT Linked OPCs at 14 - 15?";
		five.answers[0] = "45";
		five.answers[1] = "47";
		five.answers[2] = "6";
		five.answers[3] = "10";
		five.rightAnswer = 3;
		questions.add(five);

		Question six = new Question();
		six.question = "6. What is the target of Plant Average QRI?";
		six.answers[0] = "9.55";
		six.answers[1] = "9.85";
		six.answers[2] = "9.86";
		six.answers[3] = "9.91";
		six.rightAnswer = 2;
		questions.add(six);
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

	private ArrayList<Question> prepareEnggQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question one = new Question();
		one.question = "1. What is the uptime target of Packing Machine for the year 14- 15?";
		one.answers[0] = "96.34";
		one.answers[1] = "95.0";
		one.answers[2] = "99.0";
		one.answers[3] = "100";
		one.rightAnswer = 3;
		questions.add(one);

		Question two = new Question();
		two.question = "2. What is the DC uptime value in the year 14 � 15?";
		two.answers[0] = "99.80";
		two.answers[1] = "96.12";
		two.answers[2] = "92.86";
		two.answers[3] = "99.99";
		two.rightAnswer = 2;
		questions.add(two);

		Question three = new Question();
		three.question = "3. What is the target for More than 8 Hrs Breakdown for the year 14 � 15?";
		three.answers[0] = "6";
		three.answers[1] = "2";
		three.answers[2] = "0";
		three.answers[3] = "15";
		three.rightAnswer = 1;
		questions.add(three);

		Question four = new Question();
		four.question = "4.	What is the Target value for PM adherence for the Year 14 -15?";
		four.answers[0] = "96%";
		four.answers[1] = "100%";
		four.answers[2] = "99%";
		four.answers[3] = "99.99%";
		four.rightAnswer = 2;
		questions.add(four);

		Question five = new Question();
		five.question = "5.	What is the Plant SPC target for the Year 14 � 15?";
		five.answers[0] = "105.6";
		five.answers[1] = "110";
		five.answers[2] = "112.3";
		five.answers[3] = "114.10";
		five.rightAnswer = 1;
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
