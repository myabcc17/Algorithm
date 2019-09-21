#include <string>
#include <vector>

using namespace std;

int dfs(vector<int> numbers, int target, int index, int num) {
	if (index == numbers.size())
		return num == target ? 1 : 0;
	else {
		return dfs(numbers, target, index + 1, num + numbers[index])
			+ dfs(numbers, target, index + 1, num - numbers[index]);
	}
}
int solution(vector<int> numbers, int target) {
	int answer = 0;
	answer = dfs(numbers, target, 0, 0);
	return answer;
}