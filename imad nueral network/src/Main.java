import GUI.UsingNetwork;
import interfaces.PrintingInterface;
import interfaces.TrainingSet;
import org.neuroph.core.data.DataSet;
import showresult.PrintingImpl;
import usingneuralnetwork.Perceptron;
import workwithdata.CreateDataSet;
import workwithdata.WorkWithExcel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {




        TrainingSet excel = new WorkWithExcel(); // create new excel training set object

        String source = "d:\\data.xlsx"; // data source
        double[][] data;
        data = excel.getDataSet(source); //load data

        CreateDataSet cds = new CreateDataSet(4, 7); //create dataset  object

        double[] output = data[4];
        double[][] input = new double[4][14];

        for (int i = 0; i < 4; i++) input[i] = data[i]; //split data set into input and output

        DataSet ds = cds.getDataSet(input, output); // create dataset

        System.out.println(ds); //print dataset

        Perceptron ann = new Perceptron(4, 6, 7,true,0.1,10000); //create neural network with parameters

        ann.trainNetwork(ds); // train network

        //ann.loadNeuralNetwork("d:\\nn\\a"); //load already trained dataset

        double[] result;

        result = ann.useNeuralNetwork(input); // test neural network

        System.out.println(ds);

        PrintingInterface printingInterface = new PrintingImpl();

        printingInterface.printAll(input, output, result); // print result

        //ann.saveNeuralNetwork("d:\\nn\\a"); // save neural network

        final Perceptron ann2 = ann;

        UsingNetwork GUI = new UsingNetwork(ann2);
        JFrame frm = new JFrame();
        frm.setSize(500,300);
        frm.setContentPane(GUI.getPanel1());
        frm.setVisible(true);

    }
}
