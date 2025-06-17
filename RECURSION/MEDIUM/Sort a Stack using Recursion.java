/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if(!s.isEmpty()){
            int temp=s.pop();
            sort(s);
            helper(s,temp);
        }
        return s;
    }
    private void helper(Stack<Integer> s, int element){
        if(s.isEmpty() || s.peek()<=element){
            s.push(element);
        }else{
            int temp=s.pop();
            helper(s,element);
            s.push(temp);
        }
    }
}