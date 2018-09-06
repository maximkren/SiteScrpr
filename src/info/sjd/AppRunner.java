package info.sjd;

import java.io.IOException;

import info.sjd.entity.Item;
import info.sjd.exception.ExceptionSJD;
import info.sjd.processor.XMLFileProcessor;
//import info.sjd.processor.XMLProcessor;;

public class AppRunner {

	public static void main(String[] args) throws IOException {
		// String url =
		// "https://www.amazon.com/LG-gram-Thin-Light-Laptop/dp/B078WRSHV4/ref=sr_1_82_sspa";
		// System.out.println(XMLProcessor.assembleElement("item", "item info"));

		Item item = new Item();
		item.setTitle(
				"15Z980-U.AAS5U1");
		item.setDescription(
				"The updated LG gram arrives with an impressive 15.6” 1080p IPS display and improved 72Wh battery");
		item.setRating("4.2");
		item.setPrice("$1,147.00");

		try {
			XMLFileProcessor.addContentToFile(item);
		} catch (ExceptionSJD e) {
			e.printStackTrace();
		}
	}

}
