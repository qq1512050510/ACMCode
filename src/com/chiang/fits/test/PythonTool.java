package com.chiang.fits.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PythonTool {

	public static void main(String[] args) {
		String[] arguments = new String[] {"python","D:\\DISK\\pythonWork\\Math\\MathCalculate\\fits\\FitsUtils.py"};
		List<String> argList = new ArrayList<String>();
		String fitsPath = "D:\\DISK\\pythonWork\\Math\\MathCalculate\\gag_evt_202001-12_v00.fits";
		argList.addAll(Arrays.asList(arguments));
		argList.add(fitsPath);
		try {
			System.out.println(String.join(" ", argList));
			Process process = Runtime.getRuntime().exec(String.join(" ", argList));
			BufferedReader in= new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			//读取所有信息
			while((line=in.readLine())!=null) {
				System.out.println(line);
			}
			in.close();
			int re = process.waitFor();
			System.out.println(re);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
