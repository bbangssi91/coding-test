package leetcode.easy;

/**
 *  https://leetcode.com/problems/number-complement/?envType=daily-question&envId=2024-08-22
 *
 */
public class Solution476 {

    public static void main(String[] args) {
        Solution476 sol = new Solution476();
        int result = sol.findComplement(4);
        System.out.println(result);
    }

    public int findComplement(int num) {
        String binaryNum = Integer.toBinaryString(num);

        char[] chars = binaryNum.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '0') {
                chars[i] = '1';
            }else {
                chars[i] = '0';
            }
        }

        int isZero = Integer.parseInt(String.valueOf(chars));

        if(isZero == 0) return 0;

        int totalNum = 0;

        for(int i = chars.length-1; i >= 0; i--) {
            if(Integer.parseInt(String.valueOf(chars[i])) % 2 == 1) {
                totalNum += Math.pow(2, chars.length-i-1);
            }
        }

        return totalNum;

    }
}
