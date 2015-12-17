package BinaryFinder;

import java.util.Scanner;

public class TestFinderAndSorter {
    public static void main(String[] args) throws Exception{
        int[] mas = FindNum.fillMasRandomInDiapason(22, 50, 10);
        Scanner sc = new Scanner(System.in);
        FindNum.printMas(mas);
        int num = sc.nextInt();
        FindNum.findNum(mas, num);
    }
}
