package leetCode.array;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    /* 그룹 아나그램(GroupAnagrams) */
    //String 배열이 주어진다.
    //주어진 String은 배열 안에서 다른 String과 아나그램 관계다.
    //String 순서 상관 없이 같은 알파벳으로 구성된 단어끼리 묶어서 리턴하라
    //아나그램: 문자 단어를 재배열하여 새로운 문자를 형성하는 것을 말함


    //1.Sort
    public List<List<String>> solutionSort(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArra = str.toCharArray();
            Arrays.sort(charArra);
            String key = String.valueOf(charArra);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }

            //contains(key)로 분기하는 부분은 getOrDefault()메소드를 이용할 수도 있다.
            //List<String> list = map.getOrDefault(key, new ArrayList<>()); //key가 있으면 value를 반환하고, 없으면 지정한 것 (여기서는 새 ArrayList 인스턴스)를 반환)
            //list.add(str);
            //map.put(key, list);
        }

        /* 리턴 데이터 형식 정제하기 */
        //리턴은 아래와 같이 간략하게 적어줄 수 있다.
        //result.addAll(map.values());
        //return result;

        //또는 map.entrySet()을 활용한 방법도 있다.
        //for(Map.Entry<String,List<String>> entry : map.entrySet()) {
        //    result.add(entry.getValue());
        //}
        return new ArrayList<>(map.values());
    }

    //2.Sort 없이 아스키코드로 풀이
    public List<List<String>> solutionAscii(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26]; //a-z
            for(int k = 0; k < str.length(); k++) {
                count[str.charAt(k) - 'a']++; //[1,0,0,0,1....1,..] 26개
                //a의 아스키값은 97이다.
                //e-a는 101-97=4번방에 값에 1을 넣고
                //a-a는 97-97=0번방에 값에 1을 넣고
                //t-a는 116-97=19번방에 값에 1을 넣고
            }
            String key = Arrays.toString(count);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<>(map.values());
    }

    //실행
    public static void main(String[] args) {
        //TestData
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        //Output : [["bat"],["nat","tan"],["ate","eat","tea"]]

        //Call
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> solutionSort = ga.solutionSort(strs);
        List<List<String>> solutionAscii = ga.solutionAscii(strs);

        //Output
        System.out.println("[solutionSort] Outputs ===> " + solutionSort.toString());
        System.out.println("[solutionAscii] Outputs ===> " + solutionAscii.toString());
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(NlogK)
                     strs 배열의 크기가 n개, str의 length()가 k개, 소팅 실행 logK

        공간복잡도
        대상(Source): 메모리 사용량은 O(NK)
                     strs 배열의 키기 n개 str의 length k개
    */
}
