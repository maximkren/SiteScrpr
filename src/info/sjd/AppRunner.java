package info.sjd;


//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;
import info.sjd.exception.ExceptionSJD;
import info.sjd.parser.AmazonParser;
import info.sjd.processor.XMLFileProcessor;

public class AppRunner {
	public static void main(String[] args) throws Exception {



		String url = "https://www.amazon.com/Yamaha-AG03-3-Channel-Mixer-Microphone/dp/B00TY8JE60/";

		try {
			XMLFileProcessor.addContentToFile(AmazonParser.getItemInfo(url));
		} catch (ExceptionSJD e) {
			e.printStackTrace();
		}
	}

}
