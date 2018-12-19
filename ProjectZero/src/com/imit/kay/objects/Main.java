package com.imit.kay.objects;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        //Тестирование методов класса Payment

        Payment def = new Payment();

        Payment fst = new Payment("Николаев Илья Семенович", 849758, 2014, 2, 27);
        Payment snd = new Payment("Ивлева Светлана Ивановна", 10000, 2014, 2, 27);
        Payment thd = new Payment("Омарбеков Сейран Абдулаевич", 10220, 2015, 9, 15);
        Payment fth = new Payment("Севердинова Елена Павловна", 1258, 2018, 12, 19);
        Payment fith = new Payment("Куролисков Святослав Викторович", 154890, 2013, 4, 25);

        Payment fst1 = new Payment(fst); //изменен
        Payment snd1 = new Payment(snd);  //изменен
        Payment thd1 = new Payment(thd); //изменен
        Payment fth1 = new Payment(fth);
        Payment fith1 = new Payment(fith);

        fst1.setName("Николаев Иван Степанович");
        snd1.setDate(2014, 11, 25);
        thd1.setPay(102200);

        System.out.println("\n" + def.toString());

        assert (fth1.getName().equals(fth.getName())) : "FTH1 getName test";
        assert (thd.getPay() == 10220) : "THD getPay test";
        assert (fith.equals(fith1)) : "FTH equals test";
        assert (!fst.equals(fst1)) : "FST equals test";
        assert (snd.hashCode() != snd1.hashCode()) : "SND hashCode test";
        assert (!thd.equals(thd1)) && (thd1.hashCode() != thd.hashCode()) : "THD equals & hashCode tests";
        assert (fth.equals(fth1)) : "FTH equals test";
        assert (fith.hashCode() == fith1.hashCode()) : "FITH hashCode test";

        System.out.format("%d.%d.%d  %d \n", fith1.getDate().get(Calendar.DAY_OF_MONTH),
                fith1.getDate().get(Calendar.MONTH),
                fith1.getDate().get(Calendar.YEAR),
                fith1.getPay()); //вывод даты фуфловый


        System.out.println(fith1.toString());

        //Тестирование методов класса FinanceReport

//        FinanceReport report1 = new FinanceReport();
//        try {
//            report1.ReadFromStream(new FileInputStream("Input.txt"));
//        } catch (FileNotFoundException e) {
//        }
//        report1.WriteToStream(System.out);
//        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
//        report1.StartsWith(System.out, 'п');
//        System.out.println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
//        report1.LessThen(System.out, 700000);
//        System.out.println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
//        System.out.println(report1.SumInMonth("17.06.08"));
//        System.out.println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
//        System.out.println(report1.SumInMonth("02.11.75"));
    }

}
