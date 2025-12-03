//Input: ["neet","code","love","you"]
// Output:["neet","code","love","you"]


// Input: ["we","say",":","yes"]
// Output: ["we","say",":","yes"]





// Approach:

//  Encoding & Decoding (Optimal)


// Intuition
// Instead of storing all string lengths first and then appending the strings, we can directly attach each string to its length.
// For every string, we write length#string.
// The # character acts as a clear boundary between the length and the actual content, and using the length ensures we know exactly how many characters to read—no matter what characters appear in the string itself.
// During decoding, we simply read characters until we reach # to find the length, then extract exactly that many characters as the string.
// This approach is both simpler and more efficient because it avoids building separate sections for lengths and content.

// Algorithm

// Encoding
// Initialize an empty result string.
// For each string in the list:
// Compute its length.
// Append "length#string" to the result.
// Return the final encoded string.



// Decoding

// Initialize an empty list for the decoded strings and a pointer i = 0.
// While i is within the bounds of the encoded string:
// Move a pointer j forward until it finds '#' — this segment represents the length.
// Convert the substring s[i:j] into an integer length.
// Move i to the character right after '#'.
// Extract the next length characters — this is the original string.
// Append the extracted string to the result list.
// Move i forward by length to continue decoding the next segment.
// Return the list of decoded strings.


import java.util.*;
class Main {
    
    public static String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();
        for(String s:strs)
        {
        res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }

   
    public static List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        int i=0;
        while(i<str.length())
        {
            int j=i;
            while(str.charAt(j)!='#')
            {
                j+=1;
            }
            int length=Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+length;
            res.add(str.substring(i,j));
            i=j;
        }
        return res;
    }
    public static void main(String[] args) {        
        //      Input: ["neet","code","love","you"]

// Output:["neet","code","love","you"]


// Input: ["we","say",":","yes"]

// Output: ["we","say",":","yes"]

List<String> input1 = new ArrayList<>(List.of("neet", "code", "love", "you"));
        String encodedString =encode(input1);
        System.out.println("encoded String is "+encodedString);
        List<String>output1=decode(encodedString);
        System.out.println("decoded String is ");
        for(String s:output1)
        {
            System.out.print(s+" ,");
        }
        System.out.println();
        
        
        
        List<String> input2 = new ArrayList<>(List.of("we", "say", ":", "yes"));
        String encodedString2 =encode(input2);
        System.out.println("encoded String is "+encodedString2);
        List<String>output2=decode(encodedString2);
        System.out.println("decoded String is ");
        for(String s:output2)
        {
            System.out.print(s+" ,");
        }
        System.out.println();
    }
}



// Output:
// encoded String is 4#neet4#code4#love3#you
// decoded String is 
// neet ,code ,love ,you ,
// encoded String is 2#we3#say1#:3#yes
// decoded String is 
// we ,say ,: ,yes ,




// Time & Space Complexity
// Time complexity: O(m) for each encode() and decode() function calls.
// Space complexity: O(m+n) for each encode() and decode() function calls.
// Where m is the sum of lengths of all the strings and n is the number of strings.