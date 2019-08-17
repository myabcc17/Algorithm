#include <iostream>
#include <stdio.h>
#include <cmath>

using namespace std;

int main() {
	unsigned long long T, N, left, right;
	cin >> T;
	for (int i = 1; i <= T; i++) {
		cin >> N;
		left = 2 * N * N - 4 * N + 3;
		right = 2 * N * N - 1;

		printf("#%d %llu %llu\n", i, left, right);
	}

	return 0;
}