//Approach : Optimal
// Time & Space Complexity
// Time complexity: O(n*logn)
// Space complexity: O(n)

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len=position.length;
        int[][] pairs=new int[len][2];
        for(int i=0;i<len;i++)
        {
           pairs[i][0]=position[i];
           pairs[i][1]=speed[i];
        }
        Arrays.sort(pairs,(a,b)->b[0]-a[0]); //sort in descending order based on positions
        //or
        //Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack=new Stack<>();
        for(int[] pair:pairs)
        {
            double time=(double)(target-pair[0])/pair[1];
            stack.push(time);
            if(stack.size()>=2 && stack.peek()<=stack.get(stack.size()-2))
            {
                stack.pop();
            }
        }
        return stack.size();
    }
}


