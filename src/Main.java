public class Main {
    public static void main(String[] args) {
       String str="MADAM";
       boolean ans=isPalin(0,str);
        System.out.println(ans);
    }
    //n factorial
    public static int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*fact(n-1);
    }

     //check if string is palindrome
    public static boolean isPalin(int i,String s){
        if(i>=s.length()/2){
            return true;
        }
        if(s.charAt(i)!=s.charAt(s.length()-i-1)){
            return false;
        }
        //move ahead
        return isPalin(i+1,s);
    }

    //reversing an array using two pointers
    public static void rev(int l,int r,int[] arr){
        //base case
        if(l>=r){
            return;
        }
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;//swapping done
        //move pointers ahead
        rev(l+1,r-1,arr);
    }

    //using single pointer
    public static void revSingle(int i,int[] arr){
        if(i>=arr.length/2){
            return;//base case
        }
        int temp=arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i]=temp;//swapping done
        //move pointer ahead
        revSingle(i+1,arr);
    }
}