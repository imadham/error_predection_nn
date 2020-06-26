package usingneuralnetwork;

import interfaces.ConvertBase;
import interfaces.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;
import org.neuroph.util.random.WeightsRandomizer;
import workwithdata.ConvertBaseImpl;

import java.util.Random;

public class Perceptron implements NeuralNetwork {

    private MultiLayerPerceptron ann;
    private ConvertBase convert;

    public Perceptron(int firstLayer, int secondLayer, int thirdLayer, boolean randomizeWeights, double learningRate, int maxIterations) {

        this.ann= new MultiLayerPerceptron(TransferFunctionType.SIGMOID, firstLayer, secondLayer, thirdLayer);

        ann.randomizeWeights(new WeightsRandomizer(new Random(13)));

        ann.getLearningRule().setLearningRate(learningRate);

        ann.getLearningRule().setMaxIterations(maxIterations);

        convert = new ConvertBaseImpl();
    }

    public Perceptron(int firstLayer, int secondLayer, int thirdLayer) {

        this.ann= new MultiLayerPerceptron(TransferFunctionType.SIGMOID, firstLayer, secondLayer, thirdLayer);

        ann.randomizeWeights(new WeightsRandomizer(new Random(13)));

        ann.getLearningRule().setLearningRate(0.1);

        ann.getLearningRule().setMaxIterations(1000);

        convert = new ConvertBaseImpl();
    }


    @Override
    public void trainNetwork(DataSet ds) {
        ann.learn(ds);
    }

    @Override
    public double[] useNeuralNetwork(double[][] input) {

        double[] networkOutputOne;

        int size=input[0].length;

        double[] output = new double[size];

        for(int i=0; i<size;i++)
        {  double[] temp = new double[4];
            temp[0]=input[0][i]/10;
            temp[1]=input[1][i]/10;
            temp[2]=input[2][i]/10;
            temp[3]=input[3][i]/10;
            ann.setInput(temp);
            ann.calculate();
            networkOutputOne = ann.getOutput();
            output[i] = convert.getInteger(networkOutputOne);
    }

        return output;
    }

    public double test(double[] input){
        double[] networkOutputOne;
        double output;

 double[] temp = new double[4];
            temp[0]=input[0]/10;
            temp[1]=input[1]/10;
            temp[2]=input[2]/10;
            temp[3]=input[3]/10;
            ann.setInput(temp);
            ann.calculate();
            networkOutputOne = ann.getOutput();
            output = convert.getInteger(networkOutputOne);

        return output;
    }


}
