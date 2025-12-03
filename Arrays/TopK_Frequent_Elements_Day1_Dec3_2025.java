

// Approach1: Create Frequency map pair [Frequency , Number] , sort using frequency 
// Time & Space Complexity
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<int[]> list1=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            list1.add(new int[]{entry.getValue(),entry.getKey()});
        }

        list1.sort((a,b)->b[0]-a[0]);

        int[] res=new int[k];
        for(int i=0;i<k;i++)
        {
            res[i]=list1.get(i)[1];
        }
        return res;

    }
}



//Approach2: MinHeap
// Time & Space Complexity
// Time complexity: O(nlogk)
// Space complexity: O(n+k)
Where n is the length of the array and k is the number of top frequent elements.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(new int[] { entry.getValue(), entry.getKey() });
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;

    }
}



//Approach3: Bucket Sort
// Time & Space Complexity
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        List<List<Integer>> freqArray = new ArrayList<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 0; i < size + 1; i++) {
            freqArray.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freqArray.get(entry.getValue()).add(entry.getKey());
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = size; i > 0 && index < k; i--) {
            for (int j : freqArray.get(i)) {
                res[index] = j;
                index++;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;

    }
}
