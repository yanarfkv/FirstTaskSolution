package tasks.first;
import java.util.ArrayDeque;

public class FirstTaskSolution implements FirstTask {
    Main main = new Main();

    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(startIndex);
        String strings = Integer.toString(startIndex);
        while (!arrayDeque.isEmpty()) {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[arrayDeque.getFirst()][i] && !strings.contains(Integer.toString(i))) {
                    strings += Integer.toString(i);
                    arrayDeque.addLast(i);
                }
            }
            arrayDeque.removeFirst();
        }
        return strings;
    }

    @Override
    public Boolean validateBrackets(String s) {
        String openingBraces = "([{";
        String closingBraces = ")]}";
        char[] input = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : input) {
            if (openingBraces.contains(c.toString())) {
                stack.add(c);
            } else if (closingBraces.contains(c.toString())){
                if (stack.isEmpty()){
                    return false;
                } else if (closingBraces.indexOf(c) == openingBraces.indexOf(stack.peekLast())){
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }

    @Override
    public Long polishCalculation(String s) {
        ArrayDeque<Long> stack = new ArrayDeque<>();
        String[] strings = s.split(" ");
        for (String string : strings) {
            if (main.isNumber(string)) {
                stack.push(Long.parseLong(string));
            } else {
                long num1 = stack.pop();
                long num2 = stack.pop();
                switch (string) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                }
            }
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        else return null;
    }
}
