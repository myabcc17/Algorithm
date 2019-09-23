#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
vector<int> visit_answer;
int visit_count = 0;

void cal_visit(vector<vector<int>> list2, int start) {
	for (int i = 0; i < list2[start].size(); i++) {
		if (!visit_answer[list2[start][i]]) {
			visit_answer[list2[start][i]] = 1;
			visit_count++;
			cal_visit(list2, list2[start][i]);
		}
	}
}
void tp(vector<vector<int>> list, vector<vector<int>> list2, vector<int> in_degree, vector<int> times, int N, int k) {
	queue<int> search;
	visit_answer.assign(N + 1, 0);
	vector<int> answer(N + 1, 0);
	
	for (int i = 1; i <= N; i++) { // 초기 정점이 0인것 넣기
		if (in_degree[i] == 0) {
			search.push(i);
		}
		answer[i] = times[i];
	}
	while (!search.empty()) {
		int vertex = search.front();
		search.pop();

		// vertex와 연결된 간선을 없앤 후 그 연결된 곳의 인접간선 값이 0 일때
		for (int i = 0; i < list[vertex].size(); i++) {
			int next = list[vertex][i];
			answer[next] = max(answer[next], answer[vertex] + times[next]); // 최대값 갱신
			if (--in_degree[list[vertex][i]] == 0)
				search.push(list[vertex][i]);
	 	}
	}
	cal_visit(list2, k);
	printf("%d %d\n", visit_count, answer[k]);
}
int main() {
	int N, k;
	cin >> N >> k;
	vector<vector<int>> list(N + 1), list2(N + 1);
	vector<int> in_degree(N + 1, 0), times(N + 1, 0);
	
	for (int i = 1; i <= N; i++) {
		int to, time;
		cin >> time;
		times[i] = time; // 걸리는 시간
		while (1) {
			cin >> to;
			if (to == -1)
				break;
			list[to].push_back(i);
			list2[i].push_back(to);
			in_degree[i]++;
		}
	}

	tp(list, list2, in_degree, times, N, k);
}