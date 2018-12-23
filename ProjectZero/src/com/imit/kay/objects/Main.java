package com.imit.kay.objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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

        System.out.println(fith1.toString());
        System.out.println(def.toString());

        assert (fth1.getName().equals(fth.getName())) : "FTH1 getName test";
        assert (thd.getPay() == 10220) : "THD getPay test";
        assert (fith.equals(fith1)) : "FTH equals test";
        assert (!fst.equals(fst1)) : "FST equals test";
        assert (snd.hashCode() != snd1.hashCode()) : "SND hashCode test";
        assert (!thd.equals(thd1)) && (thd1.hashCode() != thd.hashCode()) : "THD equals & hashCode tests";
        assert (fth.equals(fth1)) : "FTH equals test";
        assert (fith.hashCode() == fith1.hashCode()) : "FITH hashCode test";

//
//        System.out.format("%d.%d.%d  %d \n", fith1.getDate().get(Calendar.DAY_OF_MONTH),
//                fith1.getDate().get(Calendar.MONTH),
//                fith1.getDate().get(Calendar.YEAR),
//                fith1.getPay());


        //Тестирование методов класса FinanceReport

        FinanceReport report0 = new FinanceReport(); //будешь пустым
        FinanceReport report1 = new FinanceReport(); //будешь забит до отказа
        FinanceReport report2 = new FinanceReport(10); //будешь на 10 мест
        FinanceReport report3 = new FinanceReport(report0); //будешь изменяемой копией пустого
        FinanceReport report4 = new FinanceReport(report2); //будешь копией Репорта с параметром

        report4.setValue(0, thd);
        report4.setValue(1, fst1);
        report4.setValue(2, fith);
        report4.setValue(3, snd1);
        report4.setValue(4, def);

//         report0.ReadFromStream(new FileInputStream("Input.txt"));
        report1.ReadFromStream(new FileInputStream("Input1.txt"));
//         report2.ReadFromStream(new FileInputStream("Input2.txt"));
        report3.ReadFromStream(new FileInputStream("Input3.txt"));
             /* читая из потока, "расширяется" сам Report,
                тк из потока дописывается в конец*/
//         report4.ReadFromStream(new FileInputStream("Input4.txt"));


        report0.WriteToStream(new FileOutputStream("Output.txt"));
        report1.WriteToStream(new FileOutputStream("Output1.txt"));
        report2.WriteToStream(new FileOutputStream("Output2.txt"));
        report3.WriteToStream(new FileOutputStream("Output3.txt"));
        report4.WriteToStream(new FileOutputStream("Output4.txt"));

        report1.StartsWith(new FileOutputStream("StartsWith.txt"), 'п');
        report1.LessThen(new FileOutputStream("LessThen.txt"), 70000000);
        System.out.println("The amount of payments on a specific day of the month is:"
                + report1.SumInMonth("22.02.76"));
        System.out.println("The amount of payments on a specific day of the month is:"
                + report1.SumInMonth("05.01.75"));
        System.out.println("Payment value with a specific index:"
                + report1.getValue(16));
        System.out.println("Payment value with a specific index:"
                + report2.getValue(2));
        System.out.println("Payment value with a specific index:"
                + report4.getValue(3));

        assert (report3.CountOfPayments() != report0.CountOfPayments())
                : "FR0 & FR3 CountOfPayment test"; //тест корректен из строки 59

    }

}
