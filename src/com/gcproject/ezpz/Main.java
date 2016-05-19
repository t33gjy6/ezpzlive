package com.gcproject.ezpz;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {

		String[] ids = new String[12];
		ArrayList<String[]> list = new ArrayList<String[]>();
		ids = ReadID.addFile();
		
		for(String id : ids){
			list.add(API.getData(id));
		}
		
		ReadID.writeToFile(list);
		
	}

}
