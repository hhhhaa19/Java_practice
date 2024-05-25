package Q3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-19
 * Time: 15:39
 */
public class test {
    public static void main(String args[]) {
//        int x = 0;
//        for (int i = 1; i <= 10; i++) {
//            x+=i;
//            if(i>1) System.out.print(",");
//            System.out.print(x);
//        }
//        System.out.println("");
        System.out.println(new test().noises(new Animal[]{
                new Cat("1"), new Cat("2"), new Dog("3"), new Mouse("4")
        }));
    }

    public String noises(Animal[] animals) {
        String s = "";
        for (Animal a : animals) {
            s += a.says();
        }
        return s;
    }
}
