class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            double p = c[0], t = c[1];
            double delta = ((p + 1) / (t + 1)) - (p / t);
            pq.add(new double[]{delta, p, t});
        }

        while (extraStudents-- > 0) {
            double[] arr = pq.poll();
            double p = arr[1] + 1;
            double t = arr[2] + 1;
            double delta = ((p + 1) / (t + 1)) - (p / t);
            pq.add(new double[]{delta, p, t});
        }

        double sum = 0;
        while (!pq.isEmpty()) {
            double[] arr = pq.poll();
            sum += arr[1] / arr[2];
        }

        return sum / classes.length;
    }
}
