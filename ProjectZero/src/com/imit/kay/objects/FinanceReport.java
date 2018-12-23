package com.imit.kay.objects;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class FinanceReport {
    private ArrayList<Payment> data;

    public FinanceReport() {
        data = new ArrayList();
    }

    public FinanceReport(FinanceReport f) {
        data = new ArrayList(f.data);
    }

    public FinanceReport(int size) {
        data = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            data.add(new Payment());
        }
    }

    //Throws IndexOfBoundException
    public Payment getValue(int index) {
        return data.get(index);
    }

    //Throws IndexOfBoundException
    public void setValue(int index, Payment element) {
        data.set(index, element);
    }

    public int CountOfPayments() {
        return data.size();
    }

    public void ReadFromStream(InputStream in) {
        Scanner sr = new Scanner(in);
        while (sr.hasNext()) {
            data.add(new Payment(sr.nextLine(), //ФИО
                    sr.nextInt(),  //платеж
                    sr.nextInt(),  //год
                    sr.nextInt(),   //месяц
                    sr.nextInt()));  //день
            sr.nextLine();
        }
    }

    public void WriteToStream(OutputStream out) {
        PrintStream ps = new PrintStream(out);
        for (Payment p : data)
            ps.println(p.toString());
    }

    //****************************************************//
	/*вывод в поток информации о платежах всех людей,
	 *чья фамилия начинается на указанный символ (символ — входной параметр),
	 *каждый платеж выводится в формате:

         Плательщик: «ФИО» дата: день.месяц.год сумма: *** руб. ** коп. (используйте String.format).
	 */

    public void StartsWith(OutputStream out, char a) {
        PrintStream ps = new PrintStream(out);
        data.stream().filter((p) ->
                p.getName().toLowerCase().charAt(0) == Character.toLowerCase(a))
                .forEach((p) -> ps.printf("Плательщик: «%s» дата: %d.%d.%d сумма: %d руб. %d коп.\n",
                        p.getName(),
                        p.getDate().get(Calendar.DAY_OF_MONTH),
                        p.getDate().get(Calendar.MONTH) + 1,
                        p.getDate().get(Calendar.YEAR),
                        p.getPay() / 100,
                        p.getPay() % 100));
    }

    public void LessThen(OutputStream out, int val) {
        PrintStream ps = new PrintStream(out);
        data.stream().filter((p) ->
                p.getPay() < val)
                .forEach((p) -> ps.printf("Плательщик: «%s» дата: %d.%d.%d сумма: %d руб. %d коп.\n",
                        p.getName(),
                        p.getDate().get(Calendar.DAY_OF_MONTH),
                        p.getDate().get(Calendar.MONTH) + 1,
                        p.getDate().get(Calendar.YEAR),
                        p.getPay() / 100,
                        p.getPay() % 100));
    }

    public Integer SumInMonth(String s) {
        String str[] = s.split("\\.");
        int arr[] = Arrays.stream(str)
                .mapToInt(Integer::valueOf).toArray();
        arr[1] = arr[1] - 1;
        if (arr[2] >= 70) {
            arr[2] += 1900;
        } else {
            arr[2] += 2000;
        }
        return data.stream().filter((p) ->
                (p.getDate().get(Calendar.DAY_OF_MONTH) == arr[0])
                        && (p.getDate().get(Calendar.MONTH) == arr[1])
                        && (p.getDate().get(Calendar.YEAR) == arr[2]))
                .mapToInt((p) -> p.getPay())
                .sum();
    }

}
