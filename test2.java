import java.util.HashMap;

public class test2{
    static void printSubArrays(int[] arr, int start, int end, HashMap<Integer, Integer> checkContains, int length)
    {
        // Stop if we have reached the end of the array
        if (end == arr.length)
            return;
        // Increment the end point and start from 0
        else if (start > end)
            printSubArrays(arr, 0, end + 1, checkContains, length);
        // Print the subarray and increment the starting
        // point
        else {       
                if((end - start + 1) ==length){

                    int[] subArray = new int[length];
                    int count=0;
            
                    for (int i = start; i <= end; i++){
                        subArray[count++] = arr[i];
                    }

                    boolean exists = checkTrue(checkContains, subArray);
                    if(exists){
                        System.out.println(" ");
                        for (int i = 0; i < subArray.length; i++){
                            System.out.print(subArray[i] + ", ");
                        }
                        System.out.println();
                    }
                }

                printSubArrays(arr, start + 1, end, checkContains, length);

        }
        
        return;
    }

    public static boolean checkTrue(HashMap<Integer, Integer> checkContains, int[] subset){
        boolean isFound = false;
        

        for(int i = 0; i<subset.length ; i ++){
            int product=subset[i];
            
            for(int j =i+1; j <subset.length; j++){
                product *=  subset[j];
                if(product==10){
                    isFound = checkContains.containsKey(product);
                }
            }
        }


        return isFound;
    }
 
    public static void main(String args[])
    {
        int[] arr = {10,10,5,0,2,1,2,5};
        int length = 3;
        HashMap<Integer, Integer> checkContains = new HashMap<>();
        for(int i: arr){
            checkContains.put(i, 1);
        }
        printSubArrays(arr, 0, 0, checkContains, length);
    }
}

//this is ttoo funny algorthim
//Algorithm
// Create a map mp[] of size 26 and initialize it with -1.
// Create a used[] array of size 10 and initialize it with 0.
// Create a Hash[] array of size 26 and initialize it with 0.
// Create a CharAtfront[] array of size 26 and initialize it with 0.
// Create a StringBuilder object, uniq.
// Iterate over the array, words.
// Iterate over the string, word.
// Store the character at ith position in ch.
// Update Hash[ch-'A'].
// If mp[ch-'A'] is -1, then update mp[ch-'A'] with 0 and append ch to uniq. 
// If i is 0 and word length is greater than 1, then update CharAtfront[ch-'A'] with 1.
// Iterate over the string, result.
// Store the character at ith position in ch.
// Update Hash[ch-'A'].
// If mp[ch-'A] is -1, then update mp[ch-'A'] with 0 and append ch to uniq.
// If i is 0 and length of result is greater than 1, then update CharAtfront[ch-'A'] with 1.
// Initialize mp[] with -1.
// Call the function solve() with arguments words, 0, 0, mp, used, Hash, CharAtfront.
// If i is word.length, then return true if S is 0, else return false.
// Store the character at index i in ch.
// Store the mapped value of ch in val.
// If val is -1, then return solve() with arguments words, i+1, S+val*Hash[ch-'A'], mp, used, Hash, CharAtfront.
// Initialize x with false.
// Iterate over the range 0 to 9.
// If CharAtfront[ch-'A'] is true and l is 0, then continue.
// If used[l] is true, then continue.
// Assign l to ch.
// Marked l as used.
// Update x with solve() with arguments words, i+1, S+l*Hash[ch-'A'], mp, used, Hash, CharAtfront.
// Backtrack.
// Update mp[ch-'A'] with -1.
// Unset used[l].
// Return the value of x.

// public class test2{
//     public static void main(String[] args) {
//         String s="";
//         for(int i=0; i<5; i++){
//             System.out.print(i);
//             s = String.valueOf(i);
            
//         }
//         System.out.print("\n"+"strfghg"+s);
        
//     }
// }