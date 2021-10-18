class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map={}#to store element and its index
        list=[]
        
        for i in range(len(nums)):
            diff=target-nums[i]
            if diff in map:#if nums[i]+nums[j]=target,then add its indexes to the list
                list.append(map.get(diff))
                list.append(i)
            map[nums[i]]=i
        
        return list
                
        
