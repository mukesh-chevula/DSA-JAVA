public class Solution {
    public void generateStringPermutaions(String str,String current,List<String> result) {
        if (str.length()==0) {
            result.add(current);
            return;
        }
        for (int i=0;i<str.length();i++) {
            char ch=str.charAt(i);
            String remaining=str.substring(0,i)+str.substring(i+1);
            generateStringPermutaions(remaining,current+ch,result);
        }
    }

    public void generateArrayPermutations(int[] arr,int index,List<List<Integer>> result) {
        if (index==arr.length) {
            List<Integer> currentPermutation=new ArrayList<>();
            for (int num:arr) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }
        for (int i=index;i<arr.length;i++) {
            swap(arr,i,index);
            generateArrayPermutations(arr,index+1,result);
            swap(arr,i,index); 
        }
    }
    private void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}