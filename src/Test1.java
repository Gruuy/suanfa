import javax.annotation.processing.AbstractProcessor;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 9:29 2019/10/12
 */
public class Test1 {
    public static void main(String[] args){
//        List<Integer> list=new ArrayList<>();
//        Integer.toBinaryString(100000);
//        Long item = Long.MAX_VALUE / 2;
//        Integer test = (int) item.longValue();
//        System.out.println(test );
//        System.out.println(item.intValue());
//        System.getProperties().forEach((a,b)-> System.out.println(a+":"+b));
//        System.out.println(Integer.reverseBytes(7));
//        System.out.println(Long.numberOfTrailingZeros(2097152));
//        Map<String,String> hashMap=new HashMap<>(  );
//        hashMap.put("1","1");
//        hashMap.entrySet();
//        int[] ints = {1, 5, 46, 4, 117, 1, 71, 17, 13, 1, 1, 15, 51, 5,1, 5, 46, 4, 117, 1, 71, 17, 13, 1, 1, 15, 51, 5,1, 5, 46, 4, 117, 1, 71, 17};
//        Arrays.sort(ints);
//        System.out.println(Arrays.toString(ints));

        System.out.println(maxSubArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }


    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

