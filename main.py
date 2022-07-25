import collections
import functools
import itertools
import operator

str1 = ["a", "b", "c"]
str2 = ["d", "e", "f"]

result = list(itertools.product(*[str1, str2]))

answer = []

for e in result:
    answer.append(functools.reduce(operator.add, e))