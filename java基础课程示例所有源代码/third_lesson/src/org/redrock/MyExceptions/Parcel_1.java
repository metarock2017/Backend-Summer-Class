package org.redrock.MyExceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Parcel_1 {

	public static void main(String[] args) {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			LoggingException.LoggingException(e);
		}
		// TODO ��ҵ�����׳��쳣ȫ����¼���ļ���
	}

}

class LoggingException {
	private static Logger logger = Logger.getLogger("LoggingException");
	
	static void LoggingException (Exception e) {
		String logPath = "C:/log/myLog";
		try {
			FileHandler fh = new FileHandler(logPath);
			fh.setFormatter(new SimpleFormatter());  //������־�洢��ʽ��ԭ��ΪXML,����Ϊ��ͨ�ı�
			logger.setUseParentHandlers(false);
			logger.addHandler(fh);
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		StringWriter trace = new StringWriter();
		//Ĭ�ϵ�printStackTrace()��������ַ�����Ϊ�˻�ã���Ҫʹ�����صķ�����������һ��java.io.PrintWriter������Ϊ����
		//��һ��java.io.StringWriter�����PrintWriter�Ĺ���������ôͨ��toString�����Ϳ��Ի��һ���ַ���
		e.printStackTrace(new PrintWriter(trace));
		//Logger����Ὣ���Ĭ�ϣ�������־�ȼ������͵�System.err
		logger.severe(trace.toString());
	}
}