package com.lec.ex06_bool;

public interface ILendable {
	public byte STATE_BORROWED = 1; //�������� �ǹ�
	public byte STATE_NORMAL = 0;//���Ⱑ���� �ǹ�
	public void checkOut(String borrower, String checkoutDate); //���� 
	public void checkIn(); //�ݳ�
	public void printState(); // å��ȣ å�̸�(����) ���Ⱑ�ɿ��� ���
}
