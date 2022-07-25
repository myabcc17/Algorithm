S = input()

alp_idx = [-1] * 26
for i in range(len(S)):
    idx = ord(S[i]) - ord('a')
    if alp_idx[idx] == -1:
        alp_idx[idx] = i

alp_idx = [str(i) for i in alp_idx]
print(' '.join(alp_idx))
