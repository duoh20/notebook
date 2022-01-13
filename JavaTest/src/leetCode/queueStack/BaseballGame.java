package leetCode.queueStack;

import java.util.Stack;

//https://leetcode.com/problems/baseball-game/
public class BaseballGame {

    /* 야구게임(BaseballGame) */
    //내 풀이
    public int mySolution(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for(String str : ops) {
            if(str.matches("^[-]?[0-9]*")) {
                stack.push(Integer.parseInt(str));
            } else if(str.equals("C")) {
                stack.pop();
            } else if(str.equals("D")) {
                stack.push(stack.peek() * 2);
            } else {
                Integer prev1 = stack.pop();
                Integer prev2 = stack.pop();
                stack.push(prev2);
                stack.push(prev1);
                stack.push(prev1 + prev2);
            }
        }

        int resut = 0;
        while (stack.size() > 0) {
            resut += stack.pop();
        }

        return resut;
    }

    //풀이
    //이 문제는 스텍으로 풀어야 빠르게 해결할 수 있다.
    //필요없는 연산을 줄이도록 구성(5ms)하여 내가 작성한 코드(48ms)보다 43ms 더 빨랐다.
    public int solution(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for(String op : ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x+y);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    //실행
    public static void main(String[] args) {
        //TestData
        String[] ops = {"1","C","-62","-45","-68"};

        //Output: 30

        //Call
        BaseballGame bg = new BaseballGame();
        int mySolution = bg.mySolution(ops);
        int solution = bg.solution(ops);

        //Output
        System.out.println("[mySolution] Outputs ===> " + mySolution);
        System.out.println("[solution] Outputs ===> " + solution);
    }
}

