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
        if(!map[slot].key.equals(key)){
            return null;
        }

        Patient toBeDeleted = map[slot].value;
        // Set the stored value to null
        map[slot].value = null;
        // Return the copy of the stored value
        return toBeDeleted;
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
        if(map[slot].key.equals(key))
            return map[slot].value;
        else{
            return null;
        }
    }

    /**
     * Associates the specified patient with the specified key in the hash map.
     * If the key is not already associated with a patient in the hash map, the patient
     * is added and null is returned. If the key is already associated with a patient,
     * the value associated with the key is replaced by the new patient, and the old patient
     * is returned.
     *
     * @param key the key with which the specified patient is to be associated
     * @param value the patient to be associated with the specified key
     * @return the previous patient associated with the specified key, or null if the key
     * was not already associated with a patient
     * @throws SlotOccupiedException if the key does not match the key found in the calculated slot
     */
    public Patient put(String key, Patient value){
        int slot = calcSlot(key);
        if(map[slot] == null){
            Entry newEntry = new Entry(key, value);
            map[slot] = newEntry;
            count++;
            return null;
        }else if(map[slot].key.equals(key)){
            Patient oldValue = map[slot].value;
            map[slot].value = value;
            return oldValue;
        }
        throw new SlotOccupiedException("Supplied key does not match key found in calculated slot");
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
