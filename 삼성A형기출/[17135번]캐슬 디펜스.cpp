#include <iostream>
#include <vector>
#include <string.h>
#include <math.h>
#include <algorithm>

using namespace std;

int map[16][16] = { 0, };
int N, M, D;
vector<int> answer;

void game(int arc1, int arc2, int arc3) {
	int copy_map[16][16];
	int arc_pos[3] = { arc1,arc2,arc3 };		
	int kill_cnt = 0;

	memcpy(copy_map, map, sizeof(map));

	for (int stage = 0; stage < N; stage++) { // ���� �� �����ö�����
		vector<pair<int, int>> enemy_pos(3, make_pair(99, 99)); // �� �ü����� ������ �� ��ġ

		for (int i = 0; i < 3; i++) { // �� �ü� �ݺ� �˻�
			int cnt = 0;
			for (int row = N - D; row < N; row++) {
				for (int col = arc_pos[i] - cnt; col <= arc_pos[i] + cnt; col++) {
					if (col < 0 || col >= M) continue; // ���� ����� continue;

					if(copy_map[row][col] == 1) { // ���� ������?
						// ������ �Ÿ� ��
						int ori_dist = abs(enemy_pos[i].first - N) + abs(enemy_pos[i].second - arc_pos[i]);
						int new_dist = abs(row - N) + abs(col - arc_pos[i]);

						if (new_dist < ori_dist) { // �� �����̿� �ִ� ���̸� ����
							enemy_pos[i].first = row;
							enemy_pos[i].second = col;
						}
						else if (new_dist == ori_dist) { // �Ÿ��� �Ȱ����� �� ���ʿ� ������ ����
							if (col < enemy_pos[i].second) {
								enemy_pos[i].first = row;
								enemy_pos[i].second = col;
							}
						}
					}
				}
				cnt++;
			}
		}

		for (int k = 0; k < 3; k++) {
			if (enemy_pos[k].first != 99 && copy_map[enemy_pos[k].first][enemy_pos[k].second] == 1) {
				copy_map[enemy_pos[k].first][enemy_pos[k].second] = 0; // �� ����
				kill_cnt++;
			}
		}
		
		for (int p = N - 1; p >= 1; p--) 
			for (int q = 0; q < M; q++)
				copy_map[p][q] = copy_map[p - 1][q]; // �� �Ʒ��� ��ĭ�� �̵�
		for (int p = 0; p < M; p++)
			copy_map[0][p] = 0;
	}
	answer.push_back(kill_cnt);
}
int main() {
	cin >> N >> M >> D; // N = row, M = col
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			int t; cin >> t;
			map[i][j] = t;
		}
	}

	for (int i = 0; i < M - 2; i++) {
		for (int j = i + 1; j < M - 1; j++) {
			for (int k = j + 1; k < M; k++) {
				game(i, j, k);
			}
		}
	}
	sort(answer.begin(), answer.end(), greater<int>());
	cout << answer[0] << endl;
	return 0;
}