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
import android.widget.EditText;
import android.widget.ListView;

import com.skula.koreus.models.Video;
import com.skula.koreus.services.KoreusService;


public class MainActivity extends Activity {
	private ListView itemList;
	private EditText pageNum;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);	
		setContentView(R.layout.activity_main);
		
		this.pageNum = (EditText) findViewById(R.id.page_number);
		
		this.itemList = (ListView) findViewById(R.id.video_list);
		itemList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				Video item = (Video) itemList.getItemAtPosition(position);
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
				startActivity(browserIntent);
			}
		});
		
		Button btnSearch = (Button)findViewById(R.id.btn_search);
		btnSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String np = pageNum.getText().toString();
				if(!np.isEmpty()){//!np.matches("\\d")){
					try {
						fillList(KoreusService.searchVideos(np));
					} catch (Exception e) {
					}
				}
			}
		});
	}

	private void fillList(List<Video> list) {		
		Video itemArray[] = (Video[]) list.toArray(new Video[list.size()]);
		VideoAdapter adapter = new VideoAdapter(this, R.layout.videolayout, itemArray);
		itemList.setAdapter(adapter);
	}
}
