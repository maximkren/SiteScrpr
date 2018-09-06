package info.sjd.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import info.sjd.entity.Item;
import info.sjd.exception.ExceptionSJD;

public class XMLFileProcessor {

	static String itemFile = "src/info/sjd/content/items.xml";

	public static void createFile(String fileAddress) {
		try (FileWriter fw = new FileWriter(itemFile)) {

			fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n<items>\n</items>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static synchronized void addContentToFile(Item item) throws ExceptionSJD {

		StringBuilder existingContent = new StringBuilder();

		if (item == null) {

			throw new ExceptionSJD("Item object is not initialized");

		} else {

			if (!new File(itemFile).exists()) {

				createFile(itemFile);

				addContentToFile(item);

			} else {

//-----------------------------

				try (BufferedReader br = new BufferedReader(new FileReader(itemFile))) {

					String line = br.readLine();

					while (line != null) {
						existingContent.append(line);
						existingContent.append(System.lineSeparator());
						line = br.readLine();
					}

				} catch (IOException e) {
					System.out.println("reading from file failed");
					e.printStackTrace();

				}

//------------------------------

				try (FileWriter fileWriter = new FileWriter(itemFile)) {

					fileWriter.write(existingContent.toString().substring(0, existingContent.length() - 10));
					fileWriter.write(item.toString());
					fileWriter.write(System.lineSeparator());
					fileWriter.write(existingContent.toString().substring(existingContent.length() - 10));
					fileWriter.flush();
				} catch (IOException e) {
					System.out.println("recording to file failed");
					e.printStackTrace();
				}

			}
		}
	}
}
