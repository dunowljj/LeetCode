class Solution {
    
    int nowInterval = 0;
    int[] remain;
    int[] enableTiming;
    public int leastInterval(char[] tasks, int leastStep) {       
        enableTiming = new int[26];
        remain = new int[26];
        for (char task : tasks) {
            remain[task - 'A']++;
        }

        // enableTiming에서 0값을 사용해야함.
        // 사용하지 않는 값은 음수처리, 후에 분기로 무시
        for (int i = 0; i < 26; i++) {
            if (remain[i] == 0) {
                enableTiming[i] = -1;
            }
        }
        
        for (int i = 0; i < tasks.length; i++) {
            List<Integer> enableTasks = findEnableTasks();
            int targetTask = findMaxTask(enableTasks);
            
            remain[targetTask]--;
            enableTiming[targetTask] = nowInterval + leastStep + 1;
            nowInterval++;
        }

        // tasks.length 만큼 정확히 순회하면서,
        // 만약 진행가능 task가 없다면, idle만큼 점프하면서 nowInterval을 갱신한다.
        // 그렇기에 nowInterval이 정답.
        return nowInterval;
    }

     private List<Integer> findEnableTasks() {
        List<Integer> enableTasks = new ArrayList<>();

        for (int i = 0; i < enableTiming.length; i++) {
            if (remain[i] > 0 && 0 <= enableTiming[i] && enableTiming[i] <= nowInterval) {
                enableTasks.add(i);
            }
        }

        // 가능한 작업이 없다면, 가장 가까운 작업까지 거리를 구해 skip, idle처리
        if (enableTasks.isEmpty()) {
            int nearestInterval = Integer.MAX_VALUE;
            for (int i = 0; i < enableTiming.length; i++) {
                if (remain[i] > 0 && nowInterval < enableTiming[i]) {
                    nearestInterval = Math.min(nearestInterval, enableTiming[i]);
                }
            }

            int skip = nearestInterval - nowInterval; // idle
            nowInterval += skip;

            // 다시 가능한 작업들 찾기
            for (int i = 0; i < enableTiming.length; i++) {
                if (remain[i] > 0 && 0 <= enableTiming[i] && enableTiming[i] <= nowInterval) {
                    enableTasks.add(i);
                }
            }
        }        

        return enableTasks;
    }

    // 안전하게 작업 한 개씩 처리
    private int findMaxTask(List<Integer> enableTasks) {
        int max = 0;
        for (int i = 0; i < enableTasks.size(); i++) {
            int task = enableTasks.get(i);
            max = Math.max(max, remain[task]);
        }

        for (int i = 0; i < enableTasks.size(); i++) {
            int task = enableTasks.get(i);
            if (remain[task] == max) return task;
        }
        
        throw new IllegalArgumentException("need input which include enabletask");
    }
}
/*
same label gap -> at least n
1 <= len <= 10^4
uppercase letter A-Z

순차로 넣었다가, 번갈아 낼 것이 부족하면?
A,A,B,B,C,C,C,C  N=2
C-A-B-C-A-B-C-idle-C 

- 가능한 알파벳 중, 가장 많은 수의 알파벳을 우선 사용
- interval에 대해 가능한지, 가장 많은 알파벳이 무엇인지 체크할 수 있어야 함.
    - interval은 이전 위치 저장하기.
    - 알파벳 수는 미리 세놓고, 전체 순회하기. 26개뿐임
*/