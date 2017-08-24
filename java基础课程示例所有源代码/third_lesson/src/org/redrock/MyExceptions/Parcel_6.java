package org.redrock.MyExceptions;

/**
 * �쳣��ʧ
 * ��ҵ�����Լ�����ģ������Ȼ�����бȽ�
 * @author wang
 *
 */
class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}
public class Parcel_6 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	public static void main(String[] args) {
		try {
			Parcel_6 p = new Parcel_6();
			try {
				p.f();
			} finally {
				p.dispose();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
