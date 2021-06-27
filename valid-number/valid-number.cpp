class Solution {
    
    enum States {
        invalid,
        q0,
        q1,
        q2, 
        q3, 
        q4,
        q5, 
        q6, 
        q7, 
        q8,
        q9
    };

    private:
    
        /**
        STATE MACHINE 
        
        state q0 :
                q1, q2, q3
                +/-, ., 0-9
        state q1:
                q2, q3, 
                ., 0-9
        state q2:
                q5
                0-9
        state q3:
                q3, q4, q6
                0-9, e/E, .
        state q4:
                q7, q9
                +/-, 0-9
        state q5:
                q5, q4, 
                0-9, e/E
        state q6:
                q5, q4
                0-9, e/E
        state q7:
                q8, q9
                ., 0-9
        state q8:
                q9
                0-9
        state q9:
                q9
                0-9
        
        **/
    
    
        vector<vector<States>> state = {
            
           //  +/-      .        0-9      e/E     invalid    
       
            {invalid, invalid, invalid, invalid, invalid},
            {q1, q2, q3, invalid, invalid},         // q0
            {invalid, q2, q3, invalid, invalid},    // q1
            {invalid, invalid, q5, invalid, invalid}, // q2
            {invalid, q6, q3, q4, invalid},   // q3
            {q7, invalid, q9, invalid, invalid},        // q4
            {invalid, invalid, q5, q4, invalid}, // q5
            {invalid, invalid, q5, q4, invalid},    // q6
            {invalid, q8, q9, invalid, invalid}, // q7
            {invalid, invalid, q9, invalid, invalid}, // q8
            {invalid, invalid, q9, invalid, invalid}, // q9

        };
    
     int getNext(char c ){
        if(c == '+' || c == '-'){
            return 0;
        }
        else if(c == '.'){
            return 1;
        }
        else if(c >= '0' && c <= '9'){
            return 2;
        }
        else if(c == 'e' || c == 'E'){
            return 3;
        }
        else{
            return 4;
        }
    }
    
    States nextState(States current, char c){
        return state[(int)current][getNext(c)];
    }
    
    public: 
    
        bool isNumber(string s) {

            States currentState = q0;

            for(int i = 0; i < s.length(); i++){
               currentState = nextState(currentState, s[i]);
            }
            
            return currentState == q3 || currentState == q5 || currentState == q6 || currentState == q9;

        }
};