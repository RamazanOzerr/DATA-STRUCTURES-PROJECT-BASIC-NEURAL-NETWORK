import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Neuron {
    private String itemName ;
    DecimalFormat df = new DecimalFormat("0.0000");

    double[] weightArray ;
    public Neuron(String itemName) {
        // 4 ELEMANLI AGIRLIKLAR LISTESI OLUSTURUYORUZ
        weightArray= new double[4];

        this.itemName = itemName;
        Random random = new Random();
        // 0 ILE 1 ARASINDAN RASGELE 4 TANE AGIRLIK OLUSTURUYORUZ
        for (int i = 0; i < 4; i++) {
            double int1 =random.nextDouble(1);
            weightArray[i] = int1;
        }
    }

    // GEREKLI TOPLAMA İSLEMLERİNİ YAPAN FONKSİYON
    public double calculate(String[] inputArray) {
        double sum = 0;
        for (int i = 0; i < inputArray.length-1; i++) {
            // GELEN STRİNG İFADEYİ DOUBLE A CEVIRIP NORMALİZASYON ISLEMINI YAPTIK
            double input = Double.parseDouble(inputArray[i])/10;
            sum +=  input* weightArray[i];
        }
        return sum;
    }

    public void PrintString() {
        System.out.println(this.getItemName()+"--"+Arrays.toString(this.getWeightArray()));

    }
    // AGIRLIKLARI LANDA ILE ORANTILI ARTTIRAN FONKSIYON
    public void increaseWeight(double landa,String[] inputArray) {
        for (int i = 0; i < weightArray.length; i++) {
            weightArray[i] += (landa*(Double.parseDouble(inputArray[i])/10));
        }
    }

    // AGIRLIKLARI LANDA ILE ORANTILI AZALTAN FONKSIYON
    public void decreaseWeight(double landa,String[] inputArray) {
        for (int i = 0; i < weightArray.length; i++) {
            weightArray[i] -= (landa*(Double.parseDouble(inputArray[i])/10));
        }
    }

    public double[] getWeightArray() {
        return weightArray;
    }

    public String getItemName() {
        return this.itemName;
    }
}
