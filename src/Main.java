import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
@SuppressWarnings("all")
    public static void main(String[] args) {
//        1.
//        Scanner scanner=new Scanner(System.in);
//        int n,m;
//        n=scanner.nextInt();
//        m=scanner.nextInt();
//        if(n%(2*m)!=0){
//            return;
//        }
//        System.out.println(m*m*n/(2*m));

//        2.
//        Scanner scanner2=new Scanner(System.in);
//        int n;
//        String i;
//        n=Integer.valueOf(scanner2.nextLine());
//        i=scanner2.nextLine();
//        if(n<1 || n>Math.pow(10,5)){
//            return;
//        }
//        String[] ai=i.split(",");
//        List<Integer> aI=new ArrayList<>(ai.length);
//        for(int j=0;j<ai.length;j++){
//            int math=Integer.valueOf(ai[j]);
//            if(math<1||math>Math.pow(10,9)){
//                System.out.println("输入有误！" );
//                return;
//            }
//            aI.add(math);
//        }
//        Collections.sort(aI);
//        int niuniuScore=0;
//        int yangyangScore=0;
//        boolean flag=true;
//        //最优策略就是从大到小
//        n--;
//        for(;n>0;n--){
//            if(flag){
//                niuniuScore+=aI.get(n);
//                flag=false;
//            }else{
//                yangyangScore+=aI.get(n);
//                flag=true;
//            }
//        }
//        System.out.println("牛牛："+niuniuScore );
//        System.out.println("羊羊："+yangyangScore );

//        3.
//        Scanner scanner3=new Scanner(System.in);
//        int i,j;
//        i=scanner3.nextInt();
//        j=scanner3.nextInt();
//
//        if(i<=0||i>Math.pow(10,4)*5){
//            return;
//        }
//        if(j<=0||j>Math.pow(10,6)){
//            return;
//        }
//        int low=1;
//        int high=j;
//        while(true){
//            int mid=(low+high)/2;
//            int sum=count(i,mid);
//            if(sum>j){
//                high-=1;
//            }
//            if(sum<j){
//                low+=1;
//            }
//            if(sum==j){
//                System.out.println("one day eat:"+mid );
//                break;
//            }
//
//        }

//        4.

    final int mod = 1000000007;
    //构建杨辉三角  用于求相同的数有几个一样的组合
    int[][] c=new int[105][105];
    c[0][0]=1;
    for(int i=1;i<=100;i++){
        c[i][0]=1;
        for(int j=1;j<=100;j++){
            c[i][j] = (c[i-1][j-1]+c[i-1][j])%mod;
        }
    }
    //输入
    Scanner sc = new Scanner(System.in);
    //目标和
    int k=sc.nextInt();
    //长度a             x首
    int a=sc.nextInt(), x=sc.nextInt();
    //长度b             y首
    int b=sc.nextInt(), y=sc.nextInt();
    //sum=a组合数*b组合数
    int sum;
    while(true){
        sum = 0;
        //确保两个数不相等
        if(a!=b){
            for(int i=0;i<=x;i++){
                for(int j=0;j<=y;j++){
                    //如果大于就直接抛出
                    if((i*a+j*b)>k) {
                        break;
                    }
                    //相等则根据他的个数  去杨辉三角里面取对应的数（组合数）
                    if((i*a+j*b)==k){
                        //这里x是首  最多为3  随你组合  i是1  代表1个  就是1个数组合  对应的二维杨辉三角的列下标
                        System.out.println(c[x][i]);
                        System.out.println(c[y][j]);
                        //x组合*y组合
                        sum+=c[x][i]*c[y][j];
                    }
                }
            }
        }
        //相等直接结束
        if(a==b){
            System.out.println("a can't equals b!" );
            break;
        }
        //输出结果
        System.out.println(sum%1000000007);
        break;
    }
}

    public static int count(int day,int choolate){
        int sum=0;
        for(int i=day;i>0;i--){
            sum+=choolate;
            choolate=(choolate+1)/2;
        }
        return sum;
    }

}
