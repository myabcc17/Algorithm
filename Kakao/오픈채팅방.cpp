#include <string>
#include <iostream>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

vector<string> record, answer;
vector<pair<string, string>> info, events;
map<string, string> account;

vector<string> solution(vector<string> record) {
	vector<string> answer;

	for (vector<string>::size_type k = 0; k < record.size(); k++) {
		stringstream ss(record[k]);
		vector<pair<string, string>>::size_type i = 0;

		// String �� �� �Ľ�
		string what, id, name;
		ss >> what;
		if (what.compare("") == 0)
			break;
		ss >> id;
		ss >> name;

		// Enter�� Change�� ��� ���̵� üũ
		if (what.compare("Leave") != 0) {
			pair<map<string, string>::iterator, bool> pr;
			pr = account.insert(make_pair(id, name)); // map�� �Ȱ��� id�� �ִٸ� false
			if (false == pr.second) {
				account.erase(account.find(id)); // map�� �ߺ� id����
				account.insert(make_pair(id, name)); // map�� ���ο� id, name �Է�
			}
		}
		// Change ��� ���� ��� record�� ���
		if (what.compare("Change") != 0) events.push_back(make_pair(id, what));
	}
	vector<pair<string, string>>::iterator iter;
	for (iter = events.begin(); iter != events.end(); ++iter) {
		string temp;
		temp.append(account.find(iter->first)->second); // id�� �ش��ϴ� name �˻�

		if (iter->second.compare("Enter") == 0) temp.append("���� ���Խ��ϴ�.");
		else if (iter->second.compare("Leave") == 0) temp.append("���� �������ϴ�.");
		answer.push_back(temp);
	}

	return answer;
}
int main() {
	string t;
	while (getline(cin, t)) {
		if (t.compare("") != 0)	record.push_back(t);
		else break;
	}
	record = solution(record);
	for (vector<string>::size_type i = 0; i < record.size(); i++)
		cout << record[i] << endl;
	return 0;
}
