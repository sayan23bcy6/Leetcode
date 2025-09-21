class MovieRentingSystem {
    Map<Integer, TreeSet<int[]>> available;
    Map<String, Integer> priceMap;
    TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        priceMap = new HashMap<>();
        rented = new TreeSet<>((a, b) -> 
            a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]
        );

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "," + movie, price);
            available.computeIfAbsent(movie, k -> new TreeSet<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]
            )).add(new int[]{shop, price});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        int count = 0;
        for (int[] x : available.get(movie)) {
            res.add(x[0]);
            if (++count == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "," + movie);
        available.get(movie).remove(new int[]{shop, price});
        rented.add(new int[]{shop, movie, price});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "," + movie);
        rented.remove(new int[]{shop, movie, price});
        available.get(movie).add(new int[]{shop, price});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] x : rented) {
            res.add(Arrays.asList(x[0], x[1]));
            if (++count == 5) break;
        }
        return res;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */