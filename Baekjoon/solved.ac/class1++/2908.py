A, B = map(int, input().split())

A = str(A)[::-1]
B = str(B)[::-1]

print(A if A > B else B)
