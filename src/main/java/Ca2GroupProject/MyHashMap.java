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


    /**
     * Removes the patient associated with the specified key from the hash map.
     * If the key is found in the hash map, the corresponding patient is removed
     * and returned. If the key is not found, returns null.
     *
     * @param key the key of the patient to be removed from the hash map
     * @return the patient associated with the specified key, or null if the key is not found
     */
    public Patient remove(String key){
        int slot = calcSlot(key);
        if(map[slot] == null){
            return null;
        }
        Entry current = map[slot];
        Entry previous = null;
        while(current != null){
            if(current.key.equals(key)){
                // Found the entry to be removed
                if(previous != null){
                    previous.next = current.next;
                }else{
                    // This is the first entry in the chain
                    map[slot] = current.next;
                }
                count--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    /**
     * Retrieves the patient associated with the specified key from the hash map.
     * If the key is found in the hash map, the corresponding patient is returned.
     * If the key is not found, returns null.
     *
     * @param key the key of the patient to be retrieved from the hash map
     * @return the patient associated with the specified key, or null if the key is not found
     */
    public Patient get(String key){
        int slot = calcSlot(key);
        if(map[slot] == null){
            return null;
        }
        Entry current = map[slot];
        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
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
