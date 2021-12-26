package com.QRCodeGenerator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class GenerateQRCode {
//static function that creates QR Code  
	public static void generateQRcode(String data, String path, String charset, Map map, int h, int w)
			throws WriterException, IOException {

		BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, w, h);
		MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
	}

//main() method  
	public static void main(String args[]) throws WriterException, IOException, NotFoundException {
//data that we want to store in the QR code  
		String str = "Sagar | 7030378473 | Developer";
//path where we want to get QR Code  
		String path = "C:\\Users\\Sagar\\Downloads\\Eidiko\\QRCodeGenerator\\Quote.png";
//Encoding charset to be used  
		String charset = "UTF-8";
		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//invoking the user-defined method that creates the QR code  
		generateQRcode(str, path, charset, hashMap, 200, 200);// increase or decrease height and width accodingly
//prints if the QR code is generated   
		System.out.println("QR Code created successfully.\n" + path);
	}
}