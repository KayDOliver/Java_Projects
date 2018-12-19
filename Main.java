package com.imit.kay.objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        snd1.setDate(2014,11,25);
        thd1.setPay(102200);
        System.out.println(fth1.getName());
        System.out.format("%d.%d.%d  %d", fith1.getDate().get(Calendar.DAY_OF_MONTH),
                 fith1.getDate().get(Calendar.MONTH)+1,
                 fith1.getDate().get(Calendar.DATE),
                 fith1.getPay()); //вывод даты фуфловый

        System.out.println("\n"+def.toString());

        assert (fst.equals(fst1) == false) : "FST equals test";
        assert (snd.hashCode() != snd1.hashCode()) : "SND hashCode test";
        assert (thd.equals(fst1) == false)&&(thd.hashCode() != thd.hashCode()) : "THD equals & hashCode tests";
        assert (fth.equals(fst1) == true) : "FTH equals test";
        assert (fith.hashCode() != fith1.hashCode()) : "FITH hashCode test";


    }
}
