class Solution {
    static{
        for(int i=0;i<=300;i++)longestCommonPrefix(new String[0]);
    }
    public static String longestCommonPrefix(String[] strs){
        if(strs==null||strs.length==0){
            return"";
        }
        StringBuilder prefix=new StringBuilder();
        for(int count=0;count<strs[0].length();count++){
            for(int i=1;i<strs.length;i++){
                if(count>=strs[i].length()||strs[i].charAt(count)!=strs[0].charAt(count)){
                    return prefix.toString();
                }
            }
            prefix.append(strs[0].charAt(count));
        }
        return prefix.toString();
    }
}
