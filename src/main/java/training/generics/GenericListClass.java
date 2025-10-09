package training.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericListClass<T> {
    List<T> list = new ArrayList<>();

    public void add(T element) {
        list.add(element);
    }

    public void printAll() {
        for(T e : list) {
            System.out.println(e);
        }
    }
}
