package Learn_ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * todo: ForkJoin思想 = MapReduce、
 *      特点：工作窃取
 *      任务队列，采用Dqueue 双端队列
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    private Long top = 10000L; // 阈值

    public ForkJoinDemo(Long start, Long end){
        this.start = start;
        this.end = end;
    }
    public static void main(String[] args) {

    }



    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    @Override
    protected Long compute() {
        if ((end - start) > top){
            // 分支合并算法：ForkJoin
            long middle = (start + end) / 2;
            // 任务拆分
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork(); // 任务压入队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle, end);
            task2.fork(); // 任务压入队列

            // 获取子任务的结果
            return task1.join() + task2.join();
        }else{
            long sum = 0L;
            for (Long i = start; i <= end; i++){
                sum += i;
            }
            return sum;
        }
    }
}
