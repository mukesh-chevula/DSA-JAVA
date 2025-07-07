/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> idtoemp= new HashMap<>();
        for(Employee e: employees){
            idtoemp.put(e.id,e);
        }
        Employee cur = idtoemp.getOrDefault(id, null);
        int res=0;
        if (cur == null) return res;
        Queue<Employee> q=new LinkedList<>();
        q.add(cur);
        Set<Employee> visited=new HashSet<>();
        while(!q.isEmpty()){
            Employee e=q.poll();
            res+=e.importance;
            visited.add(e);
            for(Integer i:e.subordinates){
                Employee sub=idtoemp.get(i);
                if(!visited.contains(sub)) q.add(sub);
            }
        }
        return res;
    }
}