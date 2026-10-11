def sum_of_special_squares(nums):
    n = len(nums)
    special_elements = [nums[i] for i in range(1, n + 1) if n % i == 0]
    return sum(x**2 for x in special_elements)