#include <string>
#include <vector>
#include <algorithm>

using namespace std;
bool visit[200];

void dfs(int n, vector<vector<int>>& computers, int vertex) {
	visit[vertex] = 1;

	for (int i = 0; i < n; i++) {
		if (computers[vertex][i] && !visit[i]) {
			dfs(n, computers, i);
		}
	}
}
int solution(int n, vector<vector<int>> computers) {
	int answer = 0;
	for (int i = 0; i < n; i++) {
		if (!visit[i]) {
			dfs(n, computers, i);
			answer++;
		}
	}
	return answer;
}