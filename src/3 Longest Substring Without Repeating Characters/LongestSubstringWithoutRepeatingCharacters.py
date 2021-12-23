
    
# 3 Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters

def bruteForce( input) :
    #Time O(m^2 )
    #Space O(m)
    if (input == None or len(input) == 0) :
        return  0
    max = 1
    i = 0
    while (i < len(input)) :
        mySet = set()
        mySet.add(input[i])
        j = i + 1
        while (j < len(input)) :
            charJ = input[j]
            if (not charJ in mySet) :
                mySet.add(charJ)
            else :
                if (len(mySet) < max) : break
                max = len(mySet)
                break
            if (j == len(input) - 1) :
                if (len(mySet) < max) : break
                max = len(mySet)
                break
            j += 1
        i += 1
    return max

def  bruteForce2( input) :
    #Time O(m^2)
    #Space O(m)
    if (input == None or len(input) == 0) :
        return  0
    j = 1
    maxNum = 1
    myMap =  {}
    myMap[input[0]] = 0
    while (j < len(input)) :
        charJ = input[j]
        if ((charJ in myMap.keys())) :
            maxNum = max(maxNum,len(myMap))
            j = myMap[charJ] + 1
            myMap =  {}
            continue
        else :
            myMap[charJ] = j
        j += 1
    maxNum = max(maxNum,len(myMap))
    return maxNum

def  optimized1( input) :
    #Time O(m)
    #Space O(m)
    if (input == None or len(input) == 0) :
        return  0
    start = 0
    maxNum = 1
    map =  {}
    i = 0
    while (i < len(input)) :
        ch = input[i]
        if ((ch in map.keys())) :
            maxNum = max(maxNum,i - start)
            prevIndex = map[ch]
            start = max(prevIndex + 1,start)
        map[ch] = i
        i += 1
    maxNum = max(maxNum,len(input) - start)
    return  maxNum

input = "qdvilpdf"
bruteForceSolution = bruteForce(input)
bruteForce2Solution = bruteForce2(input)
optimized1Solution = optimized1(input)


print(bruteForceSolution)
print(bruteForce2Solution)
print(optimized1Solution)
