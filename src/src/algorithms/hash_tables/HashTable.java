package hash_tables;

public class HashTable {
    public class KVP {
        String K;
        Integer V;

        public KVP(String key, Integer value){
            this.K = key;
            this.V = value;
        }

        public String getKey() {
            return K;
        }

        public Integer getValue() {
            return V;
        }
    }

    enum Resize {
        INCREASE,
        DECREASE
    }
    
    private final int originalSize = 10;
    private float LOAD_FACTOR_THRESHOLD_UPPER_BOUND = 0.7f;
    private float LOAD_FACTOR_THRESHOLD_LOWER_BOUND = 0.4f;
    private int UNAVAILABLE_SLOTS = 0;

    private KVP[] table;

    public HashTable() {
        table = new KVP[originalSize]; // all entries are null
    }

    public KVP search(String key) {
        // calculate index using the hash function
        int searchIndex = calculateHashValue(key, table.length);

        // if the value is null, meas it's not there, return null
        if(table[searchIndex] == null) {
            return null;
        }
        // otherwise, it's there, return the pair
        else {
            return table[searchIndex];
        }
    }

    public void insert(String key, Integer value) {
        float loadFactor = calculateLoadFactor();

        if(loadFactor >= LOAD_FACTOR_THRESHOLD_UPPER_BOUND) {
            resize(Resize.INCREASE);
        }

        // add new pair to the table and update the number of occupied slots
        KVP newPair = new KVP(key, value);
        table[calculateHashValue(key, table.length)] = newPair;
        UNAVAILABLE_SLOTS++;
    }

    public boolean delete(String key) {
        int keyHashValue = calculateHashValue(key, table.length);
        
        // if the key is not stored, return false
        if(table[keyHashValue] == null) {
            return false;
        }

        // otherwise, delete it and update the number of occupied slots
        table[keyHashValue] = null;
        UNAVAILABLE_SLOTS--;

        float loadFactor = calculateLoadFactor();

        if(loadFactor < LOAD_FACTOR_THRESHOLD_LOWER_BOUND && table.length/2 >= originalSize) {
            resize(Resize.DECREASE);
        }

        return true;
    }

    private void resize(Resize type) {
        KVP[] newTable;

        if(type == Resize.INCREASE) {
            newTable = new KVP[table.length * 2];
        } else {
            newTable = new KVP[table.length / 2];
        }
        
        // no need to copy the null entries :)
        for(KVP p: table) {
            if(p != null) {
                int newHashValue = calculateHashValue(p.getKey(), newTable.length);
                newTable[newHashValue] = p; 
            }
        }

        table = newTable;
    }

    private float calculateLoadFactor() {
        return UNAVAILABLE_SLOTS/(float)table.length;
    }

    private int calculateHashValue(String key, int size) {
        return HashFunctions.divisionMethod(HashFunctions.polynomialRolling(key), size);
    }

    public int getTableSize() {
        return table.length;
    }

    public int getOccupiedSlots() {
        return UNAVAILABLE_SLOTS;
    }

}
