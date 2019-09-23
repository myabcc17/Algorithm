#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void tp(vector<vector<int>> list, vector<int> degree, int N) {
	queue<int> search, result;

	for (int i = 1; i <= N; i++) {
		if (degree[i] == 0)
			search.push(i); // �ʱ� ���������� 1�ΰ͵� ť�� ����
	}

	while (!search.empty()) { // ť�� �� �� ����
		int from = search.front();
		search.pop();
		result.push(from); // ��� ť�� ����
		for (int i = 0; i < list[from].size(); i++) {
			if (--degree[list[from][i]] == 0) { // ����� ���� ���� �� �� ���� degree�� 0�̸�
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
		in_degree[b] += 1; // �ش� vertex �������� ����
	}
	tp(list, in_degree, N);
	
}