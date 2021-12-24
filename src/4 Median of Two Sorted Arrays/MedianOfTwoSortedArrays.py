
    
# 4 Median of Two Sorted Arrays https://leetcode.com/problems/median-of-two-sorted-arrays

import sys
def  getIndex( num,  i) :
    #  max value because we want to ignore it
    if (i >= len(num) or i < 0) :
        return  sys.maxsize
    return  num[i]
    
def  optimized(nums1,  nums2) :
    # Time O(log N)
    #Space O(1)
    a = 0
    b = 0
    tot = len(nums1) + len(nums2)
    mid = int(tot / 2)
    i = 0
    j = 0
    track = -1
    while (i < len(nums1) or j < len(nums2)) :
        intI = getIndex(nums1, i)
        intJ = getIndex(nums2, j)
        track += 1
        if (intI < intJ) :
            if (track == mid - 1) :
                a = getIndex(nums1, i)
            elif (track == mid) :
                b = getIndex(nums1, i)
            i += 1
        else :
            if (track == mid - 1) :
                a = getIndex(nums2, j)
            elif (track == mid) :
                b = getIndex(nums2, j)
            j += 1
        if (tot % 2 == 0 and track == mid) :
            return  (float((a + b)) / 2)
        #  if even
        if (tot % 2 != 0 and track == mid) :
            return  b
    return  0



num1 = [1]
num2 = [2,4]

optimizedSolution = optimized(num1, num2)
print(optimizedSolution)
