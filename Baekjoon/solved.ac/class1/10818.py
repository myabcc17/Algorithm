import sys

lines = sys.stdin.readlines()

max_value = 0
idx = 1
max_idx = 1
for n in lines:
    num = int(n)
    if max_value < num:
        max_value = num
        max_idx = idx
    idx += 1

print(max_value)
print(max_idx)
