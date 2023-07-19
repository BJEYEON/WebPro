package com.lec.ex4_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

// printWriter : OutputStream�� �⺻ ��Ʈ������ �ϴ� ���� ��Ʈ��
//BufferedReader : Reader�� �⺻ ��Ʈ������ �ϴ� ������Ʈ��
//printWriter ȥ�� �⺻��Ʈ��ó�� ���
public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
			//1. PrintWriter : OutputStream�� ���� ��Ʈ��
//			os = new FileOutputStream("txtFile/outTest.txt",true);
//			printWriter = new PrintWriter(os);
			
			//2. printWriter: Writer�� ������Ʈ��
//			writer = new FileWriter("txtFile/outTest.txt",true);
//			printWriter = new PrintWriter(writer);
			
			//3. PrintWrite�� �⺻ ��Ʈ��ó�� ���
			printWriter = new PrintWriter("txtFile/outTest.txt");
			//�ֹܼ� ���� ���
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			printWriter.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			System.out.print("print�� �ڵ������� �ȵſ�. �׷��� �����߰�\n");
			printWriter.print("print�� �ڵ������� �ȵſ�. �׷��� �����߰�\n");
			System.out.printf("%s %3d %3d %5.1f\n", "ȫ�浿", 100,100,100.0);
			printWriter.printf("%s %3d %3d %5.1f\n", "ȫ�浿", 100,100,100.0);
			System.out.printf("%s %3d %3d %5.1f\n", "�ű浿", 90,91,90.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "�ű浿", 90,91,90.5);
			System.out.printf("%s %3d %3d %5.1f\n", "�ڱ浿", 95,97,96.0);
			printWriter.printf("%s %3d %3d %5.1f\n", "�ڱ浿", 95,97,96.0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (printWriter!=null) printWriter.close();
				if (os!=null) os.close();
				if (writer!=null) writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
