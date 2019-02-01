#include <iostream>
#include <queue>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int T, M, N, K;
int visit[51][51] = { { 0, } };
int map[51][51];
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

int bfs()
{
	int i, j, count = 0;
	for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			// 들린적이 없는데 1이 있는경우 들어가서 bfs 돌린다.
			if (map[i][j] == 1 && visit[i][j] == 0) {
				pair<int, int> p = make_pair(j, i);
				q.push(p);
				visit[i][j] = 1;
				count += 1; // 지렁이 마리수
				while (!q.empty()) {
					p = q.front();
					q.pop();
					int m = p.first;
					int n = p.second;

					for (int k = 0; k < 4; k++) {
						int x = m + x_pos[k];
						int y = n + y_pos[k];
						if (is_range(x, y)) {
							if (map[y][x] == 1 && visit[y][x] == 0) {
								visit[y][x] = 1;
								p = make_pair(x, y);
								q.push(p);
							}
						}
					}
				}

			}
		}
	}
	return count;
}
void clear()
{
	for (int i = 0; i < 51; i++)
		for (int j = 0; j < 51; j++)
		{
			map[i][j] = 0;
			visit[i][j] = 0;
		}
}
int main() {
	cin >> T;
	vector<int> result;
	for (int i = 0; i < T; i++) {
		cin >> M >> N >> K;
		for (int j = 0; j < K; j++) {
			int m, n;
			cin >> m >> n;
			map[n][m] = 1;
		}
		result.push_back(bfs());
		clear();
	}

	for (vector<int>::size_type i = 0; i < result.size(); i++)
		cout << result[i] << endl;
}