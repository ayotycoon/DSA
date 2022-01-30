

# 6 ZigZag Conversion https://leetcode.com/problems/zigzag-conversion

from typing import List


def bruteForce(s,  numRows):
    # Time O(N +M)
    # Space O(N+M)
    if (numRows == 0):
        return ""
    track: List[List[str]] = []
    i = 0
    while (i < numRows):
        track.append([])
        i += 1
    sign = +1
    trackIndex = 0
    i = 0
    while (i < len(s)):
        track[trackIndex].append(s[i])
        if (trackIndex + sign >= numRows):
            sign = -1
        elif (trackIndex + sign < 0):
            sign = +1
        trackIndex = trackIndex + sign
        if (trackIndex >= numRows or trackIndex < 0):
            trackIndex = 0
        i += 1
    sb = ""
    for t in track:
        for c in t:
            sb += c
    return sb


def optimized1(s,  numRows):
    pass


s = "PAYPALISHIRING"
numRows = 4
bruteForceSolution = bruteForce(s, numRows)
optimized1Solution = optimized1(s, numRows)

print(bruteForceSolution)
print(optimized1Solution)
