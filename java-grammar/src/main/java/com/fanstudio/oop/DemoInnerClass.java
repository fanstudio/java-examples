package com.fanstudio.oop;

/**
 * @author zhangfan
 * @date 2019/3/8
 * @description
 */
public class DemoInnerClass {

    /**
     * 该类不能脱离外部类实体被创建,它可以访问外部类的数据和方法
     */
    public class InnerClass {
        public void print() {
            System.out.println("in InnerClass");
        }
    }


    /**
     * 能访问外部类的静态成员
     */
    public static class StaticClass {
        public void print() {
            System.out.println("in StaticClass");
        }
    }

    public static void main(String[] args) {
        // 必须先创建外部类的对象，然后才能创建
        DemoInnerClass demoClass = new DemoInnerClass();
        InnerClass innerClass = demoClass.new InnerClass();
        innerClass.print();

        // 内部静态类的实例化可以不用先创建外部类的对象
        StaticClass staticClass = new StaticClass();
        staticClass.print();

    }
}
