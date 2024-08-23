package leetcode.easy;

/**
 *  14. Longest Common Prefix
 *
 *
 */
public class Solution14 {

    public static void main(String[] args) {
        Solution14 solve = new Solution14();
        System.out.println(solve.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }


    public String longestCommonPrefix(String[] strs) {

        StringBuffer sb = new StringBuffer();
        int loopCnt = 0;

        while(true) {
            try{
                sb.append(strs[0].charAt(loopCnt));
            }catch (Exception e) {
                return sb.toString();
            }

            for(String str : strs) {
                if(!str.startsWith(sb.toString())) {
                    return sb.deleteCharAt(loopCnt).toString();
                }
            }

            loopCnt++;
        }

    }
}
