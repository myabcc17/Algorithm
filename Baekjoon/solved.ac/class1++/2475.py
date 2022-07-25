nums = list(map(int, input().split()))

total = 0

for n in nums:
    total += n * n

print(total % 10)
