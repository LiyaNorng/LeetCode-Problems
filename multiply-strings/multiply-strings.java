class Solution {
    public String multiply(String num1, String num2) {
        
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        StringBuilder carrier = new StringBuilder();
        
        int lengthOfBottom = num2.length() - 1;
        int lengthOfTop = num1.length() - 1;
        int sum = 0;
        int carry = 0;
        int top = 0;
        int bottom = 0;
        int k = 0;
        int check = 0;
        
        if (lengthOfBottom > lengthOfTop){
            String a = num1;
            num1 = num2;
            num2 = a;
            
            int b = lengthOfBottom;
            lengthOfBottom = lengthOfTop;
            lengthOfTop = b;
        }
        
        for (int i = lengthOfBottom; i >= 0; i--){
            bottom = num2.charAt(i) - '0';
            temp.setLength(0);
            int t = k;
            while(t > 0){
                temp.append(0);
                t--;
            }
            k++;
            for (int j = lengthOfTop; j >= 0; j--){
                top = num1.charAt(j) - '0';
                sum = (top * bottom) + carry;
                
                if (sum > 9){
                    carrier.append(sum);
                    carry = carrier.charAt(0) - '0';
                    sum = carrier.charAt(1) - '0';
                    carrier.setLength(0);
                }
                else {
                    carry = 0;
                }
                if (sum > 0){
                    check = 1;
                }
                temp.append(sum);
            }
            if (carry != 0){
                temp.append(carry);
                carry = 0;
            }
            temp.reverse();
            if (check == 1){
                stack.push(temp.toString());
            } 
            else{
                stack.push("0");
            }
            check = 0;
        }
        
        if (stack.size() == 1){
            
            return stack.pop();
        }

        String first = "";
        String second = "";
        carry = 0;
     
        while(!stack.isEmpty()){
            first = !stack.isEmpty() ? stack.pop() : "";
            second = !stack.isEmpty() ? stack.pop() : "";
            int i = first.length() - 1;
            int j = second.length() - 1;
            temp.setLength(0);
            //System.out.println(first + " first");
            //System.out.println(second + " second");
            while(i >= 0 || j >= 0){
                top = i >= 0 ? first.charAt(i) - '0': 0;
                bottom = j >= 0 ? second.charAt(j) - '0': 0;
                i--;
                j--;
                sum = top + bottom + carry;
                if (sum > 9){
                    sum -= 10;
                    carry = 1;
                }
                else{
                    carry = 0;
                }
                temp.append(sum); 
            }
            if (carry != 0){
                temp.append(carry);
                carry = 0;
            }
            temp.reverse();
            if (!stack.isEmpty()){
                stack.push(temp.toString());
            }
        }
        return temp.toString();
    }
}