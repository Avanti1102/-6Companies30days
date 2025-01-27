class DataStream {
    int value, k;
    int count; // Counter for consecutive occurrences
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.count = 0; // Initialize count to 0
    }

    public boolean consec(int num) {
        if (num == value) {
            count++; // Increment counter if the number matches the target value
        } else {
            count = 0; // Reset counter if the number does not match
        }
        return count >= k; // Return true if the count reaches or exceeds k
    }
}