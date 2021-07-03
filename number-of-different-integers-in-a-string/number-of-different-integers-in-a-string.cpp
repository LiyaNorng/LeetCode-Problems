class Solution {
public:
    int numDifferentIntegers(string word) {
        
        set<string> res;
        for(int i = 0; i < word.length(); i++){
            if(isdigit(word[i])){
                int j = i;
                string temp = "";
                while(j < word.length() && isdigit(word[j])){
                    if(temp == "" && word[j] == '0'){
                        j++;
                        continue;
                    }
                    temp += word[j];
                    j++;
                }
                res.insert(temp);
                i = j;
            }
        }
        
        return res.size();
    }
};