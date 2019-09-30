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
				int dust_amount = map[i][j] / 5; // Ȯ��� �̼����� ��
				if (dust_amount == 0)
					continue;
				int count = 0; // Ȯ��� ���� ����
				for (k = 0; k < 4; k++) { // �����¿� �˻�
					int new_row = i + dir_row[k];
					int new_col = j + dir_col[k];
					if (is_range(new_row, new_col) && map[new_row][new_col] != -1) {
						map2[new_row][new_col] += dust_amount; // Ȯ��
						count++;
					}
				}
				map2[i][j] -= count * dust_amount; // Ȯ��� �縸ŭ ����
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

	if(arrow == 0) arrow_row = { -1,0,1,0 };	// ���� ����û����
	else arrow_row = { 1,0,-1,0 };				// �Ʒ��� ����û���� 

	int arrow_idx = 0; // �ٶ� ����
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

		if (new_row == start_row && new_col == start_col) // �ٶ� �� ��ȯ
			break;
		if (row == start_row && col == start_col) // ó���̸� �̼����� ��ȭ
			map[new_row][new_col] = 0;
		else {
			map[row][col] = map[new_row][new_col]; // �ƴ϶�� �̼����� ��ĭ�� �̵�
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
	return total + 2; // ����û���� -2 ���� �� ����
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
				purifier.push_back(make_pair(i,j)); // ����û���� ��ġ ����
		}
	}
	for (i = 0; i < T; i++) {
		diffusion();
		air_clean(0);
		air_clean(1);
	}
	cout << total_dust() << endl;
}