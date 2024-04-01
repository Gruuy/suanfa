package LeetCode.Easy;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/11/3
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 有效的山脉数组 {

    public static boolean validMountainArray(int[] A) {
        if(A.length<3 || A[0]>=A[1]){
            return false;
        }
        boolean up = true;
        boolean down = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i]==A[i-1]) {
                return false;
            }
            if(up && A[i]<A[i-1]){
                up=false;
                continue;
            }
            if(!up && A[i]>A[i-1]){
                return false;
            }

        }

        return !up;
    }
    
    public static void main(String[] args){
        System.out.println(validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}) );
    }
}
