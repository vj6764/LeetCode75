class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for(int i=length-1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}
