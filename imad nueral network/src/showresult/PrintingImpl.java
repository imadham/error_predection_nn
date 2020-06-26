package showresult;

import interfaces.PrintingInterface;

public class PrintingImpl implements PrintingInterface {

    @Override
    public void printResult(double[] result) {

        System.out.println("\nNetwork output: ");
        for(double i : result)
            System.out.print(String.format("%5.1f\t", i));

    }

    @Override
    public void printInput(double[][] input) {

        System.out.println("\nFirst Input:");
        for(double i: input[0])
            System.out.print(String.format("%5.1f\t", i));

        System.out.println("\nSecond Input:");
        for(double i: input[1])
            System.out.print(String.format("%5.1f\t", i));

        System.out.println("\nThird Input:");
        for(double i: input[2])
            System.out.print(String.format("%5.1f\t", i));

        System.out.println("\nFourth Input:");
        for(double i: input[3])
            System.out.print(String.format("%5.1f\t", i));

    }

    @Override
    public void printOutput(double[] output) {

        System.out.println("\noutput:");
        for(double i: output)
            System.out.print(String.format("%5.1f\t", i));

    }

    @Override
    public void printAll(double[][] input, double[] output, double[] result) {

        printInput(input);
        printOutput(output);
        printResult(result);

    }
}
