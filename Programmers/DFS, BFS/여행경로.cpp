#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

bool flag = false;
int total_ticket = 0, use_ticket = 0;
vector<string> dfs(vector<vector<string>> tickets, vector<string> path, string start, int visit[], int count) {
	if (count == tickets.size() + 1) {
		flag = true;
		return path;
	}

	for (int i = 0; i < tickets.size(); i++) {
		if (tickets[i][0] == start && visit[i] == 0) {
			visit[i] = 1;
			path.push_back(tickets[i][1]);
			path = dfs(tickets, path, tickets[i][1], visit, count + 1);
			if (path.size() == count) // popµÆÀ»¶§
				visit[i] = 0;
		}
	}
	if (!flag) {
		path.pop_back();
	}
	return path;
}
vector<string> solution(vector<vector<string>> tickets) {
	vector<string> answer;
	int count = 1;
	int visit[10000] = { 0, };
	sort(tickets.begin(), tickets.end());
	answer.push_back("ICN");
	answer = dfs(tickets, answer, "ICN", visit, count);
	return answer;
}
int main() {
	vector<string> t;
	vector<vector<string>> tickets;
	string a, b;
	for (int i = 0; i < 3; i++) {
		cin >> a >> b;
		t.push_back(a);
		t.push_back(b);
		tickets.push_back(t);
		t.clear();
	}
	t = solution(tickets);
	for (int i = 0; i < t.size(); i++) {
		cout << t[i] << " ";
	}
}
