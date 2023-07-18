package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//������ ����(��Ʈ�� ��ü����) ->���� ->������ �ݴ´�
public class Ex03_FileOutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); //�⺻false(������ ������ ����.������ ������ ���)//true: �߰���
	//		byte[] bs = {'h', 'e', 'l', 'l', 'o', '\n'};
			String msg = "Hi. Java\n01234567\n�ȳ�";
			byte[] bs = msg.getBytes();// ��Ʈ���� ����Ʈ�� �ٲ�
//			for (int i=0; i<bs.length; i++) {
//				os.write(bs[i]);
//			}//for
			os.write(bs);
			System.out.println("���� ��¿Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println("���� ��ã��. ���ܸ޼���: " + e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(os!=null) os.close();
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}//main

}
