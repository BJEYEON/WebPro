package com.lec.ex4_newException;

public interface ILendable {
	public byte STATE_BORROWED = 1; //�������� �ǹ�
	public byte STATE_NORMAL = 0;//���Ⱑ���� �ǹ�
	public void checkOut(String borrower); //���� (�������� �Է�, �������� ����)
	public void checkIn()throws Exception; //�ݳ�
	public void printState(); // å��ȣ å�̸�(����) ���Ⱑ�ɿ��� ���
}
