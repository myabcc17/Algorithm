#include <string>
#include <iostream>

#define R 0
#define G 1
#define B 2

using namespace std;

int visit[101][101] = { {0,} };
int visit2[101][101] = { {0,} };
int map[101][101];
int n;

int dir_x[4] = { 1,0,-1,0 };
int dir_y[4] = { 0,1,0,-1 };
void dfs(int row, int col) {
	int answer = 0;
	visit[row][col] = 1;

	for (int i = 0; i < 4; i++) {
		int new_row = row + dir_x[i];
		int new_col = col + dir_y[i];
		if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < n) {
			if (!visit[new_row][new_col] && map[row][col] == map[new_row][new_col])
				dfs(new_row, new_col);
		}
	}
}
void dfs2(int row, int col) {
	int answer = 0;
	visit2[row][col] = 1;

	for (int i = 0; i < 4; i++) {
		int new_row = row + dir_x[i];
		int new_col = col + dir_y[i];
		if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < n) {
			if (!visit2[new_row][new_col]) {
				if((map[row][col] == R && map[new_row][new_col] == G) || (map[row][col] == G && map[new_row][new_col] == R) || map[row][col] == map[new_row][new_col])
					dfs2(new_row, new_col);
			}
				
		}
	}
}
int main() {
	int count1 = 0, count2 = 0;
	char t;

	cin >> n;

	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < n; j++) {
			switch (str[j])
			{
			case 'R':
				map[i][j] = R;
				break;
			case 'G':
				map[i][j] = G;
				break;
			case 'B':
				map[i][j] = B;
				break;
			default:
				break;
			}
		}
	}
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			// 적록색약 x
			if (!visit[i][j]) {
				dfs(i, j);
				count1++;
			}
			// 적록색약 o
			if (!visit2[i][j]) {
				dfs2(i, j);
				count2++;
			}
		}
	}
	printf("%d %d\n", count1, count2);
}