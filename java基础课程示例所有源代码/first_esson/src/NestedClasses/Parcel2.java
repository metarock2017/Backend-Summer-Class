package NestedClasses;

/**
 * Created by wang on 2017/8/2.
 */
public class Parcel2 {
    private String instAtt = "实例变量";
    private static String Att = "静态变量";
    private static String staticAtt = "外部类的类变量";
    public void test() {
        int methodAtt = 1;
        final int methodFinalAtt = 2;
        /**非静态方法里的内部类 */
        class MethodInnerClass {
            @Override
            public String toString() {
                System.out.println("非静态方法的内部类可以访问外部类的实例变量：" + instAtt);
                System.out.println("非静态方法的内部类可以访问外部类的静态变量：" + staticAtt);
                System.out.println("非静态方法的内部类可以访问方法的final变量：" + methodFinalAtt);
                return "my nick name is white";
            }
        }
        System.out.println("-------------分隔符-------------");
        new MethodInnerClass().toString();
        /**非静态方法的匿名内部类*/
        new Object() {
            @Override
            public String toString() {
                System.out.println("非静态方法的匿名内部类可以访问外部类的实例变量：" + instAtt);
                System.out.println("非静态方法的匿名内部类可以访问外部类的静态变量：" + staticAtt);
                System.out.println("非静态方法里匿名内部类可以访问方法的非final的变量: " + methodAtt);
                System.out.println("非静态方法的匿名内部类可以访问方法的final变量：" + methodFinalAtt);
                return "我是匿名内部类";
            }
        }.toString();
    }

    public static void main(String[] agrs) {
        int methodAtt = 1;
        final int methodFinalAtt = 2;
        /**静态方法里的内部类*/
        class MethodInnerClass {
            @Override
            public String toString() {
                // 静态方法里无法访问实例的外部变量(非静态变量)
                //System.out.println(instAtt);
                System.out.println("静态方法的内部类可以访问外部类的静态变量：" + staticAtt);
                System.out.println("静态方法里可以访问方法的非final的变量: " + methodAtt);
                System.out.println("静态方法的内部类可以访问方法的final变量：" + methodFinalAtt);
                return "my nick name is white";
            }
        }
        new MethodInnerClass().toString();
        /**静态方法的匿名内部类*/
        new Object() {
            @Override
            public String toString() {
                // 静态方法的匿名内部类不能访问外部类的非静态变量
                // System.out.println("静态方法的匿名内部类可以访问外部类的非静态变量：" + instAtt);
                System.out.println("静态方法的匿名内部类可以访问外部类的静态变量：" + staticAtt);
                System.out.println("静态方法里匿名内部类可以访问方法的非final的变量: " + methodAtt);
                System.out.println("静态方法的匿名内部类可以访问方法的final变量：" + methodFinalAtt);
                return "我是匿名内部类";
            }
        }.toString();

        new Parcel2().test();
        // 建立静态内部类(staticInnerClass)的对象
        ImOutClass.StaticInnerClass staticIC = new ImOutClass.StaticInnerClass();
        staticIC.access();

        System.out.println("-------------分隔符-------------");

        /**
         * 建立非静态内部类(non-staticInnerClass)的对象.
         * 注意这种建立对象的格式首先创建外部类的对象然后使用对象.new来创建。
         */
        ImOutClass outC = new ImOutClass();
        ImOutClass.InstInnerClass inC = outC.new InstInnerClass();
        inC.access();

        System.out.println("-------------分隔符-------------");
        ImOutClass.StaticInnerClass.access();
    }
}

class ImOutClass {
    private static String staticAtt = "外部类的静态类变量";
    private String instAtt = "外部类的实例变量";
    private static String xx = "外部静态变量";

    // 外部类的非静态方法
    public void instanMethod() {
        System.out.println("和外部类实例方法");
    }
    // 外部类的静态方法
    public static void staticMethod() {
        System.out.println("和外部类静态方法");
    }
    /** 静态内部类(staticInnerClass)*/
    public static class StaticInnerClass {
        public void InnerClass() {
            System.out.println("我是静态内部类");
        }
        public static void access() {
            System.out.println("我可以访问" + staticAtt);
            staticMethod();
            System.out.println("我可以访问" + xx);
            // 非静态的方法instanMethod()无法从静态的地方使用
            // instanMethod();
        }
    }
    /** 非静态内部类(non-staticInnerClass)*/
    public class InstInnerClass {
        public InstInnerClass() {
            System.out.println("我是成员级内部类，非静态内部类");
        }
        public void access() {
            System.out.println("我可以访问" + instAtt);
            instanMethod();
            staticMethod();
            System.out.println("我可以访问" + xx);
        }
    }
}

//1. 非静态内部类中不能有静态修饰成员
//2. 内部类也会产生一个 .class 文件
//3. 静态内部类智能访问外部类的静态成员，而非静态类可以访问外部类的所有成员
//4. 实例化非静态内部类 .new 方法
//5. 实例化静态内部类 不依赖与外部类的实例 直接实例化内部类
//6.