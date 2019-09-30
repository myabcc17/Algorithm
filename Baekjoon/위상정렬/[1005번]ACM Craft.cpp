#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
vector<int> result;

void tp(vector<vector<int>> list, vector<int> in_degree, vector<int> times, int N, int w) {
	queue<int> search;
	vector<int> answer(N + 1, 0);
	
	for (int i = 1; i <= N; i++) { // �ʱ� ������ 0�ΰ� �ֱ�
		if (in_degree[i] == 0) {
			search.push(i);
		}
		answer[i] = times[i];
	}
	while (!search.empty()) {
		int vertex = search.front();
		search.pop();

		// vertex�� ����� ������ ���� �� �� ����� ���� �������� ���� 0 �϶�
		for (int i = 0; i < list[vertex].size(); i++) {
			int next = list[vertex][i];
			answer[next] = max(answer[next], answer[vertex] + times[next]); // �ִ밪 ����
			if (--in_degree[list[vertex][i]] == 0)
				search.push(list[vertex][i]);
	 	}
	}
	result.push_back(answer[w]);
}
int main() {
	int N, K, T, w;
	cin >> T;
	for (int t = 0; t < T; t++) {
		cin >> N >> K;
		vector<vector<int>> list(N + 1);
		vector<int> in_degree(N + 1, 0), times(N + 1, 0);

		for (int i = 1; i <= N; i++) {
			int time;
			cin >> time;
			times[i] = time; // �ɸ��� �ð�
		}
		for (int i = 0; i < K; i++) {
			int from, to;
			cin >> from >> to;
			list[from].push_back(to);
			in_degree[to]++;
		}
		cin >> w;
		tp(list, in_degree, times, N, w);
	}
	for (int i = 0; i < result.size(); i++)
		cout << result[i] << endl;
}