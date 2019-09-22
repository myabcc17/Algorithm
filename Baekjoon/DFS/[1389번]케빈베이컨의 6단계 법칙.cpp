#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, ans = 99999, person;
vector<vector<int>> arr(101);


void dfs(int count[], int start, int depth) {
	if (count[start] != 0)
		count[start] = min(depth, count[start]);
	else {
		count[start] = depth;
	}

	for (int i = 0; i < arr[start].size(); i++) {
		int next = arr[start][i];

		if (count[next] == 0 || count[next] > depth + 1) {
			dfs(count, next, depth + 1);
		}
	}
}
int main() {
	int a, b, i, j;
	cin >> N >> M;

	for (i = 0; i < M; i++) {
		cin >> a >> b;
		arr[a].push_back(b);
		arr[b].push_back(a);
	}

	for (i = 1; i <= N; i++) {
		int count[101] = { 0, };
		dfs(count, i, 0);

		int sum = 0;
		for (j = 1; j <= N; j++) {
			sum += count[j];
		}
			 
		if (ans > sum) {
			ans = sum;
			person = i;
		}
	}

	cout << person << endl;

	return 0;
}