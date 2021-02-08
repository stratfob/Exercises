import time

# Naive
def longestPalindrome(s):
   
    def isPalindrome(s):
        for i in range(len(s)//2):
            if s[i] != s[len(s)-i-1]:
                return False
        return True
   
    longestPalindrome = ""
    if(len(s)==1):
        return s
    for i in range(len(s)):
        for j in range(i,len(s)+1):
            if isPalindrome(s[i:j]):
                if len(s[i:j]) > len(longestPalindrome):
                    longestPalindrome = s[i:j]
    return longestPalindrome

# Improved
def longestPalindrome2(s):
    longest = ""
    for i in range(len(s)):
        leftIndex = i
        rightIndex = i
        while leftIndex >= 0 and rightIndex <len(s) and s[leftIndex] == s[rightIndex]:
            if len(s[leftIndex:rightIndex+1]) > len(longest):
                longest = s[leftIndex:rightIndex+1]
            leftIndex -=1
            rightIndex +=1
           
        leftIndex = i
        rightIndex = i+1
        while leftIndex >= 0 and rightIndex <len(s) and s[leftIndex] == s[rightIndex]:
            if len(s[leftIndex:rightIndex+1]) > len(longest):
                longest = s[leftIndex:rightIndex+1]
            leftIndex -=1
            rightIndex +=1
    return longest
       
start_time = time.time()
print(longestPalindrome("babad"))
print(longestPalindrome("cbbd"))
print(longestPalindrome("a"))
print(longestPalindrome("ac"))
print(longestPalindrome("babaxtatx"))
print("--- %s seconds ---" % (time.time() - start_time))

start_time = time.time()
print(longestPalindrome2("babad"))
print(longestPalindrome2("cbbd"))
print(longestPalindrome2("a"))
print(longestPalindrome2("ac"))
print(longestPalindrome2("babaxtatx"))
print("--- %s seconds ---" % (time.time() - start_time))
