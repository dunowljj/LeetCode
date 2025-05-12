import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (p1,p2) -> Double.compare(getDistance(p1), getDistance(p2)));


        int[][] closest = new int[k][2];
        System.arraycopy(points, 0, closest, 0, k);
        return closest;
    }

    private double getDistance(int[] point) {
        return Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
    }
}