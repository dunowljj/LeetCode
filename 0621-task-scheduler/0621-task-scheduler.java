class Solution {
    public int leastInterval(char[] tasks, int n) {
        // count
        int[] count = new int[tasks.length];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxValue = 0; // 최빈값
        int maxValueCount = 0; // 최반값의 수
        for (int i = 0; i < count.length; i++) {
            
            if (maxValue < count[i]) {
                maxValue = count[i];
                maxValueCount = 1;
            } else if (maxValue == count[i]) {
                maxValueCount++;
            }
        }
       
        int emptySize = n - (maxValueCount - 1);

        // 최빈값들이 많아서, emptySize가 음수 혹은 0이라면, idle이 발생하지 않는다.
        if (emptySize <= 0) return tasks.length;

        // 최빈값들로 frame을 만들었기 때문에, emptyStep당 하나씩 작업을 넣을때, 꽉차거나 초과할일이 없다.
        // -> 즉, remain한 task의 label이 모두 같더라도, empty공간에 모두 분배가 가능하다.
        int needFilling = emptySize * (maxValue - 1);
        int remain = tasks.length - maxValue * maxValueCount;

        int idleCount = needFilling - remain;
        return tasks.length + idleCount;
    }
}

/**

A B * A B * A B * A
[10,9,9]





 */