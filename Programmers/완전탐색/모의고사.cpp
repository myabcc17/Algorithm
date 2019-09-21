#include <string>
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;
int max(int a, int b) {
	return a > b ? a : b;
}
vector<int> solution(vector<int> answers) {
	vector<int> answer;
	vector<vector<int>> student(3);
	student[0] = { 1,2,3,4,5 };
	student[1] = { 2,1,2,3,2,4,2,5 };
	student[2] = { 3,3,1,1,2,2,4,4,5,5 };

	int result[3] = { 0, };
	int i;

	for (i = 0; i < 9995; i++) // 1번 수포자
		student[0].push_back(student[0][i % 5]);
	for (i = 0; i < 9992; i++) // 2번 수포자
		student[1].push_back(student[1][i % 8]);
	for (i = 0; i < 9990; i++) // 3번 수포자
		student[2].push_back(student[2][i % 10]);
	
	for (i = 0; i < answers.size(); i++) {
		if (student[0][i] == answers[i])
			result[0]++;
		if (student[1][i] == answers[i])
			result[1]++;
		if (student[2][i] == answers[i])
			result[2]++;
	}
	int max_result = max(max(result[0], result[1]), result[2]);
	answers.clear();
	for (i = 0; i < 3; i++) {
		if (max_result == result[i])
			answers.push_back(i + 1);
	}
	return answers;
}

int main() {
	vector<int> answers;
	int t;
	for (int i = 0; i < 5; i++) {
		cin >> t;
		answers.push_back(t);
	}
	answers = solution(answers);
	for (int i = 0; i < answers.size(); i++)
		printf("%d ", answers[i]);
}