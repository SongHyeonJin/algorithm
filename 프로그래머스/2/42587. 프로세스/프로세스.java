import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        List<PrintJob> printer = new ArrayList<>();
        for(int i=0; i<priorities.length; i++){
            printer.add(new PrintJob(i, priorities[i]));
        }
        int turn = 0;
        while(!printer.isEmpty()){
            PrintJob job = printer.remove(0);
            if(printer.stream().anyMatch(otherJob -> job.priority < otherJob.priority)){
                printer.add(job);
            }
            else{
                turn++;
                if(location == job.location) break;
            }
        }
        return turn;
    }
    class PrintJob{
        int priority;
        int location;
        
        public PrintJob(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
    }
}
