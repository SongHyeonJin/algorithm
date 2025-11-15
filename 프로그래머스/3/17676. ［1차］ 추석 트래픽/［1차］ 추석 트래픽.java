import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int solution(String[] lines) {
        List<Job> jobs = new ArrayList<>();

        for (String line : lines) {
            String[] splitLine = line.split(" ");
            double[] endTimeArr = Arrays.stream(splitLine[1].split(":"))
                .mapToDouble(Double::parseDouble)
                .toArray();
            int endTime = 0;
            for (int i = 0; i < 3; i++) {
                endTime += (int) (endTimeArr[i] * Math.pow(60, 2 - i) * 1000);
            }
            int jobTime = (int) (
                Double.parseDouble(splitLine[2].substring(0, splitLine[2].length() - 1)) * 1000);
            int startTime = endTime - jobTime + 1;
            jobs.add(new Job(startTime, endTime));
        }

        int max = 0;
        for (Job job : jobs) {
            int num1 = 0;
            int num2 = 0;
            for (Job compJob : jobs) {
                if (check(job.getStartTime(), compJob)) {
                    num1++;
                }
                if (check(job.getEndTime(), compJob)) {
                    num2++;
                }
            }
            if (Math.max(num1, num2) > max) {
                max = Math.max(num1, num2);
            }
        }

        return max;
    }

    public boolean check(int time, Job job) {
        int startTime = job.getStartTime();
        int endTime = job.getEndTime();
        if (startTime >= time && startTime <= time + 999) {
            return true;
        } else if (endTime >= time && endTime <= time + 999) {
            return true;
        } else if (startTime < time && endTime > time + 999) {
            return true;
        }

        return false;
    }
}

class Job {

    private final int startTime;
    private final int endTime;

    public Job(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}