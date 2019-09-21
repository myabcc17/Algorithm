#include <string>
#include <vector>
#include <iostream>
#include <set>
#include <algorithm>
#include <math.h>

using namespace std;
vector<int> num;
set<int> prime;

bool is_prime(int num) {
	if (num < 2)
		return false;
	for (int i = 2; i <= sqrt(num); i++) {
		if (num % i == 0)
			return false;
	}
	return true;
}
string swap(string numbers, int idx, int depth) {
	char temp = numbers.at(idx);
	numbers[idx] = numbers.at(depth);
	numbers[depth] = temp;
	return numbers;
}
void perm(string numbers, int depth, int n, int k) {
	if (depth == k) { // 사이클이 다돌았음.
		string str = numbers.substr(0, k);
		int val = stoi(str);
		if (is_prime(val))
			prime.insert(val);
		return;
	}
	for (int i = depth; i < n; i++) {
		numbers = swap(numbers, i, depth);
		perm(numbers, depth + 1, n, k);
		numbers = swap(numbers, i, depth);
	}
}
int solution(string numbers) {
	int size = numbers.length();

	for (int i = 1; i <= size; i++) {
		perm(numbers, 0, size, i);
	}
	return prime.size();
}

int main() {
	string numbers;
	cin >> numbers;
	cout << solution(numbers);

}