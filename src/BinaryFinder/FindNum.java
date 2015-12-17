package BinaryFinder;

public class FindNum {


    public static int[] fillMasRandomInDiapason(int start, int finish, int size) {
        int[] mas = new int[size];

        for (int i = 0; i < mas.length; i++) {
            int random = (int) (Math.random() * start + 1 )+ finish + finish - start ;
            mas [i] = random;
        }return mas;
    }

    public static void printMas(int[] mas) {
        String test = " ";
        for (int i = 0; i < mas.length; i++) {
            String control = Integer.toString(mas[i] );
            test += control + " ";

        }
        System.out.println("{" + test + "}");
    }

    public static void findNum(int[] mas, int num) throws Exception{
        int start = 0;
        int finish = mas.length - 1;
        sortMas(mas);
        FindMaker(start, finish, mas, num);

    }

    private static int FindMaker(int start , int finish , int[] mas , int num) throws Exception{

        int add = start + (finish - start) / 2;

        if (mas[add] < num) {
            start = add - 1;
            FindMaker(start, finish, mas, num);

        } else if (mas[add] > num) {
            finish = add - 1;
            FindMaker(start, finish, mas, num);

        }else if (num == mas[add]){
            System.out.println("we find it " + mas[add]);
            return mas[add];

        }else{
            System.out.println("Mas haven`t this num");
            throw new Exception();
        }return 0;
    }

    private static int[] sortMas(int[] mas){
        int add = 0;
        int min = 0;
        for (int i = 0; i < mas.length ; i++) {
            add = i;
            min = add;
            for (int j = i + 1; j < mas.length ; j++) {
                if (mas[min] >= mas[j]){
                    min = j;
                }
            }
            int place = mas[add];
            mas[add] = mas[min];
            mas[min] = place;
        }
        return mas;
    }
}
