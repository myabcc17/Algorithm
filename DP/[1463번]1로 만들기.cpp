#include <iostream>
#include <stdio.h>
#include <algorithm>
using namespace std;

int d[1000001] = { 0, };
int dp(int num);
int N;

int main()
{
	cin >> N;
	d[1] = 0;
	d[2] = 1;
	d[3] = 1;
	cout << dp(N);
	return 0;
}

int dp(int num) {
	int a,b,c;

	for (int i = 4; i <= N; i++) {
		a = b = c = 0;
		if (i % 3 == 0)
			a = d[i / 3] + 1;
		if (i % 2 == 0)
			b = d[i / 2] + 1;
		c = d[i - 1] + 1;

		if (a && b) {
			a = min(a, b);
			d[i] = min(a, c);
		}
		else if (a) {
			d[i] = min(a, c);
		}
		else if (b) {
			d[i] = min(b, c);
		}
		else {
			d[i] = c;
		}
	}
	return d[N];
}
