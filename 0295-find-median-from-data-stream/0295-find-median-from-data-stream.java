import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;

    public MedianFinder() {
        rightMin = new PriorityQueue<>();
        leftMax = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        leftMax.offer(num);
        rightMin.offer(leftMax.poll());

        if (leftMax.size() < rightMin.size()) {
            leftMax.offer(rightMin.poll());
        }
    }
    
    public double findMedian() {
        if (rightMin.size() == leftMax.size()) {
            return ((double) leftMax.peek() + (double) rightMin.peek()) / 2.0;
        }

        return (double) leftMax.peek();        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();


 1. 두개의 pq O(NlogN)
 2. 숫자 범위 적다면 counting -> 20만
 */