package info.sjd.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import info.sjd.entity.Item;
import info.sjd.exception.ExceptionSJD;

public class Parser {

	public static Item getItemInfo(String url) throws IOException, ExceptionSJD {

		Document document = Jsoup.connect(url).get();
		Item item = new Item();
		Elements parsedData;

		//URL
		item.setUrl(url);

		//Article ID
		parsedData = document.select("#productDetails_detailBullets_sections1");
		item.setArticleID(parsedData.text().substring(5, 15));

		//Item Title
		parsedData = document.select("#productTitle");
		item.setTitle(parsedData.text());
		
		//Item Description

		parsedData = document.select("#feature-bullets");
		item.setDescription(parsedData.text());

		//Rating
		parsedData = document.getElementsByAttributeValue("class", "arp-rating-out-of-text");
		if(parsedData.text().length()>0) {
		item.setRating(parsedData.text().substring(0, 3));
		}else {
			item.setRating("No Rating");
		}

		//Price
		parsedData = document.select("#priceblock_ourprice");
		item.setPrice(parsedData.text());

		//Availability
		parsedData = document.select("#availability");
		System.out.println(parsedData.text());
		item.setAvailability(parsedData.text());

		return item;
	}

}
