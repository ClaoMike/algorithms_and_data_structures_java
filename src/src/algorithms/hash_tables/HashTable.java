package hash_tables;

public class HashTable {
    
    // object to hold a key value pair, can also be used to create a linked list
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
        // see if it alreadt exist, so you do not add duplicates
        KVP alreadyHere = search(key); 

        if(alreadyHere != null) {
            return false;
        }

        // if it's not a duplicate, then it counts
        UNAVAILABLE_SLOTS++;

        // before adding, see if the table needs to extended, so it does not exceed the maximum load factor - usually 0.7
        float loadFactor = calculateLoadFactor();

        if(loadFactor >= LOAD_FACTOR_THRESHOLD_UPPER_BOUND) {
            resize(Resize.INCREASE);
        }

        // add new pair to the table
        KVP newPair = new KVP(key, value);
        int hashValue = calculateHashValue(key, table.length);

        // if there is a collision, add it to the end of the linked list
        if(table[hashValue] != null) {
            KVP lastLink = table[hashValue];

            // find the last item in list, it does not have any kids
            while (lastLink.kid != null) {
                lastLink = lastLink.kid;
            }

            // attach new item and make it knowledgable about its parent
            lastLink.kid = newPair;
            newPair.parent = lastLink;
        }
        // if there is no collision, then he is the one that becomes the top of a linked list
        else {  
            newPair.parent = newPair; // he is aware that he is the first one, by being its own parent (don't ask questions!)
            table[hashValue] = newPair;
        }

        // let the user know the insertion was successful
        return true;
    }

    public KVP search(String key) {
        // calculate index using the hash function
        int searchIndex = calculateHashValue(key, table.length);

        // if there is nothing in the table at the hash position, then it's not here
        if(table[searchIndex] == null) {
            return null;
        }
        // otherwise, search it through the linked list
        else {
            KVP lastLink = table[searchIndex];

            // there is at least one pair saved at this location, we know that
            do {

                // if keys match, it's a return
                if(lastLink.KEY.equals(key)) {
                    return lastLink;
                } 
                // keep searching through the linked list
                else {
                    lastLink = lastLink.kid;
                }
            // search 'till the end
            } while(lastLink != null);

            // still not found? then it's not here
            return null;
        }
    }

    public boolean delete(String key) {
        // find it
        KVP toBeDeleted = search(key);

        // not here? cannot be deleted then
        if(toBeDeleted == null) {
            return false;
        }

        // at this point, it can be deleted, uncount it
        UNAVAILABLE_SLOTS--;

        // if it's the first one in the linked list, then move its kid in its place
        if(toBeDeleted.parent == toBeDeleted) {
            int hashValue = calculateHashValue(key, table.length);
            table[hashValue] = toBeDeleted.kid;
            
            // there is a slight chance that his kid might be null - happens
            // however, if it's not null, then it's time for hime to become his own parent
            if(table[hashValue] != null) {
                table[hashValue].parent = table[hashValue];
            }
        }
        // if it's not the first one, it could be in the middle of the linked list, let his parent know that he is going somewhere else - Java cemetery
        else {
            toBeDeleted.parent.kid = toBeDeleted.kid;

            // before leaving this realm, let its kids (if any) who their new parent is
            if(toBeDeleted.kid != null) {
                toBeDeleted.kid.parent = toBeDeleted.parent;
            }
        }

        // before leaving, check that the load factor is above the miminum load factor - usuallt 0.4
        float loadFactor = calculateLoadFactor();

        if(loadFactor < LOAD_FACTOR_THRESHOLD_LOWER_BOUND && table.length/2 >= originalSize) {
            resize(Resize.DECREASE);
        }

        // let the user know that the operation was a success
        return true;
    }

    private void resize(Resize type) {
        KVP[] newTable;

        if(type == Resize.INCREASE) {
            newTable = new KVP[table.length * 2];
            // or DECREASE
        } else {
            newTable = new KVP[table.length / 2];
        }
        
        // no need to copy the null entries :)
        for(KVP entry: table) {
            if(entry != null) {

                while (entry != null) {
                    // make a copy, and get it hash value for the new table
                    KVP copy = new KVP(entry.KEY, entry.VALUE);
                    int newHashValue = calculateHashValue(copy.KEY, newTable.length);

                    // if there is a linked list in the new hash table, add it at the end
                    if(newTable[newHashValue] != null) {
                        KVP lastLink = newTable[newHashValue];

                        while (lastLink.kid != null) {
                            lastLink = lastLink.kid;
                        }

                        lastLink.kid = copy;
                        copy.parent = lastLink;
                    }
                    // otherwise, it is the first one to be added there, again, it becomes its own parent
                    else {
                        copy.parent = copy;
                        newTable[newHashValue] = copy;
                    }
                    
                    // this was just a copy, now its time to move to the next kid
                    entry = entry.kid;
                }
            }
        }

        table = newTable;
    }

    private float calculateLoadFactor() {
        return UNAVAILABLE_SLOTS/(float)table.length;
    }

    private int calculateHashValue(String key, int size) {
        // one hash function to get from a mString to int, another one to get from an int to an int that fits the table size
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
