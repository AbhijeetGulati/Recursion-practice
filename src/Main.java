import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
     ArrayList<Integer> list=new ArrayList<>();
     int[] arr={1,2,1};

     helper(0,2,0,arr,3,list);
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
    //fibonacci number
    public static int fib(int n){
        //base case
        if(n<=1){
            return n;
        }

        return fib(n-1)+fib(n-2);
    }
    //print all subsequences
    public static void helper(int i,int target,int sum,int[] arr,int n,ArrayList<Integer> list){
        //base case
        if(i==n){
            if(sum==target){
                //reqd subsequence found
                for(int j:list){
                    System.out.print(j+" ");
                }
                System.out.println();
                return;
            }
        }
        //pick
        list.add(arr[i]);
        sum+=arr[i];
        //move ahead

            helper(i + 1, target, sum, arr, n, list);

        //not pick
        list.remove(arr[i]);
        sum-=arr[i];
            helper(i + 1, target, sum, arr, n, list);

    }
    //subsets
    public List<List<Integer>> subsets(int[] nums) {
     //we have to return all the subsequences
        List<List<Integer>> outer=new ArrayList<>();
        //inner list to store the subsequence
         //call pour helper function
        helperSub(0,outer,new ArrayList<>(),nums);
      return outer;
    }

    public void helperSub(int i,List<List<Integer>> outer,List<Integer> inner,int[] nums){

        //base case
        int n=nums.length;
        if(i==n){
            //we neede to stop
            //add current list to final list
            outer.add(new ArrayList<>(inner));
            return;
        }
        //pick
        inner.add(nums[i]);
        //move ahead
        helperSub(i+1,outer,inner,nums);
        //not pick
        inner.remove(inner.size()-1);
        //move ahead
        helperSub(i+1,outer,inner,nums);
    }

    //count all subsequences whose sum=K
    public int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        //need helper function
      return helpCount(0,arr.length,0,sum,arr);
    }
    public int helpCount(int i,int n,int sum,int k,int[] arr){
        //base case
        //return 1 if reqd subsequence found else return 1
        if(i==n){
            if(sum==k){
                return 1;
            }
            else {
                return 0;
            }
        }
        //pick and not pick
        sum+=arr[i];
        //move to next index
        int p=helpCount(i+1,n,sum,k,arr);
        //not pick
        sum-=arr[i];
        int np=helpCount(i+1,n,sum,k,arr);
        return p+np;
    }
}