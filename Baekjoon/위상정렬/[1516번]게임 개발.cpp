#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

void tp(vector<vector<int>> list, vector<int> in_degree, vector<int> times, int N) {
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
	for (int i = 1; i <= N; i++)
		printf("%d\n", answer[i]);
}
int main() {
	int N;
	cin >> N;
	vector<vector<int>> list(N + 1);
	vector<int> in_degree(N + 1, 0), times(N + 1, 0);

	for (int i = 1; i <= N; i++) {
		int to, time;
		cin >> time;
		times[i] = time; // �ɸ��� �ð�
		while (1) {
			cin >> to;
			if (to == -1)
				break;
			list[to].push_back(i);
			in_degree[i]++;
		}
	}

	tp(list, in_degree, times, N);
}