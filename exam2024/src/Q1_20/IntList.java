package Q1_20;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-19
 * Time: 22:41
 */
public class IntList
{
    protected IntList next;
    protected IntList prev;
    protected int value;
    public IntList(int value)
    {
        prev = null;
        this.value = value;
    }
    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public IntList next()
    {
        if ( next == null )
        {
            next = new IntList(value);
            next.prev = this;
        }
        return next;
    }
    public IntList previous()
    {
        return prev;
    }
    public String toString(int n)
    {
        String sv = String.valueOf(value);
        if (n>1)
        {
            sv = sv + ", " + next().toString(n-1);
        }
        return sv;
    }

    public static void main(String[] args) {
        IntList x5 = createIntList(new int []{5,2,6,7});
        System.out.println(x5.toString(6) );
    }
    public static IntList createIntList (int[] ns){
        IntList head = new IntList(ns[0]);
        IntList cur = head;
        for (int i = 1; i <= ns.length-1; i++) {
            IntList next = new IntList(ns[i]);
            cur.next = next;
            next.prev =cur;
            cur = next;
        }
        return head;
    }
}
class IntListInc extends IntList{
    int inc = 0;
    public IntListInc (int value, int val){
        super(value);
        this.inc = val;
    }
    public IntList next(){
        if ( next == null ) {
            int nextValue = this.value + this.inc;
            this.next = new IntListInc(nextValue, this.inc);
            next.prev = this;
        }
        return this.next;
    }
}
