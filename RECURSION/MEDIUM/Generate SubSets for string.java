public class GenerateSubsets {
    public static void main(String[] args) {
        String str = "abc";
        List<String> subsets = new ArrayList<>();
        generateSubsets(str, 0, "", subsets);
        System.out.println(subsets);
    }

    public static void generateSubsets(String str, int index, String current, List<String> subsets) {
        if (index == str.length()) {
            subsets.add(current);
            return;
        }

        generateSubsets(str, index + 1, current, subsets);

        generateSubsets(str, index + 1, current + str.charAt(index), subsets);
    }
}
