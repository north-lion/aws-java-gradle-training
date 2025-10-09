package training.generics;

import com.fasterxml.jackson.core.JsonProcessingException;

public class handleGenerics {
    public static void main(String[] args) throws JsonProcessingException {
        genericsSimple();
        genericsList();
        System.out.println(GenericMethod.writeValueAsString("str"));
    }

    public static void genericsSimple() {
        // 型指定なしでインスタンスを作成（型指定して使用するのが本来の使い方のため、警告がでる）
        GenericSimpleClass genericObj = new GenericSimpleClass();
        // 型を指定してインスタンスを作成
        GenericSimpleClass<String> genericStrObj= new GenericSimpleClass<>();

        // 型を指定していないので、Stringの関数が使えない
        genericObj.getValue();

        String str = "this is stringObj";
        genericStrObj.setValue(str);
        // 型を指定しているので、Stringの関数が使える
        genericStrObj.getValue().substring(3);
    }
    public static void genericsList(){
        // 文字列型でGenericListClassインスタンスを生成
        GenericListClass<String> genericStrList = new GenericListClass<>();
        genericStrList.add("A");
        genericStrList.add("B");
        genericStrList.add("C");
        genericStrList.printAll();

        // Integer型でGenericListClassインスタンスを生成
        GenericListClass<Integer> genericIntegerList = new GenericListClass<>();
        genericIntegerList.add(3);
        genericIntegerList.add(2);
        genericIntegerList.add(1);
        genericIntegerList.printAll();
    }
}