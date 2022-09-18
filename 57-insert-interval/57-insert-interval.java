class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // intervals가 비어있는 경우
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        
        
        // 주입하는 끝점이 맨 첫번째 값보다 작을때 : 맨앞에 끼워 넣어야 한다.
        if (newEnd < intervals[0][0]) {
            int[][] answer = new int[intervals.length+1][2];
            answer[0][0] = newStart;
            answer[0][1] = newEnd;
            
            for (int i = 0 ; i < intervals.length; i++) {
                System.arraycopy(intervals[i], 0, answer[i + 1], 0, 2);
            }
            return answer;
        }        
        
        // 주입하는 시작점이 맨 마지막 값보다 클때 : 맨 뒤에 끼워 넣어야 한다.
        if (newStart > intervals[intervals.length -1][1]) {
            int[][] answer = new int[intervals.length+1][2];
            answer[intervals.length][0] = newStart;
            answer[intervals.length][1] = newEnd;
            
            for (int i = 0; i < intervals.length; i++) {
                System.arraycopy(intervals[i], 0, answer[i], 0, 2);
            }
            return answer;
        }
        
        List<int[]> answer = new ArrayList();
        
        int start = 0;
        int end = 0;
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {

            // 주입하는 시작이 현재 시작보다 작을때 : 시작점 갱신해야하므로 주입되는 시작을 start에 저장, 해당 idx부터 탐색하기 위해 idx 저장 ; 탈출
            if (newStart < intervals[i][0]) {
                start = newStart;
                idx = i;
                break;
            }

            // 주입하는 시작이 현재 끝보다 작을때 : 시작점을 유지해야하므로 현재 시작점을 start에 저장, idx 저장 ; 탈출
            else if (newStart <= intervals[i][1]) {
                start = intervals[i][0];
                idx = i;
                break;
            }

            // 현재 시작,끝 모두 변동 없을때 리스트에 넣기
            else {
                answer.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            
        }

        // 여기서 탐색 끝나는 경우 고려해보기 -> 큰 경우만 자르기 떄문에, 큰 경우를 못찾으면 문제가 생긴다.

        for (int i = idx; i < intervals.length; i++) {
            
            /*
            시작점과 비교
            {1,6} -> 5,6비교 -> 넘어감 -> 6,7비교 -> 6이 더 작으므로 현재 끝값 6 갱신

            {1,7} -> 4와 5비교 -> 넘어감 -> 7,7비교 -> 같음 -> end 는 현재 인덱스의 끝값
            ==> 현재 값보다 주입끝이 같거나 작을떄 end를 현재 인덱스 값으로 갱신

            {1,8} -> 반복 -> 8,7비교 -> 넘어감
            
            끝점과 비교
            {2,5} {7,10}
            {1,4} -> 1과 2를 비교해서 1을 start에 저장, idx가 0인 상태로 여기로 넘어옴
            0부터 탐색해서 4,5와 비교해서 else if에 걸림 -> answer에 2,5그대로 주입.
            */
            
            // 주입하는 끝보다 시작점이 더 클때 -> 시작점 전까지 여태 걸린 인터벌이 모두 통합된다.
            if (newEnd < intervals[i][0]) {
                end = newEnd;
                idx = i;
                break;
            }

            // 주입하는 끝보다 끝점이 더 크거나 같을때 -> 해당 끝점까지 여태 걸린 인터벌이 모두 통합된다.
            else if (newEnd <= intervals[i][1]) {
                end = intervals[i][1];
                idx = i + 1;
                break;
            }
            
            
            if (i == intervals.length -1) {
                end = newEnd;
                idx = i + 1;
            }
        }

        answer.add(new int[]{start,end});

        for (int i = idx; i < intervals.length; i++) {
            answer.add(new int[]{intervals[i][0], intervals[i][1]});
        }


        return answer.toArray(new int[0][0]);
    }
}
/*
합치는 경우애 대해 어떻게 분류할 것인가?
2개의 interval이 합쳐지는 경우에 개수가 변하기때문에, 또 다른 조치가 필요하다.


{1,3} {5,7} {9,11}
========
1) 새 시작점보다 주어진 시작점이 더 클때 -> 앞자리 4 저장
{4,6} : 바로 주어진 끝점이 더 클때 {5,7} -> {4,7}
{4,7} : 바로 주어진 끝점과 같을때 {5,7} -> {4,7}
{4,8} : 바로 주어진 끝점보다 크고, 다음 시작점보다 작을때 {5,7} -> {4,8}

1-2) 바로 주어진 끝점보다 크고, 다음 시작점보다 같거나 클때
{4,9} : {5,7} {9,11} -> {4,11}
{4,11} : {5,7} {9,11} -> {4,11}
{4,13} : {5,7} {9,11} -> {4,13}

2) 새 시작점보다 주어진 끝점이 더 클때 -> 앞자리를 갱신하지 않은채로 다시 탐색 -> 앞자리 5로 저장
{6,7} : 주입하는 끝보다 끝점이 크거나 같을때
{6,8} : 주입하는 끝보다 시작점이 더 클때 {5,8}
{6,9} {9,11} : {5,11}

*/