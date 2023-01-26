package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataStorage {

    private FileInputStream file;
    private Workbook workbook;
    private String path = "src/test/resources/data.xlsx";

    public DataStorage(){

        try{
            file = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Expected data.xlsx at 'src/test/resources'.");
            throw new RuntimeException(e);
        }

        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Object[][] homePageProductNames(int max){

        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum()+1;
        if( rowCount > max ) rowCount = max;

        System.out.println(rowCount);
        Object[][] productNames = new Object[rowCount][1];

        for(int i=0; i<rowCount; i++){
            productNames[i][0] = sheet.getRow(i).getCell(0).getStringCellValue();
        }

        return productNames;
    }

}
