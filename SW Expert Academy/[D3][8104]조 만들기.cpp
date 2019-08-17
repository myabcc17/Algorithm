#include <iostream>

int T, N, K;

using namespace std;

void solve(int T, int N, int K);
int main()
{
	int i;
	cin >> T;
	
	for (i = 0; i < T; i++) {
		cin >> N >> K;
		solve(i + 1, N, K);
	}

	return 0;
}

void solve(int T, int N, int K)
{
	int res[21] = { 0, }; // 1 <= N, K <= 20

	for (int i = 1; i <= K; i++) {
		if (N % 2 == 0)		// N is even
			res[i] = (N / 2) * (K * N + 1);
		else				// N is odd
			res[i] = (N / 2) * (2 * K * (N / 2) + 2 * K + 1) + 1 + (i - 1);
	}
	
	// 정답출력
	printf("#%d", T);
	for (int i = 1; i <= K; i++) {
		printf(" %d", res[i]);
	}
	printf("\n");
}
