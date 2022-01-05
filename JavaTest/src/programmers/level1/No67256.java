package programmers.level1;

public class No67256 {

    /* 키패드 누르기 */
    // * 0 # 을 각각 10, 11, 13으로 생각한다.
    // 1,4,7과 3,6,9는 정해진 손이 있으므로 첫번째로 거른다.
    // 나머지 케이스에 대해 각 손가락의 위치가 가진 값을 x, y로 생각하여 눌러야할 숫자의 x, y와 비교한다.
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10, right = 12;

        for(int num : numbers) {
            if(num == 0) num = 11;

            if(num % 3 == 1) {
                answer += "L";
                left = num;
            } else if(num % 3 == 0) {
                answer += "R";
                right = num;
            } else {
                int leftLength = getLength(left, num);
                int rightLength = getLength(right, num);

                if(leftLength < rightLength) {
                    answer += "L";
                    left = num;
                } else if(leftLength > rightLength) {
                    answer += "R";
                    right = num;
                } else {
                    if(hand.equals("left")) {
                        answer += "L";
                        left = num;
                    } else {
                        answer += "R";
                        right = num;
                    }
                }
            }
        }

        return answer;
    }

    //x 값의 경우 3으로 나누었을 때 1,2,0으로 오류 케이스가 있어 나머지가 0인 경우 3으로 바꿔주었다.
    public int getLength(int startNum, int targetNum) {
        int startX = (startNum % 3) == 0 ? 3 : (startNum % 3);
        int startY = (startNum - 1)/3;
        int tartgetX = (targetNum % 3) == 0 ? 3 : (targetNum % 3);
        int targetY = (targetNum - 1)/3;

        return Math.abs(startX - tartgetX) + Math.abs(startY - targetY);
    }
}
