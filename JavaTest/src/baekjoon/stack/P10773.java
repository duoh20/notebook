package baekjoon.stack;

import java.io.*;
import java.util.Stack;

//https://www.acmicpc.net/problem/10773
public class P10773 {
    /* Title */

    public static void main(String[] args) throws IOException {

        //ForSubmit
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //TestData
        BufferedReader br = new BufferedReader(new FileReader("./JavaTest/src/baekjoon/util/testData.txt"));

        //DataStructure
        Stack<Integer> stack = new Stack<>();

        //Logic
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (stack.isEmpty() && num == 0) {
                continue;
            } else if(num == 0) {
                stack.pop();
            } else {
                stack.add(num);
            }
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        //Output
        System.out.println(result);

        //Close Resources
        br.close();
    }
}
