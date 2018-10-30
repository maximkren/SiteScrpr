package info.sjd.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import info.sjd.entity.Item;
import info.sjd.exception.ExceptionSJD;

public class AmazonParser {

	public static Item getItemInfo(String url) throws IOException, ExceptionSJD {

		Document document = Jsoup.connect(url).post();
		
		Item item = new Item();

		// URL==============================================================================
		item.setUrl(url);

		// ASIN(articleID)==================================================================
		Elements productDetailsElements = document.getElementById("productDetails_detailBullets_sections1")
				.getElementsByTag("tr");

		productDetailsElements.forEach(element -> {
			if (element.toString().contains("ASIN")) {
				item.setArticleID(element.child(1).text());
			}
		});

		// Rating===========================================================================

		productDetailsElements.forEach(element -> {
			if (element.toString().contains("Customer Reviews")
					&& !element.toString().contains("Be the first to review this item")) {
				item.setRating(element.getElementById("averageCustomerReviews").text().substring(0, 3));
			}
		});

		// Title============================================================================
		Element centerColumn = document.getElementById("centerCol");
		item.setTitle(centerColumn.getElementById("productTitle").text());

		// Description======================================================================
		String productDescription = "";

		for (Element element : centerColumn.getElementById("feature-bullets").getElementsByClass("a-list-item")) {
			if (!element.toString().contains("replacementPartsFitmentBulletInner")) {
				productDescription += element.text();
			}
		}
		item.setDescription(productDescription);

		// Price============================================================================
		item.setPrice(document.getElementById("priceblock_ourprice").text());

		// Availability=====================================================================
		if (document.getElementById("desktop_buybox").select("#availability").hasText()) {
			Element availability = document.getElementById("desktop_buybox").getElementById("availability");
			item.setAvailability(availability.getElementsByTag("span").text());
		}
		
		// =================================================================================

		return item;
	}
}
