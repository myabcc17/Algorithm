#include <string>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
	vector<int> answer;
	int* stage_in_ratio = (int*)calloc(N + 2, sizeof(int));
	int* stage_fail_ratio = (int*)calloc(N + 2, sizeof(int));

	for(vector<int>::size_type i = 0; i < stages.size(); i++) {
		for (int j = 1; j <= stages[i]; j++) 
			stage_in_ratio[j] += 1;
		stage_fail_ratio[stages[i]]++;
	}

	// 동일한 ratio값도 저장되고, 내림차순 map 선언
	multimap<double, int, greater<double>> sorted_map;
	for (int i = 1; i <= N; i++) {
		double ratio = (double)stage_fail_ratio[i] / (double)stage_in_ratio[i];
		sorted_map.insert(make_pair(ratio, i));
	}
	for (auto const& entry : sorted_map)
		answer.push_back(entry.second);
	return answer;
}

int main() {
	int N;
	vector<int> stages;
	cin >> N;
	for (int i = 0; i < 8; i++) {
		int t;
		cin >> t;
		stages.push_back(t);
	}
	vector<int> answer = solution(N, stages);
	for (vector<int>::size_type i = 0; i < answer.size(); i++)
		cout << answer[i] << " ";
}