/*Написать метод, определяющую правильность расстановки скобок в выражении.
 Могут содержаться следующие скобки: ()[]{}<>
 () -> true
 []{}((<>)) -> true
 ) -> false
 [) -> false
 []{}(<)> -> false
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class task_1 {
    public static void main(String[] args) {
        System.out.println(isCorrectParentheses("()"));
        System.out.println(isCorrectParentheses("[]{}((<>))"));
        System.out.println(isCorrectParentheses(")"));
        System.out.println(isCorrectParentheses("[)"));
        System.out.println(isCorrectParentheses("[]{}(<)>"));
    }
    private static boolean isCorrectParentheses(String parentheses) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put('>', '<');

        Deque<Character> stack = new LinkedList<>();
        for (char c : parentheses.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}