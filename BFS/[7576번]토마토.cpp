#include <iostream>
#include <queue>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
int visit[1001][1001] = { { 0, } };
int map[1001][1001];
queue<pair<int, int>> q;

int x_pos[4] = { 0, 1, 0, -1 };
int y_pos[4] = { 1,0,-1,0 };

// x, y 범위검사
bool is_range(int x, int y)
{
	if (x < 0 || x >= M || y < 0 || y >= N)
		return false;
	return true;
}

// 다 익었는지 검사
bool ripe_all()
{
	int i, j;
	for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			if (map[i][j] == 0)
				return false;
		}
	}
	return true;
}
int bfs()
{
	int i, j, max = 0;
	pair<int, int> p;

	while (!q.empty()) {
		p = q.front();
		pair<int, int> tmp;
		q.pop();
		// 처음 검사할 좌표 (m, n)
		int m = p.first;
		int n = p.second;

		for (i = 0; i < 4; i++) {
			int x = m + x_pos[i];
			int y = n + y_pos[i];

			if (is_range(x, y)) {
				if (map[y][x] == 0 && visit[y][x] == 0) {
					visit[y][x] = visit[n][m] + 1; // 인접한 토마토가 익기위한 날짜 +1
					map[y][x] = 1; // 토마토가 익었다!!
					if (max < visit[y][x]) // 최대 일수 갱신
						max = visit[y][x];
					tmp = make_pair(x, y);
					q.push(tmp);
				}
			}
		}
	}
	return max;
}
int main() {
	cin >> M >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			// 처음에 익은 토마토들을 큐에 넣어주고 날짜값은 0으로 해준다.
			if (map[i][j] == 1) {
				pair<int,int> p = make_pair(j, i);
				q.push(p);
				visit[p.second][p.first] = 0;
			}
		}
	}
	int result = bfs();

	// 다익었으면 결과값 출력
	if (ripe_all())
		cout << result << endl;
	// 익지않은게 있으면 -1 출력
	else
		cout << "-1" << endl;
}