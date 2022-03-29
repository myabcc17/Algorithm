for t in range(int(input())):
    R, S = map(str, input().split())
    R = int(R)

    answer = ""
    for char in S:
        answer += char * R
    print(answer)
