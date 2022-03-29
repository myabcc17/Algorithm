nums = list(map(int, input().split()))

answer = "ascending" if nums[0] < nums[1] else "descending"

for i in range(2, len(nums) - 1):
    if (answer == "ascending" and nums[i] > nums[i + 1]) or (answer == "descending" and nums[i] < nums[i + 1]):
        answer = "mixed"
        break

print(answer)
