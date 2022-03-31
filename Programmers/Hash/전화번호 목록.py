def solution(phone_book):
    answer = True
    phone_map = {}

    phone_book.sort(key=len, reverse=True)
    for phone_num in phone_book:
        if phone_num in phone_map:
            answer = False
            break

        find_phone_num = ""
        for char in phone_num:
            find_phone_num += char
            phone_map[find_phone_num] = True

    return answer
