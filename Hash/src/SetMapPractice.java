import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-12-10
 * Time: 18:31
 */
public class SetMapPractice {
    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            } else {
                hashSet.add(nums[i]);
            }
        }
        return (int) hashSet.toArray()[0];
    }

    /**
     * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
     *
     * @param jewels
     * @param stones
     * @return
     */
    public static int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char cur :
                jewels.toCharArray()) {
            hashSet.add(cur);
        }
        int count = 0;
        for (char cur :
                stones.toCharArray()) {
            if (hashSet.contains(cur)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
     * 肯定坏掉的那些键
     *
     * @param correct
     * @param wrong
     */
    public static void lackKeyboard(String correct, String wrong) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char cur :
                wrong.toUpperCase().toCharArray()) {
            hashSet.add(cur);
        }
        for (char cur :
                correct.toUpperCase().toCharArray()
        ) {
            if (!hashSet.contains(cur)) {
                hashSet.add(cur);
                System.out.print(cur);
            }
        }
        //两个问题：1、数组不能强转，2、相对顺序变化
//        for (Object cur :
//                hashSet.toArray()) {
//            System.out.println(cur);
//        }
    }

    /**
     * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
     * 经典的topK问题
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cur : words) {
            if (map.containsKey(cur)) {
                int val = map.get(cur);
                map.put(cur, val + 1);
            } else {
                map.put(cur, 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<Map.Entry<String, Integer>>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() - o1.getValue() == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        //注意：Map与Map.Entry本身都是接口，不能实例化，但Hashmap与Treemap有具体的Node实现了这个接口，然后以返回值的形式
        //实现了向上转型，完成了多态
        for (Map.Entry<String, Integer> cur :
                map.entrySet()) {
            heap.add(cur);
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(heap.poll().getKey());
        }
        return ret;
    }

    /**
     * 给你一个整数数组 nums 。
     * 如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int cur :
                nums) {
            if (map.containsKey(cur)) {
                int count = map.get(cur);
                map.put(cur, count + 1);
            } else {
                map.put(cur, 1);
            }
        }
        for (Integer num : map.values()) {
            if (num >= 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 思路一：循环队列的思路,但查找很麻烦
     * 思路二：快慢指针
     *
     * @param nums
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int slow = 0;
        int fast = slow + k ;
        HashSet<Integer> set = new HashSet<>(k);
        for (int i = 0; i < k&&i<nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        while(fast<nums.length){
            if(set.contains(nums[fast])){
                return true;
            }else{
                set.add(nums[fast]);
            }
            set.remove(nums[slow]);
            slow++;
            fast++;
        }
        return false;
    }

}
