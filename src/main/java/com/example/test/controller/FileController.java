package com.example.test.controller;

import com.example.test.dao.FileDto;
import com.example.test.entity.Nbfile;
import com.example.test.repository.FileRepository;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @GetMapping("/readfile")
    public String readFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\excel.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        //List<FileDto> files = new ArrayList<>();

        HSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        for(int i = 0; i<rows; i++){
            HSSFRow row = sheet.getRow(i);
            if(row != null){

                int cells = row.getPhysicalNumberOfCells();
                for(int j = 0; j<cells; j++){
                    HSSFCell cell = sheet.getRow(i).getCell(j);
                    String each = "";
                    if(cell == null){
                        continue;
                    } else {
                        String [] values = cell.getStringCellValue().split(",");
                        fileRepository.save(new Nbfile(values[0], values[1], values[2]));
                    }
                    System.out.println("each = " + each);
                }
            }
        }
//        fileRepository.save(files);
        return "file";
    }
}
