package hash_tables;

public class HashTable {

    public class KVP {
        String KEY;
        Integer VALUE;
        KVP kid;
        KVP parent;

        public KVP(String key, Integer value){
            this.KEY = key;
            this.VALUE = value;
        }

        public String getKey() {
            return KEY;
        }

        public Integer getValue() {
            return VALUE;
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

    public boolean insert(String key, Integer value) {
        KVP alreadyHere = search(key);

        if(alreadyHere != null) {
            return false;
        }

        UNAVAILABLE_SLOTS++;

        float loadFactor = calculateLoadFactor();

        if(loadFactor >= LOAD_FACTOR_THRESHOLD_UPPER_BOUND) {
            resize(Resize.INCREASE);
        }

        // add new pair to the table and update the number of occupied slots
        KVP newPair = new KVP(key, value);
        int hashValue = calculateHashValue(key, table.length);

        if(table[hashValue] != null) {
            KVP lastLink = table[hashValue];

            while (lastLink.kid != null) {
                lastLink = lastLink.kid;
            }

            lastLink.kid = newPair;
            newPair.parent = lastLink;
        }
        else {
            newPair.parent = newPair;
            table[hashValue] = newPair;
        }

        return true;
    }

    public KVP search(String key) {
        // calculate index using the hash function
        int searchIndex = calculateHashValue(key, table.length);

        // if the value is null, means it's not there, return null
        if(table[searchIndex] == null) {
            return null;
        }
        // otherwise, it's there, return the pair
        else {
            KVP lastLink = table[searchIndex];

            do {

                if(lastLink.KEY.equals(key)) {
                    return lastLink;
                } 
                else {
                    lastLink = lastLink.kid;
                }

            } while(lastLink != null);

            return null;
        }
    }

    public boolean delete(String key) {
        // otherwise, delete it and update the number of occupied slots
        KVP toBeDeleted = search(key);

        if(toBeDeleted == null) {
            return false;
        }

        UNAVAILABLE_SLOTS--;

        if(toBeDeleted.parent == toBeDeleted) {
            int hashValue = calculateHashValue(key, table.length);
            table[hashValue] = toBeDeleted.kid;
            
            if(table[hashValue] != null) {
                table[hashValue].parent = table[hashValue];
            }
        }
        else {
            toBeDeleted.parent.kid = toBeDeleted.kid;

            if(toBeDeleted.kid != null) {
                toBeDeleted.kid.parent = toBeDeleted.parent;
            }
        }

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
        for(KVP entry: table) {
            if(entry != null) {
                KVP current = entry;

                while (current != null) {
                    KVP copy = new KVP(current.KEY, current.VALUE);
                    int newHashValue = calculateHashValue(copy.KEY, newTable.length);

                    if(newTable[newHashValue] != null) {
                        KVP lastLink = newTable[newHashValue];

                        while (lastLink.kid != null) {
                            lastLink = lastLink.kid;
                        }

                        lastLink.kid = copy;
                        copy.parent = lastLink;
                    }
                    else {
                        copy.parent = copy;
                        newTable[newHashValue] = copy;
                    }

                    current = current.kid;
                }
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

    public void printAllPairs(boolean showEmptyEntries) {
        System.out.println("< =========================================== >");

        for(int i = 0; i < table.length; i++) {
            if(table[i] == null){
                if(showEmptyEntries){
                    System.out.print(i + ". ");
                    System.out.println("EMPTY SLOT");
                }
            }
            else {
                System.out.print(i + ". ");
                KVP slot = table[i];

                do {
                    System.out.print(slot.getKey());
                    slot = slot.kid;

                    if(slot != null){
                        System.out.print(" -> ");
                    }

                } while(slot != null);
                System.out.println();
            }
        }
        System.out.println("< =========================================== >");
    }

}
