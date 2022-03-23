H, M = map(int, input().split())

M = M - 45

if M < 0:
    H = (H - 1) % 24
    M = M % 60

print(H, M)
