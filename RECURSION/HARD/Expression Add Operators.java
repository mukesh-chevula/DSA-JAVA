class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num,target,0,0,0,"",res);
        return res;
    }
    public void helper(String num,int target, int index, long resSofar, long prevNum, String curStr,List<String> res){
        if(index>=num.length()){
            if(resSofar==target){
                res.add(curStr);
            }
            return;
        }
        if(resSofar>target) return;

        for(int i=index;i<num.length();i++){
            if(i>index && num.charAt(i)=='0') break;
            long curNum=Long.parseLong(num.substring(index,i+1));
            if(index==0) helper(num,target,i+1,curNum,curNum,curStr+curNum,res);
            else{
                helper(num,target,i+1,resSofar+curNum,curNum,curStr+'+'+curNum,res);
                helper(num,target,i+1,resSofar-curNum,curNum,curStr+'-'+curNum,res);
                helper(num,target,i+1,resSofar-prevNum+prevNum*curNum,prevNum*curNum,curStr+'*'+curNum,res);
            }

        }

    }
}