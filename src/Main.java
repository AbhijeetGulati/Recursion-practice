import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

    //COMBINATION SUM
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> outer=new ArrayList<>();
        helperCombo();
    }
    public void helperCombo(int i,int target,int[] candidates,List<Integer> inner,List<List<Integer>> outer){
        //base case
           if(i==candidates.length){
            if(target==0) {
                //reqd subsequence
                //add inner list to outer this is our ans
                outer.add(new ArrayList<>(inner));
            }else{
                return;
            }
        }//base case done

        //pick


            //pick it
        if(candidates[i]<=target) {
            inner.add(candidates[i]);

            helperCombo(i, target - candidates[i], candidates, inner, outer);
        }
        //not pick
        inner.remove(candidates[i]);
        helperCombo(i+1,target,candidates,inner,outer);
    }

    //combination sum2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //sort array
        Arrays.sort(candidates);
      List<List<Integer>> outer=new ArrayList<>();
      //recursion call
        helpCombo2(0,target,candidates,outer,new ArrayList<>());
        return outer;
    }
    public void helpCombo2(int ind,int target,int[] candidates,List<List<Integer>> outer,List<Integer> inner){
        int n=candidates.length;
        //base case
        if(target==0){
            //add current list to outer list and return
            outer.add(new ArrayList<>(inner));
            return;
        }
        for(int i=ind;i<n;i++){
           //avoid duplicates
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;//we have checked correct index and now if next element is same as current element we wont take it
            }
            if(candidates[i]>target){
                break;
            }
            //pick
            inner.add(candidates[i]);
            helpCombo2(i+1,target-candidates[i],candidates,outer,inner);
            inner.remove(inner.size()-1);//not pick
        }

    }

    //subsets 2
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> set=new HashSet<>();
        helpSet(0,set,new ArrayList<>(),nums);
        List<List<Integer>> outer=new ArrayList<>(set);
        return outer;
    }
    public void helpSet(int ind,HashSet<List<Integer>> set,List<Integer> inner,int[] nums){
        //base case
        if(ind==nums.length){
            set.add(new ArrayList<>(inner));
            return;
        }
        //pick and not pick
        //pick
        inner.add(nums[ind]);
        helpSet(ind+1,set,inner,nums);
        //not pick
        inner.remove(inner.size()-1);
        helpSet(ind+1,set,inner,nums);
    }

    //subset 1
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans=new ArrayList<>();//to store sums of all subsets
        sumHelper(0,0,arr,ans);
        return ans;
    }
    public void sumHelper(int ind,int sum,ArrayList<Integer> arr,ArrayList<Integer> ans){
        //base case
        if(ind==arr.size()){
            //put sum in ans
            ans.add(sum);
            return;
        }

        //pick and not pick
        //pick

        sumHelper(ind+1,sum+arr.get(ind),arr,ans);
        //not pick

        sumHelper(ind+1,sum,arr,ans);

    }

    //generate paranthesis
    public List<String> generateParenthesis(int n) {
    List<String> ans=new ArrayList<>();

    }
   //permutations
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
     List<List<Integer>> outer=new ArrayList<>();
     boolean[] check=new boolean[n];
     Arrays.fill(check,false);
     permuteHelp(nums,new ArrayList<>(),outer,check);
     return outer;
    }
    public void permuteHelp(int[] nums,List<Integer> inner,List<List<Integer>> outer,boolean[] check){
        int n=nums.length;
        //base case
        if(inner.size()==n){
            //add inner arraylist to outer list and return
            outer.add(new ArrayList<>(inner));
            return;
        }
        //traverse entire nums array and then pick a value which isnt marked
        for(int i=0;i<n;i++){
            if(check[i]!=true){
                //can select it
                inner.add(nums[i]);
                //mark in boolean array
                check[i]=true;
                permuteHelp(nums,inner,outer,check);
                //now backtrack and remove from inner array and uncheck it in check array
                inner.remove(inner.size()-1);
                check[i]=false;//while backtracking
            }
        }

    }

    //approach 2
    //optimal way without using extra space for boolean array
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> outer=new ArrayList<>();
      permuteHelp2(0,nums,outer);
     return outer;
    }
    public void permuteHelp2(int ind,int[] nums,List<List<Integer>> outer){
        int n=nums.length;
        //base case
        if(ind==n){
            ArrayList<Integer> inner=new ArrayList<>();
            //add elements in inner list
            for(int i=0;i<n;i++){
                inner.add(nums[i]);
            }
            outer.add(new ArrayList<>(inner));
            return;
        }
        for(int i=ind;i<n;i++){
            //swap a[ind] and a[i]
            int temp=nums[ind];
            nums[ind]=nums[i];
            nums[i]=temp;
            permuteHelp2(ind+1,nums,outer);
            //swap again
            //backtracking
             int temp2=nums[ind];
            nums[ind]=nums[i];
            nums[i]=temp2;
        }
        //now move recursion ahead

    }
    }//main function
