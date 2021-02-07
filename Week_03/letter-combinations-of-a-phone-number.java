// 解题思路：采用回溯算法
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        Map<Character, String> phoneMap = new HashMap<Character, String>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        backtrack(0, digits, phoneMap, res, new StringBuffer());
        return res;
    }

    public void backtrack(
            int index,
            String digits,
            Map<Character, String> phoneMap,
            List<String> res,
            StringBuffer temp) {
        if (index == digits.length()) {
            res.add(temp.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                temp.append(letters.charAt(i));
                backtrack(index + 1, digits, phoneMap, res, temp);
                temp.deleteCharAt(index);
            }
        }
    }
}