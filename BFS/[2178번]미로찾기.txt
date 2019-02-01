#include <iostream>
#include <queue>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> map[100];
int num[1000][1000] = { 0, };
queue<pair<int, int>> q;
int n, m;

//상하좌우
int x_pos[4] = { 0, 1, 0,-1 };
int y_pos[4] = { 1,0,-1,0 };

// 미로 범위안인지 검사
int is_range(int x, int y)
{
	int i;
	for (i = 0; i < 4; i++) {
		if (x < 0 || x >= m || y < 0 || y >= n)
			return 0;
	}
	return 1;
}
int bfs()
{
	map[0][0] = -1;
	num[0][0] = 1;
	pair<int, int> p = make_pair(0, 0);
	q.push(p);
	while (!q.empty()) {
		// v:검사하는 위치
		pair<int, int> v = q.front();
		q.pop();
		//상하좌우 검사해야함.
		for (int i = 0; i < 4; i++) {
			int x = v.first + x_pos[i];
			int y = v.second + y_pos[i];
			if (is_range(x, y)) { // 범위 안이면 검사
				if (map[y][x] == 1) { // 방문안한곳이면 검사
					// 종점이라면 바로 종료
					if (x == m - 1 && y == n - 1)
						return num[v.second][v.first] + 1;
					// [y][x]인 이유는 배열에서는 반대이기 때문 [1][2]는 좌표상으로 (2,1)이다.!!
					map[y][x] = -1; // 방문했다고 체크
					num[y][x] = num[v.second][v.first] + 1; // 전에 왔던곳에서 +1
					p = make_pair(x, y);
					q.push(p);
				}
			}
		}
	}
}
int main() {
	string str;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> str;
		for (int j = 0; j < m; j++) {
			int t = str[j] - 48;
			map[i].push_back(t);
		}
	}
	
	cout << bfs() << endl;
}



