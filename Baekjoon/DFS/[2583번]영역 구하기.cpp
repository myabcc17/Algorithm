#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, K, cnt = 0, area_size;
int map[101][101] = { {0,} };
int dir_x[4] = { 1,0,-1,0 }; // 우 하 좌 상
int dir_y[4] = { 0,1,0,-1 };
vector<int> area;

void dfs(int i, int j, int cnt) {
	map[i][j] = 1; // 검사한 영역 지우기
	area_size += 1; // 영역 더하기

	for (int k = 0; k < 4; k++) {
		if (i + dir_y[k] >= 0 && i + dir_y[k] < M && j + dir_x[k] >= 0 && j + dir_x[k] < N) {
			if (map[i + dir_y[k]][j + dir_x[k]] == 0)
				dfs(i + dir_y[k], j + dir_x[k], cnt);
		}
	}
}
int main() {
	int x1, x2, y1, y2, i, j, t;
	cin >> M >> N >> K;

	// input data & map setting
	for (i = 0; i < K; i++) {
		cin >> x1 >> y1 >> x2 >> y2;
		for (j = y1; j < y2; j++) {
			for (t = x1; t < x2; t++) {
				map[j][t] = 1;
			}
		}
	}

	// dfs
	for (i = 0; i < M; i++) {
		for (j = 0; j < N; j++) {
			if (map[i][j] == 0) {
				area_size = 0;
				dfs(i, j, cnt++);
				area.push_back(area_size);
			}
		}
	}

	cout << area.size() << endl;
	sort(area.begin(), area.end());
	for (i = 0; i < area.size(); i++)
		printf("%d ", area[i]);
	return 0;
}