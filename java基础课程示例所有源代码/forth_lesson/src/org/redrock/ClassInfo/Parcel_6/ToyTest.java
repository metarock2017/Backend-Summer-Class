package org.redrock.ClassInfo.Parcel_6;

import java.lang.reflect.*;
import java.util.regex.Pattern;

/**
 * Created by wang on 2017/8/21.
 */
public class ToyTest {
//    public String str = "public class" + "classNmae {" + "\r\n" +
//            "private " + "field.getType()" + "arg0" + "\r\n" +
//            "class.getSimpleName(" + "constructor.getParamterType()";
//    public String filename = "$className0.java";
    private String name;
    private double price;

    public ToyTest(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public ToyTest() {}

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void Test(int i, double d, String s, Class c) throws Exception {
        throw new Exception("reflect test");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        sb.append(this.name);
        sb.append(" price: ");
        sb.append(this.price);
        sb.append(" }");
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Pattern p = Pattern.compile("\\w+\\.");
        Class c = ToyTest.class;
        Constructor[] constructors = c.getConstructors();
        //System.out.println(constructors.toString());
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            System.out.println(p.matcher(m.toString()).replaceAll(""));
            Parameter[] parameters = m.getParameters();
            //System.out.println(m.getParameterCount());
            Type[] types = m.getGenericParameterTypes();
            for (Type type : types) {
                System.out.println(type.getTypeName());
            }
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getType() + " "  + parameter.getName());
            }
        }
        System.out.println("-------分隔符------");
        for (Constructor ctor : constructors) {
            System.out.println(ctor.getParameterCount());
            Type[] types = ctor.getParameterTypes();
            for (Type type : types)
                System.out.println(type.getTypeName());
            Type[] types1 = ctor.getGenericParameterTypes();
            for (Type type : types1)
                System.out.println(type.getTypeName());
            System.out.println(ctor.toGenericString());
            System.out.println(p.matcher(ctor.toString()).replaceAll(""));
        }

        //通过构造器实例化对象
        Class[] params = {String.class, double.class};
        Object[] value = {"熊", 12.1};
        Constructor constructor = c.getDeclaredConstructor(params);
        try {
            ToyTest toyTest = (ToyTest) constructor.newInstance(value);
            System.out.println(toyTest);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //通过Class 的 newInstance 方法实例化对象,类中必须有默认构造函数
        try {
            Object obj = c.newInstance();
            Method setName = c.getDeclaredMethod("setName", String.class);
            Method setPrice = c.getDeclaredMethod("setPrice", double.class);
            setName.invoke(obj, "车");
            setPrice.invoke(obj, 20.3);
            System.out.println(obj.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
