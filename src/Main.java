import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Path filePath = Path.of("D:\\NEURAL NETWORK\\iris.data");

        NeuralNetwork NNetWorkhundred1 = new NeuralNetwork();
        NeuralNetwork NNetWorkfifty1 = new NeuralNetwork();
        NeuralNetwork NNetWorktwenty1 = new NeuralNetwork();
        NeuralNetwork NNetWorkhundred25 = new NeuralNetwork();
        NeuralNetwork NNetWorkfifty25 = new NeuralNetwork();
        NeuralNetwork NNetWorktwenty25 = new NeuralNetwork();
        NeuralNetwork NNetWorkhundred5 = new NeuralNetwork();
        NeuralNetwork NNetWorkfifty5 = new NeuralNetwork();
        NeuralNetwork NNetWorktwenty5 = new NeuralNetwork();
        ArrayList<String []> aray = ReadData(filePath);
        // 20 epok
        System.out.println("-----------------------------");
//        NNetWorktwenty25.Output("Başlangıç");
        System.out.println("-----------------------------");

        NNetWorktwenty25.Train(aray, 0.025, 20);
        NNetWorktwenty25.Test(aray);
        System.out.println("-----------------------------");

//        NNetWorktwenty25.Output("tset20");
        System.out.println("-----------------------------");

        //50 epok
//        NNetWorkfifty25.Output("Başlangıç");
        System.out.println("-----------------------------");

        NNetWorkfifty25.Train(aray, 0.025, 50);
//        NNetWorkfifty25.Output("Eğiitim");
        NNetWorkfifty25.Test(aray);
        System.out.println("-----------------------------");

//        NNetWorkfifty25.Output("tset50");
        System.out.println("-----------------------------");

//        NNetWorkhundred25.Output("dsad");
        System.out.println("-----------------------------");

        // 10 epok
//        NNetWorkten.Output("Başlangıç");
        NNetWorkhundred25.Train(aray, 0.025, 100);
//        NNetWorkten.Output("Eğiitim");
        NNetWorkhundred25.Test(aray);
//        NNetWorkten.Output("tset10");

//        NNetWorkhundred25.Output("dsad");
        // 20 epok
        System.out.println("****************************************");
//        NNetWorktwenty5.Output("Başlangıç");
        System.out.println("-----------------------------");

        NNetWorktwenty5.Train(aray, 0.005, 20);
        NNetWorktwenty5.Test(aray);
        System.out.println("-----------------------------");

//        NNetWorktwenty5.Output("tset20");
        System.out.println("-----------------------------");

        //50 epok
//        NNetWorkfifty5.Output("Başlangıç");
        System.out.println("-----------------------------");

        NNetWorkfifty5.Train(aray, 0.005, 50);
//        NNetWorkfifty5.Output("Eğiitim");
        NNetWorkfifty5.Test(aray);
        System.out.println("-----------------------------");

//        NNetWorkfifty5.Output("tset50");
        System.out.println("-----------------------------");

//        NNetWorkhundred5.Output("dsad");
        System.out.println("-----------------------------");

        // 10 epok
//        NNetWorkten.Output("Başlangıç");
        NNetWorkhundred5.Train(aray, 0.005, 100);
//        NNetWorkten.Output("Eğiitim");
        NNetWorkhundred5.Test(aray);
//        NNetWorkten.Output("tset10");

//        NNetWorkhundred5.Output("dsad");

        // 20 epok
        System.out.println("**********************************************");
//        NNetWorktwenty1.Output("Başlangıç");
        System.out.println("-----------------------------");

        NNetWorktwenty1.Train(aray, 0.01, 20);
        NNetWorktwenty1.Test(aray);
        System.out.println("-----------------------------");

//        NNetWorktwenty1.Output("tset20");
        System.out.println("-----------------------------");

        //50 epok
//        NNetWorkfifty1.Output("Başlangıç");
        System.out.println("-----------------------------");

        NNetWorkfifty1.Train(aray, 0.01, 50);
//        NNetWorkfifty1.Output("Eğiitim");
        NNetWorkfifty1.Test(aray);
        System.out.println("-----------------------------");

//        NNetWorkfifty1.Output("tset50");
        System.out.println("-----------------------------");

//        NNetWorkhundred1.Output("dsad");
        System.out.println("-----------------------------");

        // 10 epok
//        NNetWorkten.Output("Başlangıç");
        NNetWorkhundred1.Train(aray, 0.01, 100);
//        NNetWorkten.Output("Eğiitim");
        NNetWorkhundred1.Test(aray);
//        NNetWorkten.Output("tset10");

//        NNetWorkhundred1.Output("dsad");
    }

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
//        System.out.println("-------------");
        String arr1=arr.strip();
//        System.out.println(arr1);
//        System.out.println("-------------");
        String[] rawData = arr1.split("\n");

//        System.out.println(Arrays.toString(rawData));
//        System.out.println(rawData.length);

        for (String line:rawData) {
            String[] lineData = line.split(",");
//        	System.out.println(Arrays.toString(lineData));
            RawDataset.add(lineData);
        }
//        ArrayList<String[]> arr2 = ShuffleArray(RawDataset);

        return RawDataset;
    }

    public static ArrayList<String []> ShuffleArray(ArrayList<String []> RawDatasetX){
        ArrayList<String []> RawDataset1 = new ArrayList<String []>();
        Random rnd = new Random();
        for (int i=0;i<150;i++) {
            int randNm = rnd.nextInt(RawDatasetX.size());
            RawDataset1.add(RawDatasetX.get(randNm));
            RawDatasetX.remove(randNm);


        }



        return  RawDataset1;
    }
}
