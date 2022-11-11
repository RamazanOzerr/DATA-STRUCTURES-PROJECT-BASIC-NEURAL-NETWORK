import java.util.ArrayList;
import java.util.Arrays;

public class NeuralNetwork {

    // 3 TANE NEURON OLUSTURUYORUZ
    Neuron N1 = new Neuron("Iris-setosa");
    Neuron N2 = new Neuron("Iris-versicolor");
    Neuron N3 = new Neuron("Iris-virginica");
    int Count = 0;

    public NeuralNetwork() {
    }

    // NETWORKUMUZU EGITEN FONKSIYON
    public double Train(ArrayList<String[]> RawDataset, double landa, int epok) {
        Count = 0;
        Neuron maxW;
        for (int i = 0; i < epok; i++) {
            for (String[] line: RawDataset) {
                double N1R1 = this.N1.calculate(line);
                double N2R2 = this.N2.calculate(line);
                double N3R3 = this.N3.calculate(line);

                double[] arr = {N1R1,N2R2,N3R3};
                double maxR = Arrays.stream(arr).max().getAsDouble();

                // MAXR HANGI NEURONA AITSE ONU SECIYORUZ
                if(maxR ==N1R1){maxW = this.N1;}
                else if(maxR ==N2R2){maxW = this.N2;}
                else{maxW = this.N3;}

                // MAXW ARADIGIMIZ CICEKMI DEGILMI KONTROLU YAPIYORUZ
                // EGER ARADIGIMIZ CICEKSE HIC BIR ISLEM YAPMIYORUZ
                // EGER ARADIGIMIZ CICEK DEGILSE MAXW NIN AGIRLIKLARINI
                // AZALTIYORUZ ISTENEN CICEGIN AGIRLIKLARINI ARTTIRIYORU
                if (!maxW.getItemName().equals(line[4])) {
                    maxW.decreaseWeight(landa,line);
                    if (this.N1.getItemName().equals(line[4])) {
                        this.N1.increaseWeight(landa,line);
                    }
                    else if (this.N2.getItemName().equals(line[4])) {
                        this.N2.increaseWeight(landa,line);
                    }
                    else{
                        this.N3.increaseWeight(landa,line);
                    }
                }else {Count+=1;}
            }
        }
        double var =(Count/(150.0*epok))*100;
        return var;
    }

    // TEST ISLEMI
    public double Test(ArrayList<String[]> RawDataset) {
        Count = 0;
        Neuron maxW;
        for (String[] line: RawDataset) {
            double N1R1 = this.N1.calculate(line);
            double N2R2 = this.N2.calculate(line);
            double N3R3 = this.N3.calculate(line);

            double[] arr = {N1R1,N2R2,N3R3};
            double maxR = Arrays.stream(arr).max().getAsDouble();

            if(maxR ==N1R1){maxW = this.N1;}
            else if(maxR ==N2R2){maxW = this.N2;}
            else{maxW = this.N3;}

            if (maxW.getItemName().equals(line[4])) {
                Count++;
            }
        }
        double var =(Count/(150.0))*100;
        return var;
    }

    public void Output(String Text) {
        this.N1.PrintString();
        this.N2.PrintString();
        this.N3.PrintString();
    }
}