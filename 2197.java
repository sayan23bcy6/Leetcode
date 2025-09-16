class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            stack.add(num);
            while (stack.size() > 1) {
                int a = stack.get(stack.size() - 1);
                int b = stack.get(stack.size() - 2);

                int g = gcd(a, b);
                if (g == 1) break;

                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                long lcm = (1L * a * b) / g; 
                stack.add((int) lcm);
            }
        }

        return stack;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
