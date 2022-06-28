package level1;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива
другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать
возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */
public class HomeWorkApp {

    public static void main(String[] args) {

        String[][] arr = new String[][]
                        {{"1", "1", "1", "1"},
                        {"1", "1", "D", "1"},
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"}};
        try {
            try {
                int result = sum(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен: " + e.len);
            }
        }
        catch (MyArrayDataException e) {
            System.out.printf("В элементе массива " + e.element + " (x=%s и y=%s) преобразование не удалось.", e.i, e.j);
        }
    }

    public static int sum(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException(arr.length);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(arr[i].length);
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(arr[i][j], i, j);
                }
            }

        }
        return count;

    }

}
