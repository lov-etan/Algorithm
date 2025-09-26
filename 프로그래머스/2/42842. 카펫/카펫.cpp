#include <string>
#include <vector>

using namespace std;
int b, y;

vector<int> solution(int brown, int yellow) {
    b = brown; y = yellow;
    vector<int> answer;
    
    int by = brown/2;
    int tmpC = 1;
    while(1) {
        int tmpR = by - tmpC;
        int r = tmpR+1; int c = tmpC+1;
        int total = r*c;
        if(total - brown == yellow) {
            answer.push_back(r); answer.push_back(c);
            break;
        }
        tmpC++;
        
    }
    return answer;
}