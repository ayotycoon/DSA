

# 7 Reverse Integer https://leetcode.com/problems/reverse-integer

def bruteForce(x):
    times = -1 if x < 0 else 1
    xstr = str(x) + ""
    sb = ""
    i = len(xstr) - 1
    while (i >= 0):
        if (xstr[i] == '-'):
            i -= 1
            continue
        sb += xstr[i]
        i -= 1
    revInt = int(sb)
    if (revInt > 2147483647 or revInt < -2147483647):
        return 0
    return int((revInt * times))


def optimized1(x):
    isNeg = True if x < 0 else False
    res = 0
    x = abs(x)
    while (x > 0):
        if res > 2147483647:
            return 0
        res = res * 10 + x % 10
        x = int(x/10)
        if (res > 2147483647 or res < -2147483647):
            return 0
    res = -1 * res if isNeg else res
    return res


x = 214748364
bruteForceSolution = bruteForce(x)
optimized1Solution = optimized1(x)

print(bruteForceSolution)
print(optimized1Solution)
