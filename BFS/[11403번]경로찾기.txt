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
		// bfs로 노드들을 계속 따라간다.
		for (vector<int>::size_type i = 0; i < adjList[p].size(); i++) {
			// 가는길이 있고 들린적이 없으면 따라간다.
			if (adjList[p][i] == 1 && visit[vertex][i] == 0) {
				q.push(i); // 그 노드번호를 큐에 넣는다
				visit[vertex][i] = 1; // vertex에서 i번째 노드로 가는길이 존재한다.
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
		// 노드하나씩 체크
		bfs(i);
		// 들렸다면 거기로 갈 수 있다는 의미 >> 출력
		for (int j = 0; j < N; j++) {
			cout << visit[i][j] << " ";
		}
		cout << endl;
	}
}