package Ca2GroupProject;



public class MyHashMap {
    // Set up base internal map/array
    // Set up variable to track the number of elements/pairs
    private Entry[] map;
    private int count;

    public MyHashMap(){
        map = new Entry[103];
        count = 0;
    }

    /**
     * Calculates the slot index for the given key based on its hash code.
     * The slot index is determined by taking the absolute value of the hash code
     * of the key and then performing modulo operation with the length of the map array.
     * This ensures that the slot index falls within the bounds of the map array.
     *
     * @param key the key for which the slot index is to be calculated
     * @return the slot index in the map array where the key-value pair should be stored
     */
    private int calcSlot(String key){
        int slot = Math.abs(key.hashCode());
        slot = slot % map.length;
        return slot;
    }





    private static class Entry {
        String key;
        Patient value;
        Entry next;

        Entry(String key, Patient value) {
            this.key = key;
            this.value = value;
        }
    }
}
