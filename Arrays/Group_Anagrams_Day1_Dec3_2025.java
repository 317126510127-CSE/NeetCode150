//Approach1: Sorting 
// Time complexity: O(n∗klogk)
// Space complexity: O(n∗k)
// Where n is the number of strings and k is the length of the longest string.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs)
        {
            //System.out.println(s);
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String sortedString=new String(chars);
            // if(map.containsKey(sortedString))
            // {
            //     List<String> temp=map.get(sortedString);
            //     temp.add(s);
            //     map.put(sortedString,temp);
            // }
            // else{
            //     //map.put(sortedString,new ArrayList<>().add(sortedString));
            //     map.put(sortedString, new ArrayList<>(List.of(sortedString)));
            //     // map.putIfAbsent(sortedString, new ArrayList<>());
            //     // map.get(sortedString).add(word);

            // }
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);

        }
        //res.addAll(map.values());
        // TC:O(nklogk)
        return new ArrayList<>(map.values());
    }
}





//Approach2: Using Frequency Map for Characters (HashTable)
// Time complexity: O(n∗k)
// Space complexity: 
//O(n) extra space.
//O(n∗k) space for the output list.
//Where n is the number of strings and k is the length of the longest string.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //     //System.out.println(s);
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }
            // String key=Arrays.toString(freq);
            // System.out.println(key);
            StringBuilder sb = new StringBuilder();
            for (int f : freq) {
                sb.append(f).append('#'); // very compact, efficient
            }
            String key = sb.toString();
            //System.out.println(key);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}