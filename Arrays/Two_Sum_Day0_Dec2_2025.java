class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int n=nums[i];
            int secondNumber=target-n;
            if(map.containsKey(secondNumber))
            {
               res[0]=i;
               res[1]=map.get(secondNumber);
               return res;
            }
            else
            {
                map.put(n,i);
            }
        }
         return res;
    }
}