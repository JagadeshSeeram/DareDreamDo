package com.justsmartapps.daredreamdo.activities;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.justsmartapps.daredreamdo.R;

public class CongratsDilaog extends Dialog {

	public CongratsDilaog(final Context context, int score, int total) {
		super(context);
		setContentView(R.layout.congrats);
		setTitle("");
		TextView textView = (TextView) findViewById(R.id.textView2);
		MediaPlayer mediaPlayer = MediaPlayer.create(
				context, R.raw.claps);
		mediaPlayer.start();
		textView.setText(score + "/" + total);
		textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
				((SubQuestionsActivity) context).finish();
			}
		});
	}

}
