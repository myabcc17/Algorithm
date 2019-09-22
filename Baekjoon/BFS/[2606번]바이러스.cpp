#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int N, M;

vector<vector<int>> network(101);
queue<int> q;
bool visit[101];

int bfs(int start) {
	int count = 0;
	visit[start] = true;
	q.push(start);
	while (!q.empty()) {
		int next = q.front();
		q.pop();
		for (int i = 0; i < network[next].size(); i++) {
			if (!visit[network[next][i]]) {
				q.push(network[next][i]);
				visit[network[next][i]] = true;
				count++;
			}
		}
	}
	
	return count;
}
int main() {
	int a, b;
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		network[a].push_back(b);
		network[b].push_back(a);
	}
	cout << bfs(1) << endl;
}