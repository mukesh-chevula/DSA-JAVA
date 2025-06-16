class Solution {
    public static void printSubStrings(String s) {
        _printSubStrings(s,0,0);
    }

    private static void _printSubStrings(String s,int start,int end) {
        if (start==s.length()) {
            return;
        }
        if (end==s.length()) {
            _printSubStrings(s,start+1,start+1);
        } else {
            System.out.println(s.substring(start,end+1));
            _printSubStrings(s,start,end+1);
        }
    }

    public static void printSubArrays(int[] arr) {
        _printSubArrays(arr,0,0);
    }

    private static void _printSubArrays(int[] arr,int start,int end) {
        if (start==arr.length) {
            return;
        }
        if (end==arr.length) {
            _printSubArrays(arr,start+1,start+1);
        } else {
            for (int i=start;i<=end;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            _printSubArrays(arr,start,end+1);
        }
    }
}
