package leetCode.queueStack;

import java.util.*;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    /* 유효한 괄호(ValidParentheses) */
    //String s가 주어진다. s는 (, ), {, }, [. ]로 이루어진다.
    //유효한 괄호인지 체크하여 boolean값으로 리턴하라.
    //열린 괄호는 유효한 순서로, 동일한 유형의 괄호로 닫혀야한다.

    //내 실패한 풀이
    // 문제점: {[]}과 같은 케이스를 커버하지 못함
    public boolean mySolution(String s) {

        Queue<String> queue = new LinkedList<>(Arrays.asList(s.split("")));

        String prev = queue.poll();
        String left = "\\{|\\[|\\(", right = "\\}|\\]|\\)";
        if(prev.matches(right)) {
            return false;
        }

        String p;
        for(int i = 1; i < queue.size() + 1; i++) {

            boolean end = (i % 2) == 1 ? true : false;
            p = queue.poll();

            if(end) {
                if(p.matches(right))  {
                    switch (prev) {
                        case "{":
                            if(!p.equals("}")) return false;
                            break;
                        case "[":
                            if(!p.equals("]")) return false;
                            break;
                        case "(":
                            if(!p.equals(")")) return false;
                            break;
                        default: return false;
                    }
                } else {
                    return false;
                }
            } else {
                if(p.matches(left))  {
                    prev = p;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    //풀이
    //Stack을 활용해서 풀어보자. (LIFO 맨 위의 요소를 비교한다.)
    //괄호문제, 계산기문제, 점수계산 같은 문제들을 stack을 활용해서 풀 수 있다.
    //스택에 open만 넣고 close 쌍을 맞춰본 후 조건을 만족하면 스택에서 빼는 작업을 반복한다.
    public boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if(ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if(ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return  false;
            }
        }
        return stack.isEmpty(); //stack이 비어있으면 true,
    }

    //실행
    public static void main(String[] args) {
        //TestData
        String s = "(){}[]"; //output: true
        //String s = "(]{"; //output: false


        //Call
        ValidParentheses vp = new ValidParentheses();
        boolean mySolution = vp.mySolution(s);
        boolean solution = vp.solution(s);

        //Output
        System.out.println("[mySolution] Outputs ===> " + mySolution);
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N)

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     stack에 s의 길이 n만큼 넣었다 빼기를 반복한다.
    */


    /*** Stack 이용 시 필수 메서드 ***/
    //push() 넣기
    //peek() 맨 위의 요소 보기
    //pop() 맨 위의 요소 꺼내면의 삭제
}
