

# 1 Two Sum https://leetcode.com/problems/two-sum

def bruteForce(nums, target):
    # Time O(N^2)
    # Space O(1)
    for i in range(len(nums)):
        for j in range(len(nums)):
            if(i == j):
                continue
            if(nums[i] + nums[j] == target):
                return [i, j]

    return []


def optimized1(nums, target):
    # Time O(N)
    # Space O(N)
    dict = {}
    for i in range(len(nums)):
        diff = target - nums[i]
        if diff in dict:
            return [dict[diff], i]
        dict[nums[i]] = i
    return []


nums = [2, 7, 11, 15]
target = 9

bruteForceSolution = bruteForce(nums, target)
optimized1Solution = optimized1(nums, target)

print(bruteForceSolution)
print(optimized1Solution)
