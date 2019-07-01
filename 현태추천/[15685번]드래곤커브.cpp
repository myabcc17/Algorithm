#include <iostream>
#include <queue>
#include <math.h>
#include <vector>
#include <algorithm>
#define RIGHT 1
#define UP 2
#define LEFT 3
#define DOWN 4
using namespace std;

int N;
int map[1001][1001] = { {0,} };

int x_pos[4] = { 0,1,0,-1 };
int y_pos[4] = { 1,0,-1,0 };

void make_map(int x, int y, int d, int g) {
	int arrow_list[2001] = { 0, }, i, j;
	int new_x, new_y;
	// 처음 좌표 map에 표시
	map[y][x] = 1;
	// 처음 방향에 따라 새로운 x,y 좌표 계산
	switch (d + 1)
	{
	case RIGHT:
		arrow_list[0] = RIGHT;
		new_x = x + 1; new_y = y;
		break;
	case UP:
		arrow_list[0] = UP;
		new_x = x; new_y = y - 1;
		break;
	case LEFT:
		arrow_list[0] = LEFT;
		new_x = x - 1; new_y = y;
		break;
	case DOWN:
		arrow_list[0] = DOWN;
		new_x = x; new_y = y + 1;
		break;
	}
	// 0세대 좌표 표시
	map[new_y][new_x] = 1;

	// n세대에 따라 바뀌는 좌표 표시
	// 1세대 때 arrow_list가 [1, 2]면 2세대로 갈때 거꾸로 1씩 더한다 -> [1, 2, (2+1), (1+1)] = [1, 2, 3, 2]
	// 3세대는?? [1, 2, 3, 2, (2 + 1), (3 + 1), (2 + 1), (1 + 1)] 이런 알고리즘임
	for (i = 0; i < g; i++) {
		int count = 1, t = pow(2, i);
		for (j = pow(2, i); j < pow(2, i + 1); j++) {
			arrow_list[j] = arrow_list[t - count] + 1;
			if (arrow_list[j] == 5)
				arrow_list[j] = 1;
			switch (arrow_list[j])
			{
			case RIGHT:
				new_x = new_x + 1; new_y = new_y;
				break;
			case UP:
				new_x = new_x; new_y = new_y - 1;
				break;
			case LEFT:
				new_x = new_x - 1; new_y = new_y;
				break;
			case DOWN:
				new_x = new_x; new_y = new_y + 1;
				break;
			}
			map[new_y][new_x] = 1;
			count += 1;
		}
	}
}
int num_square() {
	int i, j, count = 0;
	// 맵에 1이 표시된곳 오른쪽, 아래, 오른쪽아래가 다 1이면 직사각형 1개 추가
	for (i = 0; i < 100; i++) {
		for (j = 0; j < 100; j++) {
			if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1)
				count += 1;
		}
	}
	return count;
}
int main() {
	int x, y, d, g;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> x >> y >> d >> g;
		make_map(x, y, d, g);
	}

	cout << num_square() << endl;
}