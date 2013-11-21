package com.skula.koreus.utils;

import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PictureUtils{
	public static Bitmap loadBitmap(String url){
        URL newurl;
		try {
			newurl = new URL(url);
			return BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
		} catch (Exception e) {
			return null;
		}
	}
	/*public static Bitmap loadBitmap(String url) {
		Bitmap bitmap = null;
		InputStream in = null;
		BufferedOutputStream out = null;

		try {
			in = new BufferedInputStream(new URL(url).openStream(), IO_BUFFER_SIZE);

			final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
			out = new BufferedOutputStream(dataStream, IO_BUFFER_SIZE);
			copy(in, out);
			out.flush();

			final byte[] data = dataStream.toByteArray();
			BitmapFactory.Options options = new BitmapFactory.Options();
			bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,options);
		} catch (IOException e) {
			Log.e(TAG, "Could not load Bitmap from: " + url);
		} finally {
			closeStream(in);
			closeStream(out);
		}

		return bitmap;
	}*/
}