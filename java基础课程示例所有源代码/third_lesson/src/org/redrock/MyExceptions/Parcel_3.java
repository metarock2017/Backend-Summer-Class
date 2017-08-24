package org.redrock.MyExceptions;

/**
 * @author wang
 *
 */
public class Parcel_3 {

	static void f() {
		try {
			throw new Exception();
		} catch (Exception e) {
			for(StackTraceElement ste : e.getStackTrace())
				System.out.println(ste.getFileName() + " " + ste.getClassName() + " " + ste.getMethodName() + "(), at line " + ste.getLineNumber());
		}
	}
	static void g() { f();}
	static void h() { g();}
	public static void main(String[] args) {
		h();
	}

}
