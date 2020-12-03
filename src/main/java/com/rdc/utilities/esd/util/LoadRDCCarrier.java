package com.rdc.utilities.esd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rdc.utilities.esd.model.RDCCarriers;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadRDCCarrier {
    public LoadRDCCarrier() {
    }

    public String loadcarriers(String filepath){
        List<RDCCarriers> carriers = readExcelFile(filepath);
        String jsonString = convertObjects2JsonString(carriers);

       // System.out.println(jsonString);
        return jsonString;
    }


    /**
     * Read Excel File into Java List Objects
     *
     * @param filePath
     * @return
     */
    public List<RDCCarriers> readExcelFile(String filePath){
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);

            Sheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rows = sheet.iterator();

            List<RDCCarriers> carriers = new ArrayList<RDCCarriers>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if(rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                RDCCarriers carrier = new RDCCarriers();

                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if(cellIndex==0) { // ID
                        carrier.setCarrierID(String.valueOf(currentCell.getNumericCellValue()));
                    } else if(cellIndex==1) { // Name
                        carrier.setCarrierName(currentCell.getStringCellValue());
                    } else if(cellIndex==2) { // Level
                        carrier.setRdcLevel(currentCell.getStringCellValue());
                    }

                    cellIndex++;
                }

                carriers.add(carrier);
            }

            // Close WorkBook
            workbook.close();

            return carriers;
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

    /**
     * Convert Java Objects to JSON String
     *
     * @param customers
     * @param fileName
     */
    private static String convertObjects2JsonString(List<RDCCarriers> carriers) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";

        try {
            jsonString = mapper.writeValueAsString(carriers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}

