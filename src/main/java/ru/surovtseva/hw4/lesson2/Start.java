package ru.surovtseva.hw4.lesson2;

public class Start {
    public static void main (String[] args){

        String[][] correctArray = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"}
        };

        String[][] wrongSizeArray = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
        };

        String[][] wrongValueArray = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","v","4"}
        };

        System.out.println("Пример обработки корректного массива");
        try{
            System.out.println("Сумма всех элементов массива: "+ arrayAnalysis(correctArray));
        } catch (MyArraySizeException e) {
            System.out.println("Расчет невозможен по причине: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Расчет невозможен по причине: "+ e.getMessage());
        }

        System.out.println();
        System.out.println("Пример обработки массива неверного размера");
        try{
            System.out.println("Сумма всех элементов массива: "+ arrayAnalysis(wrongSizeArray));
        } catch (MyArraySizeException e) {
            System.out.println("Расчет невозможен по причине: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Расчет невозможен по причине: "+ e.getMessage());
        }


        System.out.println();
        System.out.println("Пример обработки массива c некорректными значениями");
        try{
            System.out.println("Сумма всех элементов массива: "+ arrayAnalysis(wrongValueArray));
        } catch (MyArraySizeException e) {
            System.out.println("Расчет невозможен по причине: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Расчет невозможен по причине: "+ e.getMessage());
        }
    }

    public static int arrayAnalysis(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum =0;

        if (array.length!=4 || array[0].length!=4) {
            throw new MyArraySizeException("Размер массива некорректный");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (IllegalArgumentException e) {
                    throw new MyArrayDataException("Некорректные данные в ячейке: [" + i + "]" + "[" + j + "]");
                }
            }
        }
        return sum;
    }
}
