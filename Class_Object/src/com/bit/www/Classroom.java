package com.bit.www;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-23
 * Time: 11:06
 */
public class Classroom {
    public int capacity;
    static private int code=23;
    public Classroom(int capacity) {
        this.capacity = capacity;
    }
    static public void show(){
        System.out.println("静态方法");
        System.out.println(code);
    }

}
