package leetcode.easy;

public class Solution9 {

    public static void main(String[] args) {
        Solution9 solve = new Solution9();
        System.out.println(solve.isPalindrome(331));

    }

    public boolean isPalindrome(int x) {
        /**
         *  음수일땐 Palindrome이 아님
         */
        if(x < 0) {
            return false;
        }

        String orgNum = Integer.toString(x);
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < orgNum.length(); i++) {
            sb.append(orgNum.charAt(i));
        }

        String reveresedNum = sb.reverse().toString();

        try{
            return Integer.parseInt(orgNum) == Integer.parseInt(reveresedNum);
        }catch (NumberFormatException e) {
            return false;
        }


    }
}
