package com.gcproject.ezpz;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParseHTML {


	public static String getTitle(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		Elements title = doc.select("div.submitter__description");
		return title.text();
	}

	
	
}
