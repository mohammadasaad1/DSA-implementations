import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }
    private LinkedList<Entry> entries[] = new LinkedList[5];

    private int hash(int key){
        return key % entries.length;
    }

    public void put(int key , String value){
        // we can refactor it later : ) task
        var index = hash(key) ;
        if (entries[index] == null)
            entries[index] = new LinkedList<>();
        var bucket = entries[index];
        for(var entry : bucket){
            if (entry.key == key) {
                entry.value = value;
                return ;
            }
        }
        bucket.addLast(new Entry(key , value));
    }

    public String get(int key){
        var entry = getEntry(key);
        return (entry != null) ? entry.value : null ;

    }

    public void remove(int key){
//        int index = hash(key);
//        var bucket = entries[index] ;
//        if(bucket != null){
//            for (var entry : bucket)
//            {
//                if(entry.key == key) {
//                    bucket.remove(entry);
//                    return;
//                }
//            }
//        } refactoring to =>

        var entry = getEntry(key);
        if(entry != null){
            getBucket(key).remove(getEntry(key));
            return;
        }

         throw new IllegalStateException();
    }
    private LinkedList<Entry> getBucket(int key){
        return entries[hash(key)] ;
    }
    private Entry getEntry(int key){
        var bucket = getBucket(key) ;
        if(bucket != null){
            for(var entry : bucket)
            {
                if(entry.key == key)
                    return entry;
            }
        }
        return null;
    }
}
