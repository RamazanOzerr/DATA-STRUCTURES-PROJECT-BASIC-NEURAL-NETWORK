import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Neuron {
    private String itemName ;
    DecimalFormat df = new DecimalFormat("0.0000");

    // static double[] inputArray = new double[4];
    double[] weightArray ;
    public Neuron(String itemName) {
        weightArray= new double[4];

        this.itemName = itemName;
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            double double1 =random.nextDouble(1);
            weightArray[i] = double1;
        }
    }

    public double calculate(String[] inputArray) {
        double sum = 0;
        for (int i = 0; i < inputArray.length-1; i++) {
            double input = Double.parseDouble(inputArray[i])/10;
            sum +=  input* weightArray[i];
        }
//	        System.out.println(sum);
        return sum;
    }

    public void PrintString() {
        System.out.println(this.getItemName()+"--"+Arrays.toString(this.getWeightArray()));

    }
    public void increaseWeight(double landa,String[] inputArray) {
        for (int i = 0; i < weightArray.length; i++) {
            weightArray[i] += (landa*(Double.parseDouble(inputArray[i])/10));
        }
    }

    public void decreaseWeight(double landa,String[] inputArray) {
        for (int i = 0; i < weightArray.length; i++) {
            weightArray[i] -= (landa*(Double.parseDouble(inputArray[i])/10));
        }
    }

    public double[] getWeightArray() {
        return weightArray;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return this.itemName;
    }

}
