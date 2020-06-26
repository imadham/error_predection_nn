package interfaces;

        import java.io.IOException;

public interface TrainingSet {

    double[][] getDataSet(String source) throws IOException;
}
