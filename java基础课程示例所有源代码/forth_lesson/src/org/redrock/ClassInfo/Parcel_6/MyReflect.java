package org.redrock.ClassInfo.Parcel_6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by wang on 2017/8/17.
 */
public class MyReflect {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods)
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                for (Constructor ctor : constructors)
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            } else {
                for (Method method : methods)
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                for (Constructor ctor : constructors)
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String usage = "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "To search for methods involving 'word'";

    private static Pattern p = Pattern.compile("\\W+\\.");
}
