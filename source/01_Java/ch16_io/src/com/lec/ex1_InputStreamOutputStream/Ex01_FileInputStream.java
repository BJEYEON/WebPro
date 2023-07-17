package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1)��Ʈ���� ���� (������ ����) (2)�����͸� �д´�(read�޼ҵ� ���) (3)������ �ݴ´�(close�޼ҵ� ���)
public class Ex01_FileInputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); //1.������ ����
			//2. �����͸� �д´�(���� ������ �ݺ������� �д´�)
			while (true) {
				int i = is.read();//1byte�� �д´�
				if (i == -1) {
					break;// ������ ���̸� 
				}
				System.out.print((char)i);
			}
			System.out.println("\n = = = Done = = =");
		} catch (FileNotFoundException e) {
			System.out.println("���� �޼��� (������ ��ã��): " + e.getMessage());
		} catch (IOException e) {
			System.out.println("���� �޼���(������):" + e.getMessage());
		}finally {
			try {
				if (is!=null) is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
