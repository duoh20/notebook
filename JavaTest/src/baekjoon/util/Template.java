package baekjoon.util;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

public class Template { //제출 시 클래스명을 Main으로 변경

    /* Title */

    public static void main(String[] args) throws IOException {

        //ForSubmit
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //TestData
        BufferedReader br = new BufferedReader(new FileReader("./JavaTest/src/beakjoon/util/testData.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        //DataStructure

        //Logic


        //Output
        System.out.println();

        //Close Resources
        br.close();
        bw.close();
    }
}
