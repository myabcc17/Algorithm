for t in range(int(input())):
    quiz_result = input()
    score = 0
    add_score = 1
    for char in quiz_result:
        if char == 'O':
            score += add_score
            add_score += 1
        else:
            add_score = 1
    print(score)
