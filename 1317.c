bool hasZero(int num) {
    while (num > 0) {
        if (num % 10 == 0) return true;
        num /= 10;
    }
    return false;
}

int* getNoZeroIntegers(int n, int* returnSize) {
    int* result = (int*)malloc(2 * sizeof(int));
    for (int i = 1; i <= n / 2; i++) {
        int b = n - i;
        if (hasZero(i) || hasZero(b)) continue;
        result[0] = i;
        result[1] = b;
        *returnSize = 2;
        return result;
    }
    *returnSize = 0;
    return NULL;
}
