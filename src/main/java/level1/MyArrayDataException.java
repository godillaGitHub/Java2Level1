package level1;

public class MyArrayDataException extends Exception {

    String element;
    public int i,j;

    MyArrayDataException(String element, int i, int j) {
        this.element = element;
        this.i = i;
        this.j = j;

    }

}
