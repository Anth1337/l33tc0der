class ArrayDups {
    public boolean hasDuplicate(int[] nums) {
        // Loop through each element
        for (int i = 0; i < nums.length; i++) {
            // Compare it with every other element after it
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Found a duplicate
                }
            }
        }
        return false; // No duplicates found
    }
}
