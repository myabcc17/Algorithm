#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>

using namespace std;


map<string, int> depth;
vector<int> result;
string stack[50];
int top = 0;
bool chk, flag = false;
int min(vector<int> arr) {
	if (!arr.empty()) {
		sort(arr.begin(), arr.end());
		return arr[0];
	}
	else return 0;
}
bool can_swap(string a, string b) {
	int cnt = 0;
	for (int i = 0; i < a.length(); i++)
		if (a[i] == b[i]) cnt++;
	if (cnt == (a.length() - 1)) return true;
	else return false;
}
void dfs(string begin, string target, vector<string> words, map<string, int> visit) {
	visit[begin] = 1; 
	if (begin == target) { // depth가 1일때 예외처리
		result.push_back(1);
		return;
	}
	for (int i = 0; i < words.size(); i++) {
		if (visit[words[i]] == 0 && can_swap(begin, words[i])) { //방문안했고 1개만 바꿔서 만들수있으면?
			visit[words[i]] = 1;
			pair<map<string, int>::iterator, bool> pr = depth.insert(pair<string, int>(words[i], depth[begin] + 1));
			if (!pr.second) {// 중복일 경우 최소값 갱신
				if ((depth[begin] + 1) < depth[words[i]])
					depth[words[i]] = depth[begin] + 1;
			}
			if (words[i] == target) { // 단어 찾으면 결과에 depth 저장
				result.push_back(depth[begin] + 1);
				return;
			}
			dfs(words[i], target, words, visit);
		}
	}
}
int solution(string begin, string target, vector<string> words) {
	int answer = 0;
	if (begin == target)
		return 0;

	for (int i = 0; i < words.size(); i++) {
		if (target == words[i]) chk = true; // target단어가 words에 있는경우
	}
	if (!chk) // target단어가 없으면 return;
		return 0;

	for (int i = 0; i < words.size(); i++) {
		if (can_swap(begin, words[i])) {
			map<string, int> visit;
			pair<map<string, int>::iterator, bool> pr = depth.insert(pair<string, int>(words[i], 1));
			if (!pr.second) // 중복일 경우 갱신
				depth[words[i]] = 1;
			dfs(words[i], target, words, visit);
		}
	}
	if (result.empty())
		return 0;
	else {
		sort(result.begin(), result.end());
		return result[0];
	}
}

int main() {
	string begin, target;
	vector<string> words;
	cin >> begin >> target;
	for (int i = 0; i < 9; i++) {
		string t;
		cin >> t;
		words.push_back(t);
	}
	cout << solution(begin, target, words);
	return 0;
}