class Solution {
    public double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        
        Item[] items = new Item[n];
        
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        
        Arrays.sort(items, (a, b) -> Double.compare(b.valuePerWeight(), a.valuePerWeight()));

        double totalValue = 0;
        
        for (Item item : items) {
            if (W == 0) break;
            
            if (W >= item.weight) {
                totalValue += item.value;
                W -= item.weight;
            } else {
                totalValue += item.valuePerWeight() * W;
                W = 0;
            }
        }
        
        return totalValue;
    }

    class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        double valuePerWeight() {
            return (double) value / weight;
        }
    }
}