package LeetCode.困难;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 17:27 2019/10/24
 */
@SuppressWarnings("all")
public class 寻找两个有序数组的中位数 {
    public static void main(String[] args) {
//        System.out.println(1%2 );
        int[] b={1,3,5,7,9};
        int[] a={2,4,6,8};
        System.out.println(findMedianSortedArrays(a,b) );
    }

    /** 基本思想就是 两个数组  通过不停的调整I下标  J跟随其增大减小  算出最合适的值  通过这个值求中位数 */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        //如果M比N长  换下位置
        if (m > n) {
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        //i的最小为0   最大为数组的总长度  求他们中位数的坐标
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            //i为较小数组的下标  j为较大的下标
            int i = (iMin + iMax) / 2;
            //中位数坐标固定  i用了一些  j肯定是中位-i
            int j = halfLen - i;
            //i不大于等于最大是基本前提   否则会溢出
            //如果 分割后I数组的最大   小于J数组的最小
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // 增大I的最小值  使其中位坐标向右偏移
            }
            //如果  分割后I数组的最大  大于J数组的最小
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // 减小I的最大值  使其中位坐标向左偏移
            }
        //如果到最后i=iMin或者iMax  就说明i的位置已经在最中间了
        else {
            int maxLeft = 0;
            //如果i数组已经为空了  那么中位数都在j数组
            if (i == 0) { maxLeft = B[j-1]; }
            //如果j数组都为空了  那么中位数在i数组
            else if (j == 0) { maxLeft = A[i-1]; }
            //如果都不为空  比较iRight与jLeft
            else { maxLeft = Math.max(A[i-1], B[j-1]); }
            //如果中位数只有一个   直接返回
            if ( (m + n) % 2 == 1 ) { return maxLeft; }

            //否则才需要进行运算
            int minRight = 0;
            //如果i已经是最顶了   最小右值就在J数组
            if (i == m) { minRight = B[j]; }
            //如果j到顶了   最小右值就在I数组
            else if (j == n) { minRight = A[i]; }
            //如果都没到顶   最小值就需要在他们之间求一下
            else { minRight = Math.min(B[j], A[i]); }
            //中位数=(left+right)/2
            return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
