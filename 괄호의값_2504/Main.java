package 괄호의값_2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 괄호열
        char[] input = br.readLine().toCharArray();

        // 후입선출 자료구조 스택
        Stack<Character> stack = new Stack<>();

        // 결과 값을 위한 변수, 계산을 위한 변수
        int result = 0;
        int tmp = 1;

        for(int i=0; i<input.length; i++){
            
            // '('일 경우 tmp변수에 2를 곱한다.
            if(input[i] == '('){
                stack.push(input[i]);
                tmp *= 2;
            }
            // '['일 경우 tmp변수에 3을 곱한다.
            else if(input[i] == '['){
                stack.push(input[i]);
                tmp *= 3;
            }
            else if(input[i] == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    break;
                }
                else if(input[i-1] =='('){
                    result += tmp;
                }
                tmp /= 2;
                stack.pop();
            }
            else if(input[i] == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    break;
                }
                else if(input[i-1] =='['){
                    result += tmp;
                }
                tmp /= 3;
                stack.pop();
            }
                
        }
        if(stack.isEmpty() == false){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }
}