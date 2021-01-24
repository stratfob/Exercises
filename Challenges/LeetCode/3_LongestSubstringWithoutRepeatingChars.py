# Naive
def lengthOfLongestSubstring(s):
    longestSubstring = ""
    currentSubstring = ""

    for i in range(len(s)):
        currentSubstring = ""
        for j in s[i:]:
            if j in currentSubstring:
                currentSubstring = ""
                break
            else:
                currentSubstring += j
                if len(currentSubstring) > len(longestSubstring):
                    longestSubstring = currentSubstring
    return (longestSubstring, len(longestSubstring))

# One pass
def lengthOfLongestSubstring2(s):
    prevPosition = {}
    index = 0
    beginningOfSubstring = 0
    longestSubstring = 0
    for l in s:
        if l in prevPosition:
            beginningOfSubstring = max(beginningOfSubstring, prevPosition[l] + 1)

        prevPosition[l] = index
        index += 1
        longestSubstring = max(longestSubstring, index-beginningOfSubstring)
        

    return longestSubstring


print(lengthOfLongestSubstring("abcabcbb"))
print(lengthOfLongestSubstring("bbbbb"))
print(lengthOfLongestSubstring("pwwkew"))
print(lengthOfLongestSubstring(""))
print(lengthOfLongestSubstring("abcdefg"))
print(lengthOfLongestSubstring("abcadefghid"))
print(lengthOfLongestSubstring("abcdefaghid"))
print(lengthOfLongestSubstring("abcdefgahiad"))
print(lengthOfLongestSubstring("abba"))

print(lengthOfLongestSubstring2("abcabcbb"))
print(lengthOfLongestSubstring2("bbbbb"))
print(lengthOfLongestSubstring2("pwwkew"))
print(lengthOfLongestSubstring2(""))
print(lengthOfLongestSubstring2("abcdefg"))
print(lengthOfLongestSubstring2("abcadefghid"))
print(lengthOfLongestSubstring2("abcdefaghid"))
print(lengthOfLongestSubstring2("abcdefgahiad"))
print(lengthOfLongestSubstring2("abba"))