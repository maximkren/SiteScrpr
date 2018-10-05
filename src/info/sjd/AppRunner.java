package info.sjd;

import org.jsoup.Jsoup;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import info.sjd.entity.Item;
import info.sjd.exception.ExceptionSJD;
import info.sjd.parser.Parser;
import info.sjd.processor.XMLFileProcessor;

public class AppRunner {
	public static void main(String[] args) throws Exception {

		// JAXB
		// e(fx)eclipse 3.0
		

		String url = "https://www.amazon.com/STOCK-Office-Inking-Rubber-Stamp/dp/B076P84WGS/ref=olp_product_details?_encoding=UTF8&me=&qid=1538747416&sr=8-2-spons";
		
		
//		Document document = Jsoup.connect(url).get();
//	//	Item item = new Item();
//		Elements parsedData;
//		
//		
//		parsedData = document.select("#productDetails_detailBullets_sections1");
//		
//		System.out.println(parsedData.text().substring(5, 15));
		
		
		
		try {
			XMLFileProcessor.addContentToFile(Parser.getItemInfo(url));
		} catch (ExceptionSJD e) {
			e.printStackTrace();
		}
	}

}
