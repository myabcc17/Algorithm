#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void tp(vector<vector<int>> list, vector<int> in_degree, int N) {
	priority_queue<int, vector<int>, greater<int>> search;
	queue<int> result;

	for (int i = 1; i <= N; i++) {
		if (in_degree[i] == 0) {
			search.push(i);
		}
	}

	while (!search.empty()) {
		int vertex = search.top();
		search.pop();
		result.push(vertex);

		// vertex와 연결된 간선을 없앤 후 그 연결된 곳의 인접간선 값이 0 일때
		for (int i = 0; i < list[vertex].size(); i++) {
			if (--in_degree[list[vertex][i]] == 0) {
				search.push(list[vertex][i]);
			}
		}
	}
	while (!result.empty()) {
		printf("%d ", result.front());
		result.pop();
	}
}
int main() {
	int N, M;
	cin >> N >> M;
	vector<vector<int>> list(N + 1);
	vector<int> in_degree(N + 1, 0);

	for (int i = 0; i < M; i++) {
		int from, to;
		cin >> from >> to;
		list[from].push_back(to);
		in_degree[to]++;
	}

	tp(list, in_degree, N);
}