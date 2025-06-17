class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();

        int n=digits.length();

        if(n==0) return res;

        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        helper(digits,0,new StringBuilder(),res,map);

        return res;

    }
    public void helper(String digits, int index, StringBuilder comb,List<String> res,HashMap<Character,String> map){
        if(index>=digits.length()){
            res.add(comb.toString());
            return;
        }

        String letters=map.get(digits.charAt(index));
        for(char letter:letters.toCharArray()){
            comb.append(letter);
            helper(digits,index+1,comb,res,map);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}