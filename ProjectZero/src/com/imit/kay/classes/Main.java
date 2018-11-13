package com.imit.kay.classes;

public class Main {
    public static void main(String[] args) {
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for class Point3D: \n");

        /*
         * 15. Разработайте класс Point3D (точка в трехмерном пространстве).
         * Точка хранится в виде набора декартовых координат. Методы:
                1) конструктор по координатам,
                2) конструктор без параметров (создает точку – начало координат),
                3) геттеры и сеттеры,
                4) вывод точки на консоль.

         * Создайте несколько объектов этого класса. Сравните две точки на равенство.
         * Для какого-то из объектов проверьте, равна ли эта точка сама себе.
        */

        /*1*/
        Point3D p1 = new Point3D();
        System.out.println("Default constructor");
        p1.Print();
        Point3D p2 = new Point3D(10, 20, 30);

        /*2*/
        System.out.println("\nParameter Constructor");
        p2.Print();

        /*3*/
        System.out.println("\nGet, Set");
        p1.set_x(100);
        p1.set_y(123);
        p1.set_z(-1);

        /*4*/
        System.out.format("Point position: (%.3f, %.3f, %.3f)\n", p1.Get_x(), p1.Get_y(), p1.get_z());

        /*сравнение объектов класса*/
        Point3D p3 = p1;
        System.out.println("p1==p3: " + (p1 == p3));
        p2 = new Point3D(p1.Get_x(), p1.Get_y(), p1.get_z());
        System.out.println("p1==p2: " + (p1 == p2));
        System.out.println("p1==p1: " + (p1 == p1) + "\n");

        /*
         * 16. Разработайте класс Vector3D (вектор в трехмерном пространстве).
         * Вектор хранится в виде набора своих координат. Методы:
            1) конструктор без параметров (создает нулевой вектор),
            2) конструктор по координатам,
            3) конструктор по двум точкам (Point3D),
            4) длина вектора,
            5) проверка равенства с заданным вектором.
        */
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for class Vector3D: \n");

        /*конструкторы и вывод*/
        Vector3D v1 = new Vector3D();
        Vector3D v2 = new Vector3D(2, 3, 4);
        Vector3D v3 = new Vector3D(p1, p2);
        Vector3D v4 = v2;

        v1.Print();
        v2.Print();
        v3.Print();

        /*длина вектора*/
        System.out.format("\nVector length is : %.3f \n", v2.Length());
        System.out.format("Vector length is : %.3f \n", v3.Length());

        /*проверка на раверство*/
                                                                        //для использования ассертов нужно VMOption -ea
        assert v1.Equal(v1) : "Error";
        assert !v1.Equal(v2) && v1.Equal(v2) == v2.Equal(v1) : "Error";
        assert v4.Equal(v2) && v4.Equal(v2) == v2.Equal(v4) : "Error";
        System.out.println("\nEquality tests successful\n");

        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for class Vector3DProcessor: \n");

        /*17. Разработайте класс Vector3DProcessor с методами:
            1) сумма и разность двух векторов,
            2) скалярное произведение двух векторов,
            3) векторное произведение двух векторов,
            4) проверка коллинеарности двух векторов.
        */

        /*1*/
        Vector3DProcessor.Sum(new Vector3D(1, 2, 3), new Vector3D(3, 2, 1)).Print();
        Vector3DProcessor.Sub(new Vector3D(3, -4, 3), new Vector3D(4, 2, 1)).Print();

        /*2*/
        assert Vector3DProcessor.ScalarMul(new Vector3D(1, 2, 3),
                new Vector3D(4, 2, 1)) == 11 : "ScalarMul Error";
        System.out.println("\nScalar multiplication tests successful");

        /*3*/
        Vector3DProcessor.VectorMul(new Vector3D(1, 2, 3), new Vector3D(3, 2, 1)).Print();
        //-4,8,-4

        /*4*/
        assert Vector3DProcessor.IsColl(new Vector3D(), new Vector3D()) : "two null Coll Error";
        assert Vector3DProcessor.IsColl(new Vector3D(), new Vector3D(1, 2, 3)) : "null Coll Error";
        assert Vector3DProcessor.IsColl(new Vector3D(1, 2, 3),
                new Vector3D(2, 4, 6)) : "two Coll Error";
        assert !Vector3DProcessor.IsColl(new Vector3D(1, 2, 3),
                new Vector3D(2, 9, 6)) : "two not Coll Error";

        //коллинеарность с нулевыми координатами

        assert !Vector3DProcessor.IsColl(new Vector3D(1, 2, 3),
                new Vector3D(0, 4, 6)) : "X2 null not Coll Error";
        assert !Vector3DProcessor.IsColl(new Vector3D(0, 2, 3),
                new Vector3D(1, 4, 6)) : "X1 null not Coll Error";
        assert Vector3DProcessor.IsColl(new Vector3D(0, 2, 3),
                new Vector3D(0, 4, 6)) : "all X null Coll Error";
        assert !Vector3DProcessor.IsColl(new Vector3D(0, 2, 5),
                new Vector3D(0, 4, 6)) : "all X null not Coll Error";
        System.out.println("\nCollinearity multiplication tests successful \n");

        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for class Vector3DArray: ");

        /*
        * 18. Разработайте класс Vector3DArray (массив трехмерных векторов). Методы:
                1) конструктор по размеру (создает массив из нулевых векторов),
                2) длина массива,
                3) замена i-го элемента массива на заданный вектор,
                4) наибольшая длина вектора в массиве,
                5) поиск заданного вектора в массиве (результат – индекс первого вхождения или –1, если не найден),
                6) сумма всех векторов в массиве,
                7) метод, который получает на вход массив вещественных чисел (коэффициентов)
                         и вычисляет линейную комбинацию векторов с заданными коэффициентами.
                         При несовпадении длин массивов векторов и коэффициентов выбросить исключение,
                8) метод, который получает на вход точку P (типа Point3D) и вычисляет массив точек,
                         каждая из которых – результат сдвига точки P, на соответствующий вектор.
        */

        Vector3DArray arr = new Vector3DArray(3);
        arr.Print();

        arr.Set(new Vector3D(1, 2, 3), 2);
        arr.Set(new Vector3D(-8, 0, -9), 0);
        arr.Print();

        System.out.format("\nMax length is: %.5f \n", arr.MaxLen());

        arr.Set(new Vector3D(-8, 0, -9), 0);
        arr.Set(new Vector3D(), 1);
        arr.Set(new Vector3D(), 2);
        assert arr.IndexOf(new Vector3D()) == 1 : "Index of first zero vector error";
        assert arr.IndexOf(new Vector3D(10, 10, 10)) == -1 : "Index of not consist error";
        System.out.println("\nТest method IndexOf successful\n");


        arr.Set(new Vector3D(1, 2, 3), 2);
        arr.Sum().Print(); //-7, 2, -6

        try {
            arr.LineComb(new float[]{1.5f, 2.3f, -0.1f}).Print();
            arr.LineComb(new float[]{1.5f, 2.3f, -0.1f, -8}).Print();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        arr.Set(new Vector3D(-8, 0, -9), 0);
        arr.Set(new Vector3D(), 1);
        arr.Set(new Vector3D(1, 2, 3), 2);

        System.out.println("Points array content:\n{ ");
        for (Point3D point : arr.PointArray(new Point3D(2, 5, -6))) {
            System.out.print("\t");
            point.Print();
        }
        System.out.println("}");

    }

}
