#include <iostream>
#include <queue>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int visit[26][26] = { { 0, } };
int map[26][26];
int home_count[1000];
queue<pair<int, int>> q;

int x_pos[4] = { 0, 1, 0, -1 };
int y_pos[4] = { 1,0,-1,0 };

// x, y 범위검사
bool is_range(int x, int y)
{
	if (x < 0 || x >= N || y < 0 || y >= N)
		return false;
	return true;
}

int bfs()
{
	int i, j, count = 0;
	for (i = 0; i < N; i++) {
		for (j = 0; j < N; j++) {
			if (map[i][j] == 1 && visit[i][j] == 0) {
				pair<int, int> p = make_pair(j, i);
				q.push(p);
				visit[i][j] = 1;
				home_count[count] += 1; // 단지마다 집의 개수

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
								home_count[count] += 1;
								p = make_pair(x, y);
								q.push(p);
							}
						}
					}
				}
				count += 1; // 단지의 개수
			}
		}
	}
	return count;
}
int main() {
	cin >> N;
	if (N < 5 || N > 25)
		return 0;

	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		for (int j = 0; j < N; j++) {
			map[i][j] = temp[j] - 48;
		}
	}

	int count = bfs();
	cout << count << endl;

	for (int i = 0; i < count; i++) {
		for (int j = i + 1; j < count; j++) {
			if (home_count[i] > home_count[j]) {
				int tmp = home_count[j];
				home_count[j] = home_count[i];
				home_count[i] = tmp;
			}
		}
	}

	for (int i = 0; i < count; i++)
		cout << home_count[i] << endl;
}