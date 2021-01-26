def findMedianSortedArrays(nums1, nums2):
    nums3 = nums1 + nums2
    nums3.sort()
    length = len(nums3)
    if length % 2 == 1:
        return nums3[length//2]
    else:
        return (nums3[(length//2)-1] + nums3[(length//2)]) / 2