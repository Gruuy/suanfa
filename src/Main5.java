import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 16:32 2019/10/11
 */
@SuppressWarnings("all")
public class Main5 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,m;
        n=scanner.nextInt();
        m=scanner.nextInt();
        List<Computer> computerList=new ArrayList<>(n);
        List<Task> taskList=new ArrayList<>(m);
        for(int i=0;i<n;i++){
            Computer c=new Computer();
            c.time=scanner.nextInt();
            c.level=scanner.nextInt();
            computerList.add(c);
        }
        for(int i=0;i<m;i++){
            Task c=new Task();
            c.time=scanner.nextInt();
            c.level=scanner.nextInt();
            taskList.add(c);
        }
        //先排序
        computerList=computerList.stream().sorted(Comparator.comparing(Main5.Computer::getLevel,Collections.reverseOrder()).thenComparing(Main5.Computer::getTime,Collections.reverseOrder())).collect(Collectors.toList());
        taskList=taskList.stream().sorted(Comparator.comparing(Main5.Task::getLevel,Collections.reverseOrder()).thenComparing(Main5.Task::getTime,Collections.reverseOrder())).collect(Collectors.toList());
        //为机器选择对它来说效率最高的任务
        int taskcount=0;
        int price=0;
        for(int i=0;i<n;i++){
            Computer computer = computerList.get(i);
            for(int j=0;j<m;j++){
                Task task = taskList.get(j);
                //先判断是否够level做任务
                if(computer.level>=task.level&&task.level>=0){
                    //再判断时间
                    if(computer.time>=task.time&&computer.time>=0){
                        //符合就加  因为是倒序  所以必定是最大收益
                        taskcount++;
                        price+=200 * task.time + 3 * task.level;
                        task.time=-1;
                        task.level=-1;
                        break;
                    }
                }
            }
        }
        System.out.println("taskcount:"+taskcount+"  ,monry:"+price );
        scanner.close();
    }

    static class Computer{
        public int time;
        public int level;
        public Computer(){}

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    static class Task{
        public int time;
        public int level;
        public Task(){}
        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
