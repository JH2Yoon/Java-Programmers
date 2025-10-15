//261. 수식 최대화

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public long solution(String expression) {
        List<Long> numbers = Arrays.stream(expression.split("[^0-9]"))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<String> operators = Arrays.stream(expression.split("[0-9]+"))
                .filter(op -> !op.isEmpty())
                .collect(Collectors.toList());

        List<List<String>> permutations = getPermutations(new ArrayList<>(new HashSet<>(operators)));

        long max = 0;

        for (List<String> order : permutations) {
            long result = Math.abs(evaluate(
                    new ArrayList<>(numbers), new ArrayList<>(operators), order
            ));
            max = Math.max(max, result);
        }

        return max;
    }

    private List<List<String>> getPermutations(List<String> ops) {
        List<List<String>> result = new ArrayList<>();
        permute(ops, 0, result);
        return result;
    }

    private void permute(List<String> ops, int depth, List<List<String>> result) {
        if (depth == ops.size()) {
            result.add(new ArrayList<>(ops));
            return;
        }
        for (int i = depth; i < ops.size(); i++) {
            Collections.swap(ops, i, depth);
            permute(ops, depth + 1, result);
            Collections.swap(ops, i, depth);
        }
    }

    private long evaluate(List<Long> nums, List<String> ops, List<String> order) {
        for (String op : order) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i).equals(op)) {
                    long res = operate(nums.get(i), nums.get(i + 1), op);
                    nums.remove(i + 1);
                    nums.set(i, res);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }
        return nums.get(0);
    }

    private long operate(long a, long b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}