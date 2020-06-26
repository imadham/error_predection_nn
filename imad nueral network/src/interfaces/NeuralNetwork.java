package interfaces;

import org.neuroph.core.data.DataSet;

public interface NeuralNetwork {

    void trainNetwork(DataSet ds);

    double[] useNeuralNetwork(double[][] input);

}
