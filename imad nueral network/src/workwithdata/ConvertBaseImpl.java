package workwithdata;

import interfaces.ConvertBase;
import static java.lang.Math.round;
public class ConvertBaseImpl implements ConvertBase {
    @Override
    public double[] getBinarry(int number) {

        double[] binaryArray = new double[7];
        int i;
        String symptomBit = Integer.toBinaryString(number);
        for(i =0;i<7-symptomBit.length();i++) binaryArray[i]=0;
        for(int j = 0; j < symptomBit.length(); j++) {
            binaryArray[i++] = Integer.parseInt(String.valueOf(symptomBit.charAt(j)));
        }

        return binaryArray;
    }

    @Override
    public int getInteger(double[] binary) {
        int number = (int)round(binary[0]);
        int base =2;
        for(int i=5;i>=0;i--)
        {
            number += round(binary[i]) * base;
            base*=2;
        }
        return number;
    }
}
