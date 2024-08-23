package leetcode.easy;

public class Solution58 {

    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        solution58.lengthOfLastWord("   fly me   to   the moon  ");
    }

    public int lengthOfLastWord(String s) {
        String[] trimmedStr = s.trim().split(" ");
        return trimmedStr[trimmedStr.length - 1].length();
    }
}
