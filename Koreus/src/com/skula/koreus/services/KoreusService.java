
package com.skula.koreus.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.skula.koreus.models.Video;

public class KoreusService {
	public static List<Video> searchVideos(String page) {
		List<Video> res = new ArrayList<Video>();
		try {
			// File f = new File("C:/Users/KULAST/Desktop/Sopra/sopra/NF/koreus/koreusList.html");
			// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			URLConnection connection = new URL("http://www.koreus.com/videos/nouveau/").openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			
			String url;
			String title;
			String pict;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if(line.contains("td valign=\"top\"")){
					url = line.substring(line.indexOf("http://www.koreus.com"), line.indexOf("\"><img"));
					url = url.replace("video", "embed");
					url = url.substring(0, url.indexOf(".html"));
					title = line.substring(line.indexOf("Video\" title=\"") + 14, line.indexOf("\" width=\"150\""));					
					pict = line.substring(line.indexOf("http://thumbs"), line.indexOf("\" alt=\""));
					res.add(new Video(url, escapeHTML(title), pict));
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return res;
	}
	
	private static String escapeHTML(String line){
		line = line.replace("&agrave;","�");
		line = line.replace("&acirc;","�");
		line = line.replace("&auml;","�");
		line = line.replace("&ccedil;","�");
		line = line.replace("&egrave;","�");
		line = line.replace("&eacute;","�");
		line = line.replace("&ecirc;","�");
		line = line.replace("&euml;","�");
		line = line.replace("&icirc;","�");
		line = line.replace("&iuml;","�");
		line = line.replace("&ocirc;","�");
		line = line.replace("&ouml;","�");
		line = line.replace("&ugrave;","�");
		line = line.replace("&ucirc;","�");
		line = line.replace("&uuml;","�");
		line = line.replace("&#039;","'");
		return line;
	}
	
	/*public static List<Map<String, String>> searchVideos(String page) {
		List<Map<String, String>> res = new ArrayList<Map<String, String>>();
		try {
			// File f = new File("C:/Users/KULAST/Desktop/Sopra/sopra/NF/koreus/koreusList.html");
			// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			URLConnection connection = new URL("http://www.koreus.com/modules/news/videos" + page + ".html").openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			
			String url;
			String title;
			String pict;
			Map<String, String> map = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if(line.contains("td valign=\"top\"")){
					url = line.substring(line.indexOf("http://www.koreus.com"), line.indexOf("\"><img"));
					url = url.replace("video", "embed");
					url = url.substring(0, url.indexOf(".html"));
					title = line.substring(line.indexOf("Video\" title=\"") + 14, line.indexOf("\" width=\"150\""));					
					
					pict = line.substring(line.indexOf("http://thumbs"), line.indexOf("\" alt=\""));
					
					map = new HashMap<String, String>();
					map.put("url", url);
					map.put("title", title);
					map.put("pict", pict);
					res.add(map);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return res;
	}*/
}
