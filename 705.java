class MyHashSet {
    private boolean[] arr = new boolean[1000001];

    public void add(int key) {
        if(!arr[key])
        arr[key] = true;
    }

    public void remove(int key) {
        if(arr[key])
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }
}
