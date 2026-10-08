import java.util.*;

class Solution {
    static class Assignment {
        String name;
        int start;
        int playtime;

        public Assignment(String name, String start, int playtime) {
            this.name = name;
            this.start = convertToMinutes(start);
            this.playtime = playtime;
        }

        private int convertToMinutes(String time) {
            String[] parts = time.split(":");
            return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
    }

    public String[] solution(String[][] plans) {
        int n = plans.length;
        Assignment[] tasks = new Assignment[n];
        
        for (int i = 0; i < n; i++) {
            tasks[i] = new Assignment(plans[i][0], plans[i][1], Integer.parseInt(plans[i][2]));
        }
        
        Arrays.sort(tasks, (a, b) -> Integer.compare(a.start, b.start));
        
        List<String> completed = new ArrayList<>();
        Stack<Assignment> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            Assignment current = tasks[i];
            
            int nextStartTime = (i < n - 1) ? tasks[i + 1].start : Integer.MAX_VALUE;
            
            int timePassed = current.playtime;
            
            if (current.start + timePassed <= nextStartTime) {
                completed.add(current.name);
                int timeLeft = nextStartTime - (current.start + timePassed);
                
                while (!stack.isEmpty() && timeLeft > 0) {
                    Assignment paused = stack.peek();
                    if (paused.playtime <= timeLeft) {
                        timeLeft -= paused.playtime;
                        completed.add(stack.pop().name);
                    } else {
                        paused.playtime -= timeLeft;
                        timeLeft = 0;
                    }
                }
            } else {
                current.playtime -= (nextStartTime - current.start);
                stack.push(current);
            }
        }
        
        while (!stack.isEmpty()) {
            completed.add(stack.pop().name);
        }
        
        return completed.toArray(new String[0]);
    }
}