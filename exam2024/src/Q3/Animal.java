package Q3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-19
 * Time: 16:06
 */
public class Animal implements flyable,flyable2
{
    private String colour;
    public Animal(String c) {
        colour = c;
    }
    public String says(){
        return "";
    };
    public String colour() { return colour; }
    public boolean chases(Animal a2){
        return false;
    };

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
class Mouse extends Animal
{
    public Mouse(String c) { super(c);}
    public String says() { return "Squeak"; }
    public boolean chases(Animal a2) { return false; }
}
class Dog extends Animal
{
    public Dog(String c) { super(c);}
    public String says() { return "Woof"; }
    public boolean chases(Animal a2) {
        return a2 instanceof Cat;
    }
}
class Cat extends Animal
{
    public Cat(String c) { super(c);}
    public String says() { return "Meow"; }
    public boolean chases(Animal a2) {
        return a2 instanceof Mouse;
    }
}

