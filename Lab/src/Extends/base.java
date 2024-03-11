package Extends;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-10
 * Time: 20:14
 */

public class base {
    private int a ;
    public Iterable print(){
        System.out.println(this.a);
        return null;
    }
    String name ;

    public base(int b) {
        this.a = b;
        this.name = "s";
    }
}

class child extends base{
    public child(int b, int b1) {
        super(b);
        this.b = b1;

    }

    int b ;

    @Override
    public ArrayList print() {
        super.print();
        return null;
    }
}
