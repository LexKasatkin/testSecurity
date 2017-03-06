package security.test.com.testsecurity;

import java.util.ArrayList;

/**
 * Created by root on 06.03.17.
 */
public class Security {
    Integer quality;



    public ArrayList<Integer> getSecurityMassive(int quality){
        this.quality=quality;
        ArrayList<Integer>massive=new ArrayList<Integer>();
        if(this.quality==4){
            setMassive(massive,3,1,1,1,1,0);
        }
        if(this.quality==5){
            setMassive(massive,3,2,1,1,1,1);
        }
        if(this.quality==6){
            setMassive(massive,3,2,1,1,1,2);
        }
        return massive;
    }

    void setMassive(ArrayList<Integer> massive, int prav, int takt, int tech, int med, int spec, int ognev){
        for (int i=0;i<prav;i++){
            int value=randomValue(1,120);
            while (!massive.contains(value)){
                massive.add(value);

            }
        }
        for (int i=0;i<takt;i++){
            int value=randomValue(121,160);
            while (!massive.contains(value)){
                massive.add(value);
            }
        }
        for (int i=0;i<tech;i++){
            int value=randomValue(301,330);
            while (!massive.contains(value)){
                massive.add(value);
            }
        }
        for (int i=0;i<med;i++){
            int value=randomValue(161,200);
            while (!massive.contains(value)){
                massive.add(value);
            }
        }
        for (int i=0;i<spec;i++){
            int value=randomValue(201,240);
            while (!massive.contains(value)){
                massive.add(value);
            }
        }
        for (int i=0;i<ognev;i++){
            int value=randomValue(241,300);
            while (!massive.contains(value)){
                massive.add(value);
            }
        }
    }

    Integer randomValue(int min, int max){
        int random_number1 = min + (int) (Math.random() * ((max - min) + 1)); // Генерация 1-го числа
        System.out.println("1-ое случайное число: " + random_number1);
        return random_number1;
    }

}
