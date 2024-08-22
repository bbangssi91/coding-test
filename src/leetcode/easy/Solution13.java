package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {

    static Map<String, Integer> romanNum = new HashMap<>();

    public static void main(String[] args) {
        Solution13 solve = new Solution13();
        System.out.println(solve.romanToInt("MCMXCIV")); // 1994

    }

    private void initializeRomanNum() {
        romanNum.put("I", 1);
        romanNum.put("V", 5);
        romanNum.put("X", 10);
        romanNum.put("L", 50);
        romanNum.put("C", 100);
        romanNum.put("D", 500);
        romanNum.put("M", 1000);
    }

    public int romanToInt(String s) {
        int resultNum = 0;
        initializeRomanNum();
        // search from backward
        for(int i = s.length() - 1; i >= 0; i--) {

            Integer numValue = romanNum.get(String.valueOf(s.charAt(i)));

            if(i == s.length() -1) {
                resultNum += numValue;
                continue;
            }

            Integer prevNumValue = romanNum.get(String.valueOf(s.charAt(i+1)));

            if(numValue < prevNumValue) {
                resultNum -= numValue;
            }else {
                resultNum += numValue;
            }

        }

        return resultNum;

    }

}
