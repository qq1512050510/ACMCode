package com.chiang.fits.test;

public class FitsValidate implements Runnable {
	//
	private String fileDir;

	public FitsValidate(String fileDir) {
		this.fileDir = fileDir;
	}

	@Override
	public void run() {
		if (fileDir == null || fileDir == "") {
			System.out.println("文件地址为空");
		} else {
			System.out.printf("文件地址为：%s", fileDir);
			FitsUtils.validateFile(fileDir);
			System.out.println("等待文件验证通过 大致时间 30分钟");
		}
	}

	public static void main(String[] args) {
		new FitsValidate("./src/gag_evt_202001-12_v00.fits").run();
	}

}
