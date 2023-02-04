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
    private static Workbook workbook;
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

        Object[][] productNames = new Object[rowCount][1];

        for(int i=0; i<rowCount; i++){
            productNames[i][0] = sheet.getRow(i).getCell(0).getStringCellValue();
        }

        return productNames;
    }

    public Object[][] exampleClients() {
    return exampleClients(100);
    }

    public Object[][] exampleClients(int max) {
        Sheet sheet = workbook.getSheetAt(2);

        int rowCount = sheet.getLastRowNum();
        if( rowCount > max ) rowCount = max;
        Object[][] clients = new Object[rowCount][8];

        for(int i=0; i<rowCount; i++){
            int j = i+1; // omits header row
            clients[i][0] = sheet.getRow(j).getCell(0).toString();
            clients[i][1] = sheet.getRow(j).getCell(1).toString();
            clients[i][2] = sheet.getRow(j).getCell(2).toString();
            clients[i][3] = sheet.getRow(j).getCell(3).toString();
            clients[i][4] = sheet.getRow(j).getCell(4).toString();
            clients[i][5] = sheet.getRow(j).getCell(5).toString();
            clients[i][6] = sheet.getRow(j).getCell(6).toString();
            clients[i][7] = sheet.getRow(j).getCell(7).toString();
        }

        return clients;
    }

}
