package org.redrock.MyExceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wang
 *
 */
public class Parcel_7 {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("test.txt");
			try {
				String s;
				int i = 1;
				while ((s = in.getLine()) != null) {
					System.out.println(s);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				in.dispose();
			}
		} catch(Exception e) {
			System.out.println("InputFile construction failed");
		}
	}
}

class InputFile {
	private BufferedReader in;
	
	public InputFile(String fileName) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + fileName);
			throw e;
		} catch (Exception e){
			try {
				in.close();
			} catch(IOException e2) {
				System.out.println("in.close() unsuccessful");
			}
			throw e;
		} finally {
			//??????????Reader
		}
	}
	
	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch(IOException e) {
			throw new RuntimeException("redlin() failed");
		}
		return s;
	}
	
	public void dispose() {
		try {
			in.close();
		} catch(IOException e) {
			throw new RuntimeException("in.close() failed");
		}
	}
}