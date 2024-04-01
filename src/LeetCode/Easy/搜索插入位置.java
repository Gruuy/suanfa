package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 23:39 2019/11/6
 */
@SuppressWarnings("all")
public class 搜索插入位置 {
    public static void main(String[] args){
        int[] a={1,3,5,6};
        System.out.println(searchInsert(a, 2));
    }
    /** 二分 */
    public static int searchInsert(int[] nums, int target) {
        if(nums.length==0||nums[0]>target) return 0;
        if(nums[nums.length-1]<target) return nums.length;
        int left=0,right=nums.length-1;
        int mid;
        while (left<=right){
            mid=left+(right-left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    /** 自己的二分 */
    public static int searchInsert2(int[] nums,int target){
        //默认进来有序  第一个小的直接return  最大的大过也是
        if(nums.length==0||nums[0]>target) return 0;
        if(nums[nums.length-1]<target) return nums.length;
        //左右指针  中指针
        int left=0,right=nums.length-1;
        int center;
        while (left<=right){
            //防止溢出
            center=left+(right-left+1)/2;
            //只有两个的话  左右判断
            if(center==left||center==right) return nums[left]>=target?left:right;
            //否则就中分 左右指针根据值进行调整
            if(nums[center]==target) return center;
            else if(nums[center]>target) right=center;
            else left=center;
        }
        return left;
    }
}
