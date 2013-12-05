package com.skula.koreus;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.skula.koreus.models.Video;
import com.skula.koreus.utils.DownloadImageTask;
import com.skula.koreus.utils.PictureUtils;

public class VideoAdapter extends ArrayAdapter<Video> {
	Context context;
	int layoutResourceId;
	Video data[] = null;

	public VideoAdapter(Context context, int layoutResourceId, Video[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Video item = data[position];
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.videolayout, parent, false);

		TextView url = (TextView) rowView.findViewById(R.id.video_url);
		url.setText(item.getUrl());
		
		TextView title = (TextView) rowView.findViewById(R.id.video_title);
		title.setText(item.getTitle());
		
		Bitmap btm = PictureUtils.loadBitmap(item.getPic());
		if(btm!=null){
			ImageView pic = (ImageView) rowView.findViewById(R.id.video_pic);
			pic.setImageBitmap(btm);
		}
		
		/*new DownloadImageTask((ImageView) rowView.findViewById(R.id.video_pic))
            .execute(item.getPic());
		*/
		return rowView;
	}
}