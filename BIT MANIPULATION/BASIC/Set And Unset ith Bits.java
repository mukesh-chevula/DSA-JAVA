class Solution {
    // Function to set the ith bit of a number
    static int setIthBit(int num, int i) {
        return num | (1 << i);
    }

    // Function to unset the ith bit of a number
    static int unsetIthBit(int num, int i) {
        return num & ~(1 << i);
    }
}