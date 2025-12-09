//Approach1 : Bruteforce
class Solution {
    public int[] productExceptSelf(int[] nums) {
           //Approach1: Bruteforce
           int n=nums.length;
           int[] res=new int[n];
           for(int i=0;i<n;i++)
           {
            int product=1;
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    product*=nums[j];
                }
            }
            //System.out.println("product "+product);
            res[i]=product;
           }

        return res;
    }
}

//Approach2: Using Division
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int numberOfZeroes = 0, product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numberOfZeroes += 1;
            } else {
                product *= nums[i];
            }
        }

        if (numberOfZeroes > 1) {
            return res;
        }

        for (int i = 0; i < n; i++) {
            if (numberOfZeroes == 1) {
                // if (nums[i] == 0) {
                //     res[i] = product;
                // } else {
                //     res[i] = 0;
                // }
                res[i]=(nums[i]==0) ? product:0;
            } else {
                res[i] = product / nums[i];
            }
        }

        return res;
    }
}



//Approach3: Using leftPrefix and RightSuffix Product Arrays
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] leftPrefix = new int[len];
        int[] rightSuffix = new int[len];

        if (len == 1)
            return new int[] { 1 };

        leftPrefix[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftPrefix[i] = leftPrefix[i - 1] * nums[i];
        }

        rightSuffix[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightSuffix[i] = rightSuffix[i + 1] * nums[i];
        }

        res[0] = rightSuffix[1];
        res[len - 1] = leftPrefix[len - 2];
        for (int i = 1; i < len - 1; i++) {
            res[i] = leftPrefix[i - 1] * rightSuffix[i + 1];
        }

        return res;
    }
}


//Approach4: Without using extra space except output array
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        if (len == 1)
            return new int[] { 1 };

        res[0] = nums[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i];
        }

        res[len - 1] = res[len - 2];
        int suffix = nums[len - 1];
        for (int i = len - 2; i > 0; i--) {
            res[i] = res[i - 1] * suffix;
            suffix *= nums[i];
        }
        res[0] = suffix;

        return res;
    }
}

