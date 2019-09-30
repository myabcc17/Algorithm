#include <iostream>
#include <string.h>
#include <vector>

using namespace std;

vector<pair<int, int>> purifier;
int R, C, T;
int map[51][51] = { {0,} };
int dir_row[4] = { 0, 1, 0, -1 };
int dir_col[4] = { 1, 0, -1, 0 };

bool is_range(int x, int y) {
	if (x < 0 || x >= R || y < 0 || y >= C)
		return false;
	else
		return true;
}
bool up_range(int row, int col, int r) {
	if (row < 0 || row > r || col < 0 || col >= C)
		return false;
	else
		return true;
}
bool down_range(int row, int col, int r) {
	if (row >= R || row < r || col < 0 || col >= C)
		return false;
	else
		return true;
}
void diffusion() {
	int map2[51][51] = { {0 } };
	int i, j, k;
	
	memcpy(map2, map, sizeof(map));

	for (i = 0; i < R; i++) {
		for (j = 0; j < C; j++) {
			if(map[i][j] > 0) {
				int dust_amount = map[i][j] / 5; // 확산될 미세먼지 양
				if (dust_amount == 0)
					continue;
				int count = 0; // 확산된 방향 개수
				for (k = 0; k < 4; k++) { // 상하좌우 검사
					int new_row = i + dir_row[k];
					int new_col = j + dir_col[k];
					if (is_range(new_row, new_col) && map[new_row][new_col] != -1) {
						map2[new_row][new_col] += dust_amount; // 확산
						count++;
					}
				}
				map2[i][j] -= count * dust_amount; // 확산된 양만큼 감소
			}
		}
	}
	memcpy(map, map2, sizeof(map2));
}
void air_clean(int arrow) {
	int start_row = purifier[arrow].first;
	int start_col = purifier[arrow].second;
	int row, col, new_row, new_col;
	vector<int> arrow_row, arrow_col = { 0,1,0,-1 };

	if(arrow == 0) arrow_row = { -1,0,1,0 };	// 위쪽 공기청정기
	else arrow_row = { 1,0,-1,0 };				// 아래쪽 공기청정기 

	int arrow_idx = 0; // 바람 방향
	row = start_row;
	col = start_col;
	while(1) {
		new_row = row + arrow_row[arrow_idx];
		new_col = col + arrow_col[arrow_idx];
		switch (arrow)
		{
		case 0:
			if (!up_range(new_row, new_col, start_row)) {
				arrow_idx++;
				continue;
			}
			break;
		case 1:
			if (!down_range(new_row, new_col, start_row)) {
				arrow_idx++;
				continue;
			}
			break;
		}

		if (new_row == start_row && new_col == start_col) // 바람 다 순환
			break;
		if (row == start_row && col == start_col) // 처음이면 미세먼지 정화
			map[new_row][new_col] = 0;
		else {
			map[row][col] = map[new_row][new_col]; // 아니라면 미세먼지 한칸씩 이동
			map[new_row][new_col] = 0;
		}
		row = new_row;
		col = new_col;
	}
}
int total_dust() {
	int i, j, total = 0;
	for (i = 0; i < R; i++) {
		for (j = 0; j < C; j++) {
			total += map[i][j];
		}
	}
	return total + 2; // 공기청정기 -2 더한 것 리턴
}
int main() {
	int i, j, t;
	cin >> R >> C >> T;
	// input data
	for (i = 0; i < R; i++) {
		for (j = 0; j < C; j++) {
			cin >> t;
			map[i][j] = t;
			if (t == -1)
				purifier.push_back(make_pair(i,j)); // 공기청정기 위치 저장
		}
	}
	for (i = 0; i < T; i++) {
		diffusion();
		air_clean(0);
		air_clean(1);
	}
	cout << total_dust() << endl;
}