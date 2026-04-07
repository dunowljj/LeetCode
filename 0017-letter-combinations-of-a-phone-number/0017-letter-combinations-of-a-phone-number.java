import java.util.*;

class Solution {

    String[] digitMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        dfs(0, 0, digits, new StringBuilder(), answer);
        return answer;
    }

    public void dfs(int depth, int start, String digits, StringBuilder temp, List<String> answer) {
        if (depth == digits.length()) {
            answer.add(temp.toString());
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            int now = digits.charAt(depth) - '0';
            String cand = digitMap[now];

            for (int j = 0; j < cand.length(); j++) {
                temp.append(cand.charAt(j));
                dfs(depth + 1, i + 1, digits, temp, answer);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
/**
digits=2
 */