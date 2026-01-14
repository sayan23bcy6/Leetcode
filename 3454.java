class Solution {

    static class Event {
        double y, x1, x2;
        int type;
        Event(double y, double x1, double x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegTree {
        int n;
        double[] xs;
        double[] len;
        int[] cnt;

        SegTree(double[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            len = new double[4 * n];
            cnt = new int[4 * n];
        }

        void update(int idx, int l, int r, int ql, int qr, int v) {
            if (ql >= r || qr <= l) return;
            if (ql <= l && r <= qr) {
                cnt[idx] += v;
            } else {
                int m = (l + r) >>> 1;
                update(idx << 1, l, m, ql, qr, v);
                update(idx << 1 | 1, m, r, ql, qr, v);
            }
            if (cnt[idx] > 0) len[idx] = xs[r] - xs[l];
            else if (l + 1 == r) len[idx] = 0;
            else len[idx] = len[idx << 1] + len[idx << 1 | 1];
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        Event[] events = new Event[2 * n];
        double[] xs = new double[2 * n];

        for (int i = 0; i < n; i++) {
            int x = squares[i][0];
            int y = squares[i][1];
            int l = squares[i][2];
            events[2 * i] = new Event(y, x, x + l, 1);
            events[2 * i + 1] = new Event(y + l, x, x + l, -1);
            xs[2 * i] = x;
            xs[2 * i + 1] = x + l;
        }

        java.util.Arrays.sort(xs);
        int m = 1;
        for (int i = 1; i < xs.length; i++)
            if (xs[i] != xs[i - 1]) xs[m++] = xs[i];

        double[] xArr = new double[m];
        for (int i = 0; i < m; i++) xArr[i] = xs[i];

        java.util.Arrays.sort(events, (a, b) -> Double.compare(a.y, b.y));

        SegTree st = new SegTree(xArr);

        double total = 0;
        double prevY = events[0].y;

        for (int i = 0; i < events.length; i++) {
            double y = events[i].y;
            total += st.len[1] * (y - prevY);

            int l = java.util.Arrays.binarySearch(xArr, events[i].x1);
            int r = java.util.Arrays.binarySearch(xArr, events[i].x2);
            st.update(1, 0, st.n, l, r, events[i].type);

            prevY = y;
        }

        double half = total / 2;
        double acc = 0;
        prevY = events[0].y;

        st = new SegTree(xArr);

        for (int i = 0; i < events.length; i++) {
            double y = events[i].y;
            double area = st.len[1] * (y - prevY);

            if (acc + area >= half) {
                return prevY + (half - acc) / st.len[1];
            }

            acc += area;

            int l = java.util.Arrays.binarySearch(xArr, events[i].x1);
            int r = java.util.Arrays.binarySearch(xArr, events[i].x2);
            st.update(1, 0, st.n, l, r, events[i].type);

            prevY = y;
        }

        return prevY;
    }
}
