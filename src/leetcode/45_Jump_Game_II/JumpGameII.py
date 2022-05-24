
    
# 45 Jump Game II https://leetcode.com/problems/jump-game-ii

def bruteForce(nums):
   #Time O(1)
   #Space O(1)

    return ""

def optimized1(nums):

    #Time O(N^2)
    #Space O(1)

     ans = 0;
     l = 0;
     r = 0;

     while(r < len(nums)-1):
        farthest = 0
        for i in range(l,r+1):
            farthest = max(farthest, i+nums[i])

        l = r+1
        r = farthest
        ans=ans+1



     return ans


nums = [2, 7, 11, 15]


bruteForceSolution = bruteForce(nums)
optimized1Solution = optimized1(nums)

print(bruteForceSolution)
print(optimized1Solution)