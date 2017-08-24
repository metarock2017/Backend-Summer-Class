package org.redrock.MyExceptions;

/**
 * @author wang
 *
 */
public class Parcel_2 {

	public static void main(String[] args) {
		try {
			f();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Caught Exception");
			System.out.println("getMessage: " + e.getMessage());
			System.out.println("getLocalizedMessage: " + e.getLocalizedMessage());
			System.out.println("toString: " + e.toString());
			System.out.println("printStackTrace: ");
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws NullPointerException
	 */
	public static void f() throws NullPointerException, ArrayIndexOutOfBoundsException {
		throw new ArrayIndexOutOfBoundsException("Test");
	}

}
