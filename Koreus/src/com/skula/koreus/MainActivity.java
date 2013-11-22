package com.skula.koreus;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.skula.koreus.models.Video;
import com.skula.koreus.services.KoreusService;

public class MainActivity extends Activity {
	private TextView pageNumber;
	private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);   
		setContentView(R.layout.activity_main);

		pageNumber = (TextView) findViewById(R.id.page_number);
		gridView = (GridView) findViewById(R.id.video_grid);
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Video item = (Video) gridView.getItemAtPosition(position);
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse(item.getUrl()));
				startActivity(browserIntent);
			}
		});

		Button btnSearch = (Button) findViewById(R.id.btn_search);
		btnSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String np = pageNumber.getText().toString();
				if (!np.isEmpty()) {// !np.matches("\\d")){
					try {
						fillGrid(KoreusService.searchVideos(np));
					} catch (Exception e) {
					}
				}
			}
		});
	}

	private void fillGrid(List<Video> list) {
		Video itemArray[] = (Video[]) list.toArray(new Video[list.size()]);
		VideoAdapter adapter = new VideoAdapter(this, R.layout.videolayout,
				itemArray);
		gridView.setAdapter(adapter);
	}
}
