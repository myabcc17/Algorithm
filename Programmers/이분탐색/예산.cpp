#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector<int> budgets;
int M;

int solution(vector<int> budgets, int M) {
	int answer = 0;
	long long int left = 0;
	long long int sum = 0;
	sort(budgets.begin(), budgets.end());
	long long int right = budgets[budgets.size() - 1];

	for (int i = 0; i < budgets.size(); i++)
		sum += budgets[i];
	if (sum <= M) // 다 배정할 수 있을 때
		return right;
	if ((M / budgets.size()) <= 1) { // 예산과 지방의 수가 같을때
		return 1;
	}
	while (right >= left) {
		long long int mid = (left + right) / 2;
		sum = 0;
		for (int i = 0; i < budgets.size(); i++) {
			if (budgets[i] <= mid) {
				sum += budgets[i];
			}
			else {
				sum += mid;
			}
		}
		if (sum < M)
			left = mid + 1;
		else
			right = mid - 1;
	}
	return right;
}

int main() {
	int t;
	for (int i = 0; i < 5; i++) {
		cin >> t;
		budgets.push_back(t);
	}
	cin >> M;
	cout << solution(budgets, M);
}