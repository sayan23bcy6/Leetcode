class Solution {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < EPSILON;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Double> nextRoundList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        nextRoundList.add(list.get(k));
                    }
                }

                double a = list.get(i);
                double b = list.get(j);

                List<Double> results = List.of(
                    a + b,
                    a - b,
                    b - a,
                    a * b
                );

                for (double res : results) {
                    nextRoundList.add(res);
                    if (solve(nextRoundList)) {
                        return true;
                    }
                    nextRoundList.remove(nextRoundList.size() - 1);
                }

                if (Math.abs(b) > EPSILON) {
                    nextRoundList.add(a / b);
                    if (solve(nextRoundList)) return true;
                    nextRoundList.remove(nextRoundList.size() - 1);
                }
                
                if (Math.abs(a) > EPSILON) {
                    nextRoundList.add(b / a);
                    if (solve(nextRoundList)) return true;
                    nextRoundList.remove(nextRoundList.size() - 1);
                }
            }
        }
        
        return false;
    }
}