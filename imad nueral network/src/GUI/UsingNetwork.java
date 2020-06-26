package GUI;

import usingneuralnetwork.Perceptron;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsingNetwork {
    private JPanel panel1;
    private JTable table1;
    private JButton рассчитатьПрцентОтказаButton;
    private final Perceptron ann;



    public UsingNetwork(Perceptron ann1) {
        this.ann = ann1;

        рассчитатьПрцентОтказаButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                double[] state = new double[4];
                String temp;
                double res;

                for(int i=0;i<4;i++)
                    state[i]=(double)Integer.parseInt(table1.getValueAt(i,1).toString());
                res = ann.test(state);


                for(int i=1;i<5;i++){
                    temp =("процент отказа в"+i+"-й день");
                    table1.setValueAt(temp,i-1,0);
                    if(res >100)res=100;
                    temp = String.format("%.5f", res);
                    table1.setValueAt(temp,i-1,1);
                    if(i!=1)res = res*i*0.765;
                    else res*=(i*1.217);
                }


            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }



    private void createUIComponents() {
        String[][] data = {
                {"состояние 1-го фактора", ""},
                {"состояние 2-го фактора", ""},
                {"состояние 3-го фактора", ""},
                {"состояние 4-го фактора", ""}
        };
        String[] columnNames = { "состояния факторов", "от 1 до 100"};
        table1 = new JTable(data,columnNames);

    }

}
