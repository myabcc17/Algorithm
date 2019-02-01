#include <iostream>
#include <queue>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int N, K;
int visit[200001] = { 0, };
queue<int> q;

int bfs()
{
	q.push(N);
	while (!q.empty()) {
		int point = q.front();
		q.pop();
		if (point == K)
			return visit[point];

		if (point > 0 && visit[point-1] == 0) {
			q.push(point - 1);
			visit[point - 1] = visit[point] + 1;
		}

		if (point + 1 <= 200000 && visit[point + 1] == 0) {
			q.push(point + 1);
			visit[point + 1] = visit[point] + 1;
		}

		if (point * 2 <= 200000 && visit[point * 2] == 0) {
			q.push(point * 2);
			visit[point * 2] = visit[point] + 1;
		}
	}
}
int main() {
	cin >> N >> K;
	cout << bfs() << endl;
}