#include <iostream>
#include <queue>

using namespace std;

int N, K, L;
typedef pair<int, int> pi;

int apple[101][101];
queue<pair<int, int>> info;
vector<pair<int, int>> snake;
int front = 1, back = 1;

bool chk_collision(int new_x, int new_y) {
	for (int i = back - 1; i < front - 1; i++) { // 꼬리 부딪히면 종료
		if ((snake[i].first == new_y) && (snake[i].second == new_x))
			return true;
	}
	return false;
}
int solution() {
	int sec_count = 0;
	int dir_x = 1, dir_y = 0, new_x, new_y; // 뱀의 초기 방향: 오른쪽
	snake.push_back(make_pair(1, 1)); front++; // 뱀의 초기 위치: (0,0)
	while (1) {
		if (!info.empty() && info.front().first == sec_count) { // 회전해야 할 시간이면
			if (info.front().second == 1) { // 오른쪽회전 일 때
				if (dir_x == 0) { // 현재 아래나 위방향 일 때
					if (dir_y == 1) { // 현재 아래방향
						dir_x = -1; dir_y = 0;
					}
					else { // 현재 위 방향
						dir_x = 1; dir_y = 0;
					}
				}
				else { // 현재 오른쪽이나 왼쪽방향
					if (dir_x == 1) { //현재 오른쪽 방향
						dir_x = 0; dir_y = 1;
					}
					else {
						dir_x = 0; dir_y = -1;
					}
				}
			}
			else {
				if (dir_x == 0) { // 현재 아래나 위방향 일 때
					if (dir_y == 1) { // 현재 아래방향
						dir_x = 1; dir_y = 0;
					}
					else { // 현재 위 방향
						dir_x = -1; dir_y = 0;
					}
				}
				else { // 현재 오른쪽이나 왼쪽방향
					if (dir_x == 1) { //현재 오른쪽 방향
						dir_x = 0; dir_y = -1;
					}
					else {
						dir_x = 0; dir_y = 1;
					}
				}
			}
			info.pop();
		}
		new_x = snake.back().second + dir_x; // 1초후 위치
		new_y = snake.back().first + dir_y;
		sec_count++;
		if (chk_collision(new_x, new_y))
			return sec_count;

		if (new_x > N || new_x < 1 || new_y > N || new_y < 1) // 벽에 부딪힐 경우
			break;
		else {
			snake.push_back(make_pair(new_y, new_x)); front++;
			//사과를 먹을때
			if (apple[new_y][new_x])
				apple[new_y][new_x] = 0;
			else
				back++;
		}
	}
	return sec_count;
}
int main() {
	cin >> N >> K;
	for (int i = 0; i < K; i++) {
		int ix, iy;
		cin >> ix >> iy;
		apple[ix][iy] = 1;
	}
	cin >> L;
	for (int i = 0; i < L; i++) {
		int sec;
		char dir;
		cin >> sec >> dir;
		if (dir == 'D') info.push(make_pair(sec, 1)); // 1이 오른쪽
		else info.push(make_pair(sec, 2)); // 2가 왼쪽
	}

	cout << solution() << endl;
}