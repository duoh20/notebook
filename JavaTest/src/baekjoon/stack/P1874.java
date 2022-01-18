package baekjoon.stack;

import java.io.*;
import java.util.Stack;


//https://www.acmicpc.net/problem/10828
public class P1874 {

    /* 스택 */

    public static void main(String[] args) throws IOException {

        //ForSubmit
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //TestData
        BufferedReader br = new BufferedReader(new FileReader("./JavaTest/src/baekjoon/util/testData.txt"));

        int n = Integer.parseInt(br.readLine());
        String[] options = new String[n];
        for (int i = 0; i < n; i++) {
            options[i] = br.readLine();
        }

        //DataStructure
        Stack<Integer> stack = new Stack<>();

        //Logic
        for (String op : options) {

            if (op.indexOf("push") > -1) {
                stack.push(Integer.parseInt(op.split(" ")[1]));
            } else if (op.indexOf("pop") > -1) {
                if (stack.size() > 0) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            } else if (op.indexOf("size") > -1) {
                System.out.println(stack.size());
            } else if (op.indexOf("empty") > -1) {
                if (stack.size() > 0) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else {
                if (stack.size() > 0) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }

        //Close Resources
        br.close();
    }


    //다른 사람의 풀이를 참고하여 리팩토링 (364ms -> 200ms)
    //시간 줄이기 전략 : for를 쓸데없이 여러 번 돌리지 말자.
    //아래 예제에서는 indexOf보다 String배열에 담아 String으로 비교하자.
    // ++ 시간 효율은 indexOf()가 contains() 보다 좋다.
    //리턴 값 출력할 때 sysout을 자주 호출하지 말고 SpringBuilder에 담아 한 번에 출력하자.
    public static void solution() throws IOException {

        //TestData
        BufferedReader br = new BufferedReader(new FileReader("./JavaTest/src/baekjoon/util/testData.txt"));

        //DataStructure
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        //Logic
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] ops = br.readLine().split(" ");

            switch(ops[0]) {
                case "push":
                    stack.push(Integer.parseInt(ops[1]));
                    break;
                case "pop":
                    if (stack.size() > 0) {
                        sb.append(stack.pop()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        //Ouput
        System.out.println(sb.toString());

        //Close Resources
        br.close();
    }
}
