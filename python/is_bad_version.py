# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):
class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        low = 0
        high = n-1
        
        while low <= high:
            mid = low + (high - low) / 2
            if isBadVersion(mid) and not isBadVersion(mid-1):
                return mid
            elif isBadVersion(mid):
                high = mid - 1
            elif not isBadVersion(mid):
                low = mid + 1
        return n