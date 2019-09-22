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
	for (int i = back - 1; i < front - 1; i++) { // ���� �ε����� ����
		if ((snake[i].first == new_y) && (snake[i].second == new_x))
			return true;
	}
	return false;
}
int solution() {
	int sec_count = 0;
	int dir_x = 1, dir_y = 0, new_x, new_y; // ���� �ʱ� ����: ������
	snake.push_back(make_pair(1, 1)); front++; // ���� �ʱ� ��ġ: (0,0)
	while (1) {
		if (!info.empty() && info.front().first == sec_count) { // ȸ���ؾ� �� �ð��̸�
			if (info.front().second == 1) { // ������ȸ�� �� ��
				if (dir_x == 0) { // ���� �Ʒ��� ������ �� ��
					if (dir_y == 1) { // ���� �Ʒ�����
						dir_x = -1; dir_y = 0;
					}
					else { // ���� �� ����
						dir_x = 1; dir_y = 0;
					}
				}
				else { // ���� �������̳� ���ʹ���
					if (dir_x == 1) { //���� ������ ����
						dir_x = 0; dir_y = 1;
					}
					else {
						dir_x = 0; dir_y = -1;
					}
				}
			}
			else {
				if (dir_x == 0) { // ���� �Ʒ��� ������ �� ��
					if (dir_y == 1) { // ���� �Ʒ�����
						dir_x = 1; dir_y = 0;
					}
					else { // ���� �� ����
						dir_x = -1; dir_y = 0;
					}
				}
				else { // ���� �������̳� ���ʹ���
					if (dir_x == 1) { //���� ������ ����
						dir_x = 0; dir_y = -1;
					}
					else {
						dir_x = 0; dir_y = 1;
					}
				}
			}
			info.pop();
		}
		new_x = snake.back().second + dir_x; // 1���� ��ġ
		new_y = snake.back().first + dir_y;
		sec_count++;
		if (chk_collision(new_x, new_y))
			return sec_count;

		if (new_x > N || new_x < 1 || new_y > N || new_y < 1) // ���� �ε��� ���
			break;
		else {
			snake.push_back(make_pair(new_y, new_x)); front++;
			//����� ������
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
		if (dir == 'D') info.push(make_pair(sec, 1)); // 1�� ������
		else info.push(make_pair(sec, 2)); // 2�� ����
	}

	cout << solution() << endl;
}