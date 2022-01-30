
    
# 9 Palindrome Number https://leetcode.com/problems/palindrome-number

def  bruteForce( y) :
    #            Time O(N)
    #            Space O(N)
    _str = str(y) + ""
    i = 0
    j = len(_str) - 1
    while (i <= j) :
        if (_str[i] != _str[j]) :
            return  False
        i += 1
        j -= 1
    return  True

def  optimized1( y) :
    #            Time O(N)
    #            Space O(1)
    if (y < 0) :
        return  False
    x = y
    rev = 0
    while (x > 0) :
        rev = (rev * 10) + (x - ((int(x / 10)) * 10))
        x = (int(x / 10))
    return  rev == y

 
x = 121
bruteForceSolution = bruteForce(x)
optimized1Solution = optimized1(x)
print(bruteForceSolution)
print(optimized1Solution)