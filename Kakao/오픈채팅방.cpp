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

		// String 한 줄 파싱
		string what, id, name;
		ss >> what;
		if (what.compare("") == 0)
			break;
		ss >> id;
		ss >> name;

		// Enter나 Change의 경우 아이디 체크
		if (what.compare("Leave") != 0) {
			pair<map<string, string>::iterator, bool> pr;
			pr = account.insert(make_pair(id, name)); // map에 똑같은 id가 있다면 false
			if (false == pr.second) {
				account.erase(account.find(id)); // map의 중복 id제거
				account.insert(make_pair(id, name)); // map에 새로운 id, name 입력
			}
		}
		// Change 경우 빼고 모두 record에 기록
		if (what.compare("Change") != 0) events.push_back(make_pair(id, what));
	}
	vector<pair<string, string>>::iterator iter;
	for (iter = events.begin(); iter != events.end(); ++iter) {
		string temp;
		temp.append(account.find(iter->first)->second); // id에 해당하는 name 검색

		if (iter->second.compare("Enter") == 0) temp.append("님이 들어왔습니다.");
		else if (iter->second.compare("Leave") == 0) temp.append("님이 나갔습니다.");
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
