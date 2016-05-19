package com.gcproject.ezpz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class ReadID {

	private ReadID() {
	}

	public static String[] list = new String[12];

	public static String[] addFile() {

		try {
			FileReader reader = new FileReader("/Users/AJ/Desktop/vegid.txt");
			BufferedReader bufferedreader = new BufferedReader(reader);

			String line;
			int i = 0;
			
			while ((line = bufferedreader.readLine()) != null) {
				list[i] = line;
				i++;
			}

			bufferedreader.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return list;

	}

	public static void writeToFile(ArrayList<String[]> list) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream("/Users/AJ/Desktop/veginfo.txt"));

			for (int i = 0; i<list.size(); i++) {
				for(String item: list.get(i))
					out.print(item + "\n");
			}

			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}