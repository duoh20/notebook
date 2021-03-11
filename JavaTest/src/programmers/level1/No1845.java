package programmers.level1;

import java.util.ArrayList;
import java.util.HashSet;

public class No1845 {
	
	/* 포켓몬 */
	public int solution(int[] nums) {
	    
        ArrayList<Integer> kinds = new ArrayList<>();
        
        for(int i : nums) {
            if(!kinds.contains(i)) kinds.add(i);
        }
        
        int kLength = kinds.size();
        int nLength = nums.length / 2;
        
        return kLength > nLength ? nLength : kLength;
    }
	
	
	/* 다른 사람 풀이 */
	//HashSet을 사용하여 풀었다.
	//HashSet은 애초에 중복 값이 들어가지 않으므로 따로 중복 검사를 할 필요가 없다.
	 public int solution1(int[] nums) {
		 
         HashSet<Integer> hs = new HashSet<>();

         for(int i =0; i<nums.length;i++) {
             hs.add(nums[i]);
         }

         if(hs.size()>nums.length/2)
             return nums.length/2;
         
         return hs.size();
	 }
}
