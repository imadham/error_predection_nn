package workwithdata;

import interfaces.TrainingSet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class WorkWithExcel implements TrainingSet {

    public  double[][] getDataSet (String source) throws IOException {
        File file = new File(source);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        int noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
        double[][] data = new double[5][noOfColumns];
        int i =0;
        int j=-1;
        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext())
        {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case STRING:
                        break;
                    case NUMERIC:
                        data[j][i++]=cell.getNumericCellValue();
                        break;
                    case FORMULA:
                        data[j][i++]=cell.getNumericCellValue();
                        break;
                    default:
                }
            }
            j++;i=0;
        }
        return data;
    }
}
