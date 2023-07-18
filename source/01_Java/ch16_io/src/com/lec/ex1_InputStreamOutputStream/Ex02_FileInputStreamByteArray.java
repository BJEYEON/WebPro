package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1)��Ʈ���� ���� (������ ����) (2)�����͸� �д´�(byte[]) 3. ������ �ݴ´�
public class Ex02_FileInputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("C:\\WebPro\\source\\01_Java\\ch16_io\\txtFile\\inTest.txt");//(1)��Ʈ���� ���� (������ ����)�����, ������ ��ΰ���
			//(2)�����͸� �д´�(byte[])
			byte[] bs = new byte[10];
			while (true) {
				int readByteCount = is.read(bs); //bs�迭��ŭ �а� ���� byte ���� ����. ������ ���� -1
				if (readByteCount == -1) break;
				for (int i=0; i<readByteCount; i++) {
					System.out.print((char)bs[i]);
					//System.out.printf("%3d/", bs[i]);
				}
				//System.out.println();//����
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("�б������ ���ų� ������ �������" + e.getMessage());
		} finally {
			try {
				if (is!=null) is.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
			

	}
}
