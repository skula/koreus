package com.skula.koreus;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.skula.koreus.models.Video;
import com.skula.koreus.services.KoreusService;

public class MainActivity extends Activity {
	private GridView gridView;

	private int index;
	private String page;
	private Button btnPrevious;
	private Button[] btnPage;
	private Button btnNext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		setContentView(R.layout.activity_main);

		this.index = 0;
		this.page = "";

		this.btnPage = new Button[10];

		this.gridView = (GridView) findViewById(R.id.video_grid);
		this.gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Video item = (Video) gridView.getItemAtPosition(position);

				if (item.getUrl() != null) {
					Intent intent = new Intent(v.getContext(),
							VideoPlayerActivity.class);
					intent.putExtra("url", item.getUrl());
					startActivity(intent);
				} else {
					Toast.makeText(v.getContext(),
							"Erreur lors du chargement de la video...",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		btnPrevious = (Button) findViewById(R.id.btn_previous);
		btnPrevious.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (index > 0) {
					index--;
					updatePageLabel();
				}
			}
		});

		btnNext = (Button) findViewById(R.id.btn_next);
		btnNext.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				index++;
				updatePageLabel();
			}
		});

		btnPage[0] = (Button) findViewById(R.id.btn_page1);
		btnPage[0].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[0].getText().toString();
				fillGrid(btnPage[0].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[0].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[1] = (Button) findViewById(R.id.btn_page2);
		btnPage[1].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[1].getText().toString();
				fillGrid(btnPage[1].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[1].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[2] = (Button) findViewById(R.id.btn_page3);
		btnPage[2].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[2].getText().toString();
				fillGrid(btnPage[2].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[2].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[3] = (Button) findViewById(R.id.btn_page4);
		btnPage[3].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[3].getText().toString();
				fillGrid(btnPage[3].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[3].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[4] = (Button) findViewById(R.id.btn_page5);
		btnPage[4].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[4].getText().toString();
				fillGrid(btnPage[4].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[4].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[5] = (Button) findViewById(R.id.btn_page6);
		btnPage[5].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[5].getText().toString();
				fillGrid(btnPage[5].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[5].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[6] = (Button) findViewById(R.id.btn_page7);
		btnPage[6].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[6].getText().toString();
				fillGrid(btnPage[6].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[6].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[7] = (Button) findViewById(R.id.btn_page8);
		btnPage[7].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[7].getText().toString();
				fillGrid(btnPage[7].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[7].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[8] = (Button) findViewById(R.id.btn_page9);
		btnPage[8].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[8].getText().toString();
				fillGrid(btnPage[8].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[8].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

		btnPage[9] = (Button) findViewById(R.id.btn_page10);
		btnPage[9].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				page = btnPage[9].getText().toString();
				fillGrid(btnPage[9].getText().toString());
				for (int i = 0; i < 10; i++) {
					btnPage[i].setTextColor(Color.parseColor("#ffffff"));
				}
				btnPage[9].setTextColor(Color.parseColor("#32b3e2"));
			}
		});

	}

	private void updatePageLabel() {
		int p;
		for (int i = 0; i < 10; i++) {
			p = index * 10 + i + 1;
			btnPage[i].setText(String.valueOf(p));

			if (btnPage[i].getText().toString().equals(page)) {
				btnPage[i].setTextColor(Color.parseColor("#32b3e2"));
			} else {
				btnPage[i].setTextColor(Color.parseColor("#ffffff"));
			}
		}
	}

	private void fillGrid(String page) {
		List<Video> list = KoreusService.searchVideos(page);
		Video itemArray[] = (Video[]) list.toArray(new Video[list.size()]);
		VideoAdapter adapter = new VideoAdapter(this, R.layout.videolayout,
				itemArray);
		gridView.setAdapter(adapter);
	}
}
