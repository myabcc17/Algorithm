input_str = input()

dict = {}

for char in input_str:
    upper_char = char.upper()
    count = dict.get(upper_char)

    if not count:
        dict[upper_char] = 1
    else:
        dict[upper_char] = count + 1

answers = []

for key in dict:
    answers.append(dict[key])

sorted_dict = sorted(dict.items(), key=lambda item: item[1], reverse=True)

if len(sorted_dict) >= 2 and sorted_dict[0][1] == sorted_dict[1][1]:
    print('?')
else:
    print(sorted_dict[0][0])