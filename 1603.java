class ParkingSystem {
    int check[]=new int[3];
    int arr[]=new int[3];
    public ParkingSystem(int big, int medium, int small) {
        check[0]=big;
        check[1]=medium;
        check[2]=small;
    }
    
    public boolean addCar(int carType) {
        return ++arr[carType-1]<=check[carType-1];
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */