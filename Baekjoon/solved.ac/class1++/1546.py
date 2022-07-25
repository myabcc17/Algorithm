N = int(input())

score = list(map(int, input().split()))

total = (sum(score) / max(score) * 100) / N

print(total)