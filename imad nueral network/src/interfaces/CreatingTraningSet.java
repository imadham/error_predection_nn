package interfaces;

import org.neuroph.core.data.DataSet;

public interface CreatingTraningSet {

    DataSet getDataSet(double[][] data, double[] output);
}
