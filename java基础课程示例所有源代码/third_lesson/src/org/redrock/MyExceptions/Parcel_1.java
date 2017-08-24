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
		// TODO 作业：将抛出异常全部记录到文件中
	}

}

class LoggingException {
	private static Logger logger = Logger.getLogger("LoggingException");
	
	static void LoggingException (Exception e) {
		String logPath = "C:/log/myLog";
		try {
			FileHandler fh = new FileHandler(logPath);
			fh.setFormatter(new SimpleFormatter());  //更改日志存储格式，原本为XML,更改为普通文本
			logger.setUseParentHandlers(false);
			logger.addHandler(fh);
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		StringWriter trace = new StringWriter();
		//默认的printStackTrace()不会产生字符串，为了获得，需要使用重载的方法，他接受一个java.io.PrintWriter对象作为参数
		//将一个java.io.StringWriter对象给PrintWriter的构造器，那么通过toString方法就可以获得一个字符串
		e.printStackTrace(new PrintWriter(trace));
		//Logger对象会将输出默认（根据日志等级）发送的System.err
		logger.severe(trace.toString());
	}
}