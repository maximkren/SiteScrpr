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



		String url = "https://www.amazon.com/STOCK-Office-Inking-Rubber-Stamp/dp/B076P84WGS/ref=olp_product_details?_encoding=UTF8&me=&qid=1538747416&sr=8-2-spons";
		
		try {
			XMLFileProcessor.addContentToFile(Parser.getItemInfo(url));
		} catch (ExceptionSJD e) {
			e.printStackTrace();
		}
	}

}
