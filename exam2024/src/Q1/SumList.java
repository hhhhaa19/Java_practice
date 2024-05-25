package Q1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-19
 * Time: 14:12
 */
public class SumList {
    public SumList prev;
    public SumList next;
    public int value;

    public SumList(int value) {
        this.value = value;
    }

    public SumList next() {
        if (next == null) {
            int sum = value;
            if (prev != null)
                sum += prev.value;
            next = new SumList(sum);
            next.prev = this;
        }
        return next;
    }

    public String toString(int n) {
//        String str = value + "";
//        Q1.SumList curr = this;
//        Q1.SumList next = curr.next();
//        while (n > 1) {
//            str += ";"+next.value ;
//            next = next.next();
//            n--;
//        }
//        return str;
        String s1 = value + "";
        if (n > 1) {
            s1 = s1 + ";" + next().toString(n - 1);
        }
        return s1;

    }
    public String toString(){
        String s1 = value + "";
        if(next() != null){
            s1 = s1 + ";" + next.toString();
        }
        return s1;
    }


    public void setValue(int n) {
        this.value = n;
        this.prev = null;
        SumList curr = this;
        while (curr.next != null) {
            curr.next = null;
            curr = curr.next();
        }
    }

    public static void main(String[] args) {
        SumList l1 = new SumList(2);
        System.out.println(l1.toString(5));
        l1.next.setValue(5);
        System.out.println(l1.toString(5));
        System.out.println(l1.toString());
    }
}

