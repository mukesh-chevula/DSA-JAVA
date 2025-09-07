class Solution {
    class TrieNode {
        TrieNode[] refs = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    private TrieNode root = new TrieNode();

    private void insert(String product) {
        TrieNode cur = root;
        for (char c : product.toCharArray()) {
            int idx = c - 'a';
            if (cur.refs[idx] == null) {
                cur.refs[idx] = new TrieNode();
            }
            cur = cur.refs[idx];

            if (cur.suggestions.size() < 3) {
                cur.suggestions.add(product);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        for (String s:products) insert(s);

        List<List<String>> res=new ArrayList<>();
        TrieNode cur=root;
        for(char c:searchWord.toCharArray()){
            if(cur!=null){
                cur=cur.refs[c-'a'];
            }

            if(cur==null) res.add(new ArrayList<>());
            else res.add(cur.suggestions);
        }
        return res;
    }
}