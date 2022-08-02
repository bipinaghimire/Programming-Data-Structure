

// public class Question5{
    
//     // to check whether the words of given word is present in the given array or not
//     static boolean contains(String s, char charAt) {
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)==charAt){
//                 // System.out.print("/n"+s.charAt(i));
//                 return true;              
//             }
//         }       
//         return false;
//     }
    
//     // Iterate over the characters of a string
//     public static void main(String[] args)
//     {        
//         String s = "frog";
//         String[] array = {"Programming","for", "developers", "abcd" };
//         boolean travesed[] = new boolean[s.length()];

//         String sum="";
//         int count =0;
//         for(int i=0;i<s.length();i++){
//             // convert string to `char[]` array
//             for(int j=0;j<array[i].length();j++){
//                 if(contains(s,array[i].charAt(j))){
//                         sum+=array[i].charAt(j);
                        
//                         if(!travesed[i]){
//                             travesed[i]=true;
//                             count++;
//                         }         
//                 } 
//             }          
//         }
//         System.out.print(sum+" is the end result");
//         System.out.println("\n"+count); 
// }
// }

public class test{
    // public static void findLengthOfSubset(String tar, String[] a) {
    //     String travesed = "";

    //     int ans = 0;

    //     for (int i = 0; i < tar.length(); i++) {
    //         for (int j = 0; j < a.length; j++) {
    //             for (int k = 0; k < a[j].length(); k++) {
    //                 if (tar.toUpperCase().charAt(i) == a[j].toUpperCase().charAt(k)
    //                         && !travesed.contains(tar.charAt(i) + "")) {
    //                     travesed += tar.charAt(i);

    //                     if (ans <= j + 1) {
    //                         ans++;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     System.out.println(ans);
    //     System.out.println(travesed);
    // }

    public static void main(String[] args) {
        String tar = "frog";
        String[] a = { "programming", "For", "developers" };
        // findLengthOfSubset(tar, a);
        String travesed = "";

        int ans = 0;

        for (int i = 0; i < tar.length(); i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[j].length(); k++) {
                    if (tar.toUpperCase().charAt(i) == a[j].toUpperCase().charAt(k)
                            && !travesed.contains(tar.charAt(i) + "")) {
                        travesed += tar.charAt(i);

                        if (ans <= j + 1) {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        System.out.println(travesed);
    }
}
