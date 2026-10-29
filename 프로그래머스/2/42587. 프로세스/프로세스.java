import java.util.*;

class Solution {
    private static class Process {
        int id;
        int priority;
        
        public Process(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Process> processQueue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            processQueue.offer(new Process(i, priorities[i]));
        }
        
        int executionSequence = 0;
        while (!processQueue.isEmpty()) {
            Process currentProcess = processQueue.poll();
            
            boolean hasHigherPriority = false;        
            for (Process otherProcess : processQueue) {
                if (otherProcess.priority > currentProcess.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if (hasHigherPriority) {
                processQueue.add(currentProcess);
            } else {
                executionSequence++;
                if (currentProcess.id == location) {
                    return executionSequence;
                }
            }
            
        }
        
        return executionSequence;
    }
}