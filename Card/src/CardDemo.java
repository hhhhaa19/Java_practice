import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-16
 * Time: 23:04
 */
public class CardDemo {
    public static final String[] suits = {"♥", "♦", "♣", "♠"};

    public static List<Card> buy() {
        List<Card> cl = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card();
                card.setSize(j + 1);
                card.setSuit(suits[i]);
                cl.add(card);
            }
        }
        return cl;
    }

    public static void swap(List<Card> cards, int i, int r) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(r));
        cards.set(r, temp);
    }

    public static void shuffle(List<Card> cl) {
        Random rd = new Random();

        for (int i = cl.size() - 1; i > 0; i--) {
            int r = rd.nextInt(i);
            swap(cl, i, r);
        }

    }

    public static void main(String[] args) {
        List<Card> cl = buy();
        System.out.println(cl);
        shuffle(cl);
        System.out.println(cl);
        List<List<Card>> mans =new ArrayList<>();//里面存三副牌,其实也可以再创
        //三个顺序表，但这连续性不好
       mans.add(new ArrayList<>());
        mans.add(new ArrayList<>());
        mans.add(new ArrayList<>());
        for (int i = 0; i <= 51; i++) {
            mans.get(i%3).add(cl.remove(0));
        }
        System.out.println(mans.get(0));
    }
}
