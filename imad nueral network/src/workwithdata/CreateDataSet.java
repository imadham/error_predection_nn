package workwithdata;

import interfaces.ConvertBase;
import interfaces.CreatingTraningSet;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

import static java.lang.Math.round;

public class CreateDataSet implements CreatingTraningSet {
    DataSet ds;
    ConvertBase convert;


    public CreateDataSet(int inputSize, int outputSize) {
        this.ds = new DataSet(inputSize, outputSize);
        convert = new ConvertBaseImpl();
    }

    @Override
    public DataSet getDataSet(double[][] data, double[] output) {


        int size = data[0].length;

        for(int i=0; i<size;i++)
        {
            double[] temp = new double[4];
            temp[0]=data[0][i]/10;
            temp[1]=data[1][i]/10;
            temp[2]=data[2][i]/10;
            temp[3]=data[3][i]/10;
            double[] o = new double[7];

            o=convert.getBinarry((int) round(output[i]));

            DataSetRow row = new DataSetRow(temp,o);

            ds.addRow(row);
        }

        return ds;
    }
}
