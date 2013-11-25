package com.skula.koreus;

import com.skula.koreus.services.KoreusService;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerActivity extends Activity {
	VideoView video_player_view;
	DisplayMetrics dm;
	SurfaceView sur_View;
	MediaController media_Controller;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.videoplayerlayout);
		
		Bundle extras = getIntent().getExtras();
		String url = extras.getString("url");
		getInit(KoreusService.getVideoUri(url));
	}

	public void getInit(String uri) {
		video_player_view = (VideoView) findViewById(R.id.video_player_view);
		media_Controller = new MediaController(this);

		dm = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(dm);
		int height = dm.heightPixels;
		int width = dm.widthPixels;
		video_player_view.setMinimumWidth(width);
		video_player_view.setMinimumHeight(height);
		video_player_view.setMediaController(media_Controller);
		video_player_view.setVideoURI(Uri.parse(uri));
		video_player_view.start();
	}
}