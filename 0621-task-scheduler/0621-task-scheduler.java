class Solution {
    public int leastInterval(char[] tasks, int n) {
        // count
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxValue = 0; // 최빈값
        int maxValueCount = 0; // 최반값의 개수
        for (int i = 0; i < count.length; i++) {
            
            if (maxValue < count[i]) {
                maxValue = count[i];
                maxValueCount = 1;
            } else if (maxValue == count[i]) {
                maxValueCount++;
            }
        }
    
        int emptySize = n - (maxValueCount - 1);

        // 최빈값들로 frame을 만들었기 때문에, emptyStep당 하나씩 작업을 넣을때, 꽉차거나 초과할일이 없다.
        // -> 즉, remain한 task의 label이 모두 같더라도, empty공간에 모두 분배가 가능하다.
        int needFilling = emptySize * (maxValue - 1);
        int remain = tasks.length - maxValue * maxValueCount;


        // 최빈값들이 많아서, emptySize가 음수 혹은 0이라면, idle이 발생하지 않는다.
        // 또한, remain이 needFilling 보다 더 많아도, idle이 발생하지 않는다.
        int idleCount = Math.max(0, needFilling - remain);
        return tasks.length + idleCount;
    }
}

/**
최빈값보다 다른 값들이 클 수 없음을 인지해야 함.
 */