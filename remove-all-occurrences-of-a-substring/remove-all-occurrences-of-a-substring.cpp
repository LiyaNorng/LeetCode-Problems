class Solution {
public:
    string removeOccurrences(string s, string part) {
        
        vector<char> list;
        int n = part.length();
        for(char& c : s ){
            if(list.size() == 0 && part.length() == 1 && c != part[0]){
                list.push_back(c);
            }
            else{
                if(list.size() + 1 >= n && c == part[n - 1]){
                    int j = list.size() - 1;
                    int p = part.length() - 2;
                    while(j >= 0 && p >= 0 && part[p] == list[j]){
                        p--;
                        j--;
                    }
                    if(p == -1){
                        //cout<< list[j] << endl;
                        p = list.size() - 1;
                        
                        while(p > j){
                            list.pop_back();
                            p--;
                        }
                    }
                    else{
                        list.push_back(c);
                    }
                }
                else{
                    list.push_back(c);
                }
            }
        }
        
        s = "";
        for(int i = 0; i < list.size(); i++){
            s += list[i];
        }
        return s;
    }
};