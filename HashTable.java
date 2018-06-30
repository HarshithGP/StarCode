import java.util.ArrayList;
class MapEntry{
    
    private int key;
    private int value;
    
    MapEntry(int k, int v){
        this.key=k;
        this.value=v;
    }
    
    public int getKey(){
        return key;
    }
    
    public int getValue(){
        return value;
    }
}

public class HashTable{
    
    ArrayList<MapEntry> table[];
    
    private static final int TABLE_SIZE=10;
    static int Size=0;
    
    HashTable(){
        
        table = new ArrayList[TABLE_SIZE];
        
        for(int i=0;i<TABLE_SIZE;i++)
            table[i]=new ArrayList<MapEntry>();
    }
    
    public void put(int key, int value){
        
        int index=hash(key);
        
        if(table[index].size()==0)
            Size++;
        
        table[index].add(new MapEntry(key,value));
        
        
    }
    
    public int get(int key){
        
        int index=hash(key);
        for(int i=0;i<table[index].size();i++)
            if(table[index].get(i).getKey()==key)
                return table[index].get(i).getValue();
        
        return -1;
    }
    
    public int hash(int key){
        return key%TABLE_SIZE;
    }
    
    public void remove(int key){
        int index=hash(key);
         for(int i=0;i<table[index].size();i++)
            if(table[index].get(i).getKey()==key)
                table[index].remove(i);
        
        if(table[index].size()==0)
            Size--;
        
            
    }
    
    public int Size(){
        return Size;
    }
    
    public static void main(String args[]){
        
        HashTable obj = new HashTable();
        obj.put(10,50);
        obj.put(20,100);
        obj.put(30,200);
        obj.put(40,400);
        
        System.out.println(obj.get(10));
       obj.remove(10);
       obj.remove(20);
        System.out.println(obj.get(20));
        System.out.println(obj.get(10));
        System.out.println("size = "+obj.Size());
        
        
    }
    
}
