package com.hck.player.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hck.myplayer.R;
import com.hck.player.date.LocalDate;
import com.hck.player.utils.SharedPreference;
//import com.jmp.sfc.uti.JMPManager;
//import com.wole56.sdk.APP;

public class LodingActivity extends BaseActivity  {
	private ImageView imageView; 
	private Animation animation; 
    private View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loding);
		init();
		new SharedPreference(this); 
		
		//JMPManager manager = new JMPManager ();
        //manager.startService(this,1);
		imageView = (ImageView) findViewById(R.id.img);
		animation = AnimationUtils.loadAnimation(this, R.anim.loding);
		imageView.setAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}
			@Override
			public void onAnimationRepeat(Animation animation) {

			}
			@Override
			public void onAnimationEnd(Animation animation) {
				
			}
		});
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			view.setVisibility(View.GONE);
           startMainActivity();
		};
	};
	private void init() {
		view=findViewById(R.id.pb);

		new Thread() {
			@Override
			public void run() {
				super.run();
                /*
				APP.init(getApplicationContext(), LocalDate.app_id,
						LocalDate.app_key).toString();
				*/
				handler.sendEmptyMessage(0);
			}
		}.start();
	}

	
	private void startMainActivity() {
		startActivity(new Intent(LodingActivity.this, MainActivity.class)); // 锟斤拷intent锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		this.finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	
	}

	
}
