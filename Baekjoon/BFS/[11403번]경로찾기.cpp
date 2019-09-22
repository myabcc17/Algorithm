#include <iostream>
#include <queue>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int visit[101][101] = { {0,} };
vector<int> adjList[101];
queue<int> q;
void bfs(int vertex)
{
	q.push(vertex);
	while (!q.empty()) {
		int p = q.front();
		q.pop();
		// bfs�� ������ ��� ���󰣴�.
		for (vector<int>::size_type i = 0; i < adjList[p].size(); i++) {
			// ���±��� �ְ� �鸰���� ������ ���󰣴�.
			if (adjList[p][i] == 1 && visit[vertex][i] == 0) {
				q.push(i); // �� ����ȣ�� ť�� �ִ´�
				visit[vertex][i] = 1; // vertex���� i��° ���� ���±��� �����Ѵ�.
			}
		}
	}
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		adjList[i].clear();
		for (int j = 0; j < N; j++) {
			int tmp;
			cin >> tmp;
			adjList[i].push_back(tmp);
		}
	}
	for (int i = 0; i < N; i++) {
		// ����ϳ��� üũ
		bfs(i);
		// ��ȴٸ� �ű�� �� �� �ִٴ� �ǹ� >> ���
		for (int j = 0; j < N; j++) {
			cout << visit[i][j] << " ";
		}
		cout << endl;
	}
}