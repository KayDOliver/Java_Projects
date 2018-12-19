package com.imit.kay.objects;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Payment {
    private String name;
    private GregorianCalendar date;
    private int pay;

    public Payment() {
        name = "Иванов Иван Иванович";
        date = new GregorianCalendar(1970, Calendar.JANUARY, 1);  //текущая дата, а не 00.00.00
        pay = 0;
    }

    public Payment(String name, int pay, int year, int mounth, int day) {
        this.pay = pay;
        setDate(year, mounth, day);
        this.name = name;
    }

    public Payment(Payment p) {
        this.pay = p.pay;
        this.name = new String(p.name);
        setDate(p.date.get(Calendar.DAY_OF_MONTH),
                p.date.get(Calendar.MONTH),
                p.date.get(Calendar.YEAR));
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(int year, int mounth, int day) {
        this.date = new GregorianCalendar(year, mounth - 1, day);
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Payment of " + name);
        sb.append(String.format(("Плательщик: «%s» дата: %d.%d.%d сумма: %d руб. %d коп.\n"),
                name,
                date.get(Calendar.DAY_OF_MONTH),
                date.get(Calendar.MONTH) + 1,
                date.get(Calendar.YEAR),
                pay / 100,
                pay % 100));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true   
        if (o == this)
            return true; 
        
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Payment))
            return false;


        // typecast o to Complex so that we can compare data members
        Payment p = (Payment) o;

        // Compare the data members and return accordingly  
        return pay == p.pay && name.equals(p.name)
                && (date.get(Calendar.YEAR) == p.date.get(Calendar.YEAR))
                && (date.get(Calendar.MONTH) == p.date.get(Calendar.MONTH))
                && (date.get(Calendar.DAY_OF_MONTH) == p.date.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public int hashCode() {
        return Objects.hash(pay, name, date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH));
    }

}
