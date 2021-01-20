# Naive
def twoSum(nums, target):
    for i in range(len(nums)):
        for j in range(len(nums)):
            if i == j:
                continue
            else:
                if nums[i] + nums[j] == target:
                    return [i,j]
    return None

# refined - one pass
def twoSum2(nums, target):
    dictionary = {}
    for i in range(len(nums)):
        # Use the difference of target and number as key in dict
        difference = target - nums[i]
        if nums[i] in dictionary:
            return [dictionary[nums[i]], i]
        dictionary[difference] = i
    return None        

if __name__ == "__main__":
    print(twoSum([2,7,11,15], 9))
    print(twoSum([3,2,4], 6))
    print(twoSum([3,3], 6))

    print(twoSum2([2,7,11,15], 9))
    print(twoSum2([3,2,4], 6))
    print(twoSum2([3,3], 6))