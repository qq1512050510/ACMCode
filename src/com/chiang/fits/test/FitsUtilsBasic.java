package com.chiang.fits.test;

import java.io.IOException;

import nom.tam.fits.BasicHDU;
import nom.tam.fits.Data;
import nom.tam.fits.Fits;
import nom.tam.fits.FitsException;
import nom.tam.fits.Header;

public class FitsUtilsBasic {
	public static void main(String[] args) {
		try {
			Fits fitsFile = new Fits("./src/gag_evt_202001-12_v00.fits");
			int countsHDU = fitsFile.getNumberOfHDUs();
			for (int i = 0; i < countsHDU; i++) {
				BasicHDU basicHDU = fitsFile.getHDU(i);
				Header header = basicHDU.getHeader();
				Data data = basicHDU.getData();
				System.out.println(header.getNumberOfCards());
				System.out.println(data.getSize());
				System.out.println(data.getData());
				
			}
		} catch (FitsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
