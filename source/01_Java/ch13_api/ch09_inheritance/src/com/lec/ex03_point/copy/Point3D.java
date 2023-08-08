package com.lec.ex03_point.copy;
//X,y/ infoprint(좌표x,y)
//Point3D p = new Point3D(1,2,3)
public class Point3D extends Point {
	private int z;

	public Point3D(int x, int y, int z) {
		System.out.println("매개변수 있는Point3D생성자 - x,y,z초기화");
		setX(x);//this.x = x; protected만 가능
		this.z = z;
		setY(y);
		
	}
	@Override
	public void infoPrint() {
		System.out.println("좌표(x,y,z):" + getX() + "," + getY() + "," + z);
	}
//	public void infoPrint3d() {
//		System.out.println("좌표(x,y,z):" + getX() + "," + getY() + "," + z);
//	}
}
