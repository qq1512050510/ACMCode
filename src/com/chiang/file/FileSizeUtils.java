package com.chiang.file;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
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

	public static void main(String[] args) throws IOException {
		//String path = "./src/gag_evt_202001-12_v00.fits";
		//String path = "./src/testFile";
		String path = "./src/photo.jpg";

		File file = new File(path);
		System.out.println(file.length());
		System.out.println(FileSizeUtils.byteFormat(2048, true));
		FileImageInputStream fileImageInputStream = new FileImageInputStream(file);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[]buf = new byte[1024];
		int num = 0;
		while((num = fileImageInputStream.read(buf))!=-1){
			outputStream.write(buf,0,num);
		}
		byte[] out = outputStream.toByteArray();
		byte[] aa = Base64.decodeBase64(out);
		System.out.println();
		BASE64Encoder encoder = new BASE64Encoder();
		System.out.println(encoder.encode(out).length());
		outputStream.close();
		fileImageInputStream.close();

		InputStream in = new FileInputStream(path);
		System.out.println("文件大小（字节）="+in.available());
		byte[] data = new byte[in.available()];
		in.read(data);
		in.close();

		// 对字节数组进行Base64编码，得到Base64编码的字符串
		//BASE64Encoder encoder = new BASE64Encoder();
		String base64Str = encoder.encode(data);
		System.out.println(base64Str);
		File fileOut = new File("./src/out.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
		fileOutputStream.write(base64Str.getBytes());
		fileOutputStream.close();

	}

}
