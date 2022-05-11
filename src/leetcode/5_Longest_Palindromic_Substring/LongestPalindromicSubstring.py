

# 5 Longest Palindromic Substring https://leetcode.com/problems/longest-palindromic-substring

def isPalindrome(s,  i,  j):
    while (i <= j):
        if (s[i] != s[j]):
            return False
        i += 1
        j -= 1
    return True


def bruteForce(s):
    # Time O(N^3)
    # Space O(1)
    start = 0
    end = 1
    i = 0
    while (i < len(s)):
        j = i + 1
        while (j < len(s)):
            if (isPalindrome(s, i, j) and ((j - i) > (end - start))):
                start = i
                end = j
            j += 1
        i += 1
    return s[start:end + 1]


def expand(s,  start,  end):
    if (end >= len(s) or s[start] != s[end]):
        return [0, 0, 1]
    a = start
    b = end
    while (start >= 0 and end < len(s) and s[start] == s[end]):
        a = start
        b = end
        start -= 1
        end += 1
    return [a, b, b - a + 1]


def optimized1(s):
    # Time O(N^2)
    #  Space O(1)
    #  expand from the center
    max = [0, 0, 1]
    i = 0
    while (i < len(s)):
        possibility1 = expand(s, i, i + 1)
        possibility2 = expand(s, i, i)
        if (possibility1[2] > max[2]):
            max = possibility1
        if (possibility2[2] > max[2]):
            max = possibility2
        i += 1
    return s[max[0]:max[1] + 1]


s = "racecar"
bruteForceSolution = bruteForce(s)
optimized1Solution = optimized1(s)

print(bruteForceSolution)
print(optimized1Solution)
