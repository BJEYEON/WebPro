package com.lec.ex2ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_FileWriter {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/lec/ex2ReaderWriter/outTest.txt",true);//(1)
//			char[] msg = {'��', '��', ' ', 'H', 'i', '\n'};
//			for (char m : msg) {
//				writer.write(m);//(2)
//			}
			String msg = "�ȳ�! Hi\n�帶ö �ǰ������ϼ���\n";
			writer.write(msg);
			msg = "�����ֱ��� ��´��. ��� �ǼۻǼ�\n";
			writer.write(msg);
			System.out.println("���� ��¿Ϸ�");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(writer != null) {//(3)
					writer.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
