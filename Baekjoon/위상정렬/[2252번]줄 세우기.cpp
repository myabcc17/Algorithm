#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void tp(vector<vector<int>> list, vector<int> degree, int N) {
	queue<int> search, result;

	for (int i = 1; i <= N; i++) {
		if (degree[i] == 0)
			search.push(i); // 초기 진입차수가 1인것들 큐에 삽입
	}

	while (!search.empty()) { // 큐가 빌 때 까지
		int from = search.front();
		search.pop();
		result.push(from); // 결과 큐에 삽입
		for (int i = 0; i < list[from].size(); i++) {
			if (--degree[list[from][i]] == 0) { // 연결된 간선 제거 후 그 곳의 degree가 0이면
				search.push(list[from][i]);
			}
		}
	}

	while(!result.empty()) {
		printf("%d ", result.front());
		result.pop();
	}
}
int main() {
	int M, N;
	cin >> N >> M;
	vector<vector<int>> list(N + 1);
	vector<int> in_degree(N + 1);
	
	for (int i = 0; i < M; i++)
		in_degree.push_back(0);

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		list[a].push_back(b);
		in_degree[b] += 1; // 해당 vertex 진입차수 증가
	}
	tp(list, in_degree, N);
	
}