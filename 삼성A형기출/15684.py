N, M, H = map(int, input().split())

ladders = [[0] * (N - 1) for _ in range(H)]
min_answer = 1000

for _ in range(M):
    a, b = map(int, input().split())
    ladders[a - 1][b - 1] = 1
    if b - 2 >= 0:
        ladders[a - 1][b - 2] = -1
    if b < N - 1:
        ladders[a - 1][b] = -1


def is_same_ladder(n):
    start_n = n
    for h in range(H):
        if n - 1 >= 0 and ladders[h][n - 1] == 1:
            n -= 1
        elif n < N - 1 and ladders[h][n] == 1:
            n += 1
    if n == start_n:
        return True
    else:
        return False


def dfs(n, h, count):
    global min_answer

    if min_answer <= count:
        return

    if count == 3 or n == N - 1:
        if count < min_answer:
            for i in range(N):
                if not is_same_ladder(i):
                    return
            min_answer = count
        return



    for i in range(h, H):
        if ladders[i][n] == 0:
            ladders[i][n] = 1
            t1, t2 = 0, 0
            if n - 1 >= 0:
                t1 = ladders[i][n - 1]
                ladders[i][n - 1] = -1
            if n + 1 < N - 1:
                t2 = ladders[i][n + 1]
                ladders[i][n + 1] = -1
            dfs(n, h + 1, count + 1)
            if n - 1 >= 0:
                ladders[i][n - 1] = t1
            if n + 1 < N - 1:
                ladders[i][n + 1] = t2
            ladders[i][n] = 0
    dfs(n + 1, 0, count)


dfs(0, 0, 0)
if min_answer > 3:
    min_answer = -1
print(min_answer)
