package level1;

public class MyArraySizeException extends Exception {

    public int len;

    MyArraySizeException(int len) {
        this.len = len;
    }

}
