import java.util.*;

class Solution {
    
    private class Assignment {
        String name;
        int startTime, playtime;
        
        public Assignment(String name, String start, int playtime) {
            this.name = name;
            this.startTime = convertToMinutes(start);
            this.playtime = playtime;
        }
        
        private int convertToMinutes(String time) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            
            return hour * 60 + minute;
        }
        
    }
    
    public String[] solution(String[][] plans) {
        int n = plans.length;
        Assignment[] tasks = new Assignment[n];
        
        for (int i = 0; i < n; i++) {
            tasks[i] = new Assignment(plans[i][0], plans[i][1], Integer.parseInt(plans[i][2]));
        }
        
        Arrays.sort(tasks, Comparator.comparingInt(a -> a.startTime));
        
        List<String> completedTasks = new ArrayList<>();
        Deque<Assignment> pausedTasks = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            Assignment currentTask = tasks[i];
            
            int nextStartTime = (i < n - 1) ? tasks[i + 1].startTime : Integer.MAX_VALUE;
            
            if (currentTask.startTime + currentTask.playtime <= nextStartTime) {
                completedTasks.add(currentTask.name);
                
                int remainingTime = nextStartTime - (currentTask.startTime + currentTask.playtime);
                while (!pausedTasks.isEmpty() && remainingTime > 0) {
                    Assignment pausedTask = pausedTasks.peek();
                    
                    if (pausedTask.playtime <= remainingTime) {
                        remainingTime -= pausedTask.playtime;
                        completedTasks.add(pausedTasks.pop().name);
                    } else {
                        pausedTask.playtime -= remainingTime;
                        remainingTime = 0;
                    }
                }
            } else {
                currentTask.playtime -= (nextStartTime - currentTask.startTime);
                pausedTasks.push(currentTask);
            }
        }
        
        while (!pausedTasks.isEmpty()) {
            completedTasks.add(pausedTasks.pop().name);
        }
        
        return completedTasks.toArray(new String[0]);
    }
}