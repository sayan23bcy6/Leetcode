int reverse(int x) {
    long long reversed_x = 0;

    while (x != 0) {
        int digit = x % 10;
        reversed_x = reversed_x * 10 + digit;
        
        if (reversed_x > INT_MAX || reversed_x < INT_MIN) {
            return 0;
        }

        x /= 10;
    }

    return (int)reversed_x;
}
