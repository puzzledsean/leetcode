# yelp

 # * X = [8, 7, 10, 15, 5, 6, 3] T = 15 -> True 
 # * (8, 7), (7, 5, 3), …, (15)
 # * 
 # * X = [11, 6, 5, 1, 7, 13, 12] T = 15 -> False

def subset_sum(nums, targetSum):
	n = targetSum
	k = len(nums)

	nums.sort()
	nums = [nums[i] for i in range(len(nums)) if nums[i] <= n]

	#if everything is greater than target sum, then clearly not possible
	if len(nums) == 0:
		return False

	memoized = [False] * (n+1)

	memoized[0] = True
	# print(nums)
	for i in range(0, k):
		curr_val = nums[i]

		for j in range(0, curr_val):
			if memoized[j] == True:
				if j+curr_val <= n:
					possible_sum = j + curr_val
					memoized[possible_sum] = True
				if memoized[n] == True:
					return memoized[n]

	return memoized[n]

print(subset_sum([8, 7, 10, 15, 5, 6, 3], 2))
print(subset_sum([8, 7, 10, 15, 5, 6, 3], 25))
print(subset_sum([8, 7, 10, 15, 5, 6, 3], 15))
print(subset_sum([11, 6, 5, 1, 7, 13, 12], 15))