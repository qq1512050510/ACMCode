package com.chiang.file;

import java.io.File;
import java.util.Locale;

public class FileSizeUtils {

	/**
	 * 
	 * @param bytes
	 *            转换得字节
	 * @param si
	 *            是否需要单位
	 * @return
	 */
	public static String byteFormat(long bytes, boolean si) {
		String[] units = new String[] { " B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB" };
		int unit = 1024;
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		double pre = 0;
		pre = bytes / Math.pow(unit, exp);
		//修改
		/*if (bytes > 1024) {
			pre = bytes / Math.pow(unit, exp);
		} else {
			pre = (double) bytes / (double) unit;
		}*/
		if (si) {
			return String.format(Locale.ENGLISH, "%.1f%s", pre, units[(int) exp]);
		}
		return String.format(Locale.ENGLISH, "%.1f", pre);
	}

	public static void main(String[] args) {
		//String path = "./src/gag_evt_202001-12_v00.fits";
		String path = "./src/testFile";
		File file = new File(path);
		System.out.println(file.length());
		System.out.println(FileSizeUtils.byteFormat(2048, true));
	}

}
