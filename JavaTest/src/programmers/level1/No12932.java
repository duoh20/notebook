package programmers.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class No12932 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
        
		int n = sc.nextInt();
        String num = "" + n;
        
        for(int i = num.length(); i > 0; i--) {
            list.add(Integer.parseInt(num.substring(i-1, i)));
        }
                             
        System.out.println(list.stream().mapToInt(i->i).toArray());
	}
}
