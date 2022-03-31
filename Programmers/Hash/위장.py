def wear(i, )

def solution(clothes):
    answer = 0
    cloth_map = {}
    for cloth in clothes:
        if cloth[0] not in cloth_map:
            cloth_map[cloth[0]] = [cloth[1]]
        else:
            cloth_map[cloth[0]].append(cloth[1])

    return answer