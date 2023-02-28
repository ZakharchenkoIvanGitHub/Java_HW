import java.util.ArrayList;
import java.util.HashMap;

/*
Разработать программу, имитирующую поведение коллекции HashSet.
В программе содать метод add добавляющий элемент,
метод toString возвращающий строку с элементами множества
и метод позволяющий читать элементы по индексу.
Формат данных Integer
*/
public class HW_6 {
    public static void main(String[] args) {

        Myset set = new Myset();
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        System.out.println(set);
        System.out.println(set.contains(11));
        System.out.println(set.contains(5));
        System.out.println(set.get(5));
        System.out.println(set.getArrayList());
        System.out.println(set.headSet(7));
        System.out.println(set.tailSet(7));
        System.out.println(set.subSet(7,9));
    }
}

class Myset {
    private HashMap<Integer, Object> values = new HashMap<>();
    private static final Object X = new Object();

    void add(int data) {
        values.put(data, X);
    }

    public String toString() {
        return values.keySet().toString();
    }

    Boolean contains(int data) {
        return values.containsKey(data);
    }

    void clear() {
        values.clear();
    }

    void remove(int data) {
        values.remove(data);
    }

    int size() {
        return values.size();
    }

    int get(int ind) {
        return (int) values.keySet().toArray()[ind];
    }

    ArrayList getArrayList() {
        ArrayList<Integer> res = new ArrayList<>();
        values.forEach((k, v) -> res.add(k));
        return res;
    }

    Myset headSet(int data){
        Myset res = new Myset();
        for (int el: values.keySet()) {
            res.add(el);
            if (data == el)
                break;
        }
        return res;
    }

    Myset tailSet(int data){
        boolean ad = false;
        Myset res = new Myset();
        for (int el: values.keySet()) {
            if (data == el)
                ad = true;
            if (ad) {
                res.add(el);}
        }
        return res;
    }

    Myset subSet (int key1, int key2){
        Myset res = new Myset();
        boolean ad = false;
        int stop = key1;
        for (int el: values.keySet()) {
            if (el == key1 && !ad){
                ad = true;
                stop = key2;
            }
            if (el == key2 && !ad ){
                ad = true;
            }
            if (ad){
                res.add(el);
                if (el == stop){
                    break;
                }
            }
        }
        return res;
    }
}