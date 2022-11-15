import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Path filePath = Path.of("iris.data");
        double result2025,result5025,result10025;
        double result2010,result5010,result10010;
        double result2005,result5005,result10005;

        NeuralNetwork NNetWork1 = new NeuralNetwork();
        NeuralNetwork NNetWork25 = new NeuralNetwork();
        NeuralNetwork NNetWork5 = new NeuralNetwork();

        ArrayList<String []> aray = ReadData(filePath);


        // 0.025 LANDA ILE YAPILAN EGITIMLER
        //modelimizi oncelikle 20 epok egitiyoruz
        NNetWork25.Train(aray, 0.025, 20);
        result2025=NNetWork25.Test(aray);

        // daha sonradan 30 epok daha egitip 50 epoga tamamlıyoruz
        NNetWork25.Train(aray, 0.025, 30);
        result5025=NNetWork25.Test(aray);

        // daha sonradan 50 epok daha egitip 100 epoga tamamlıyoruz
        NNetWork25.Train(aray, 0.025, 50);
        result10025=NNetWork25.Test(aray);


        // 0.005 LANDA ILE YAPILAN EGITIMLER
        //modelimizi oncelikle 20 epok egitiyoruz
        NNetWork5.Train(aray, 0.005, 20);
        result2005=NNetWork5.Test(aray);

        // daha sonradan 30 epok daha egitip 50 epoga tamamlıyoruz
        NNetWork5.Train(aray, 0.005, 30);
        result5005=NNetWork5.Test(aray);

        // daha sonradan 50 epok daha egitip 100 epoga tamamlıyoruz
        NNetWork5.Train(aray, 0.005, 50);
        result10005=NNetWork5.Test(aray);


        // 0.01 LANDA ILE YAPILAN EGITIMLER
        //modelimizi oncelikle 20 epok egitiyoruz
        NNetWork1.Train(aray, 0.01, 20);
        result2010=NNetWork1.Test(aray);

        // daha sonradan 30 epok daha egitip 50 epoga tamamlıyoruz
        NNetWork1.Train(aray, 0.01, 30);
        result5010=NNetWork1.Test(aray);

        // daha sonradan 50 epok daha egitip 100 epoga tamamlıyoruz
        NNetWork1.Train(aray, 0.01, 50);
        result10010=NNetWork1.Test(aray);



        // CIKAN SONUCLARI BİR LISTEYE ATIYORUZ
        double[] resultArr = {result2005,result5005,result10005,result2010,result5010,result10010,result2025,result5025,result10025};

        showInfo(resultArr);
    }

    // VERIYI CEKIP ARRAYLISTE ATAN METHOD
    public static ArrayList<String []> ReadData(Path filePath) {
        ArrayList<String []> RawDataset = new ArrayList<String []>();
        String arr;
        try {
            arr = Files.readString(filePath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            arr = "Boş";
        }
        if (arr == "Boş") {
            System.out.println(arr);}
        String arr1=arr.strip();
        String[] rawData = arr1.split("\n");
        for (String line:rawData) {
            String[] lineData = line.split(",");
            RawDataset.add(lineData);
        }
        return RawDataset;
    }

    // SONUCLARI EKRANA BASTIRAN METHOD
    public static void showInfo(double[] resultArray) {
        System.out.print(" epok ");
        System.out.print("----");
        System.out.print("20");
        System.out.print("--------");
        System.out.print("50");
        System.out.print("------");
        System.out.print("100");
        System.out.println();
        System.out.print("landa ");
        System.out.print("--------");
        System.out.print("--");
        System.out.print("------");
        System.out.print("--");
        System.out.print("------");
        System.out.print("--");
        System.out.println();
        System.out.print("0,005");
        System.out.print("----");
        System.out.print(df.format(resultArray[0]));
        System.out.print("----");
        System.out.print(df.format(resultArray[1]));
        System.out.print("----");
        System.out.print(df.format(resultArray[2]));
        System.out.println();
        System.out.print("0,010");
        System.out.print("----");
        System.out.print(df.format(resultArray[3]));
        System.out.print("----");
        System.out.print(df.format(resultArray[4]));
        System.out.print("----");
        System.out.print(df.format(resultArray[5]));
        System.out.println();
        System.out.print("0,025");
        System.out.print("----");
        System.out.print(df.format(resultArray[6]));
        System.out.print("----");
        System.out.print(df.format(resultArray[7]));
        System.out.print("----");
        System.out.print(df.format(resultArray[8]));
        System.out.println();


    }
}