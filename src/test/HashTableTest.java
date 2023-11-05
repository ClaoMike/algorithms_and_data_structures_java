import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import hash_tables.HashTable;
import hash_tables.HashTable.KVP;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashTableTest {
    final String path = "/Users/claomike/Desktop/Projects/algorithms_and_data_structures_java/src/resources/text_files/fruits.txt";
    final TextFileReader reader = new TextFileReader(path);
    final ArrayList<String> data = reader.getData();
    
    int price = 5;

    HashTable sut = new HashTable();

    @Before
    public void init() {
        for(String s: data) {
            sut.insert(s, price++);
        }
    }

    @After
    public void teardown() {
        // for(String s: data) {
        //     sut.delete(s);
        // }
        sut = new HashTable();
    }
    
    @Test
    public void testHashTableOccupiedSlots() {
        assertEquals(data.size(), sut.getOccupiedSlots());
    }

    @Test
    public void testHashTableSizeAfterInsert() {
        assertEquals(320, sut.getTableSize());
    }

    @Test
    public void testHashTableSearch() {
        String item = "Surinam cherry";
        KVP pair = sut.search(item);

        assertEquals(item, pair.getKey());
        assertEquals(141, pair.getValue().intValue());
    }

    @Test
    public void testHashTableDeleteTrue() {
        String item = "Surinam cherry";

        assertTrue(sut.delete(item));
    }

    @Test
    public void testHashTableDeleteFalse() {
        String item = "Surinam cherry";
        sut.delete(item);

        assertFalse(sut.delete(item));
    }

    @Test
    public void testHashTableSizeAfterConsiderableDeletion() {
        for(int i=0; i<34; i++) {
            sut.delete(data.get(i));
        }

        assertEquals(160, sut.getTableSize());
    }

    @Test
    public void testHashTableSizeAfterBecomingEmpty() {
        for(String s: data) {
            sut.delete(s);
        }

        assertEquals(10, sut.getTableSize());
    }
}
