package com.imooc.luckypan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private LuckyPan luckyPan;
	private ImageView startBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		luckyPan = (LuckyPan) findViewById(R.id.lucky_pan);
		startBtn = (ImageView) findViewById(R.id.start_button);

		startBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!luckyPan.isRunning()) {
					luckyPan.luckyStart(0);
					startBtn.setImageResource(R.drawable.stop);
				} else {
					if (!luckyPan.isShouldEnd()) {
						luckyPan.luckyEnd();
						startBtn.setImageResource(R.drawable.start);
					}
				}
			}
		});
	}
}
