/** Ref:
 * https://dev-moyashi.hatenablog.com/entry/2019/12/28/124727
 * https://note.com/codek2/n/n0d759b5da1ae
 * https://qiita.com/yoshitaro-yoyo/items/7ce53cc3c01d23108376
 */


package training.generics;

/**
 * クラス総称型
 *
 * @param <T>
 */
public class GenericSimpleClass<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}