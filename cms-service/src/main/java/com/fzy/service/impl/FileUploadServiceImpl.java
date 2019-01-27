package com.fzy.service.impl;

import com.fzy.exception.ServiceException;
import com.fzy.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: FileUploadServiceImpl
 * @description:
 * @author: fzy
 * @date: 2019-01-27 13:30
 **/
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public void fileUpload(MultipartFile file) throws Exception {
        //获取当前上传文件后缀
        String fileSuffix =file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        Workbook wb= null;
        if(fileSuffix.equals(".xlsx")){
            wb = new XSSFWorkbook(file.getInputStream());
        }else if (fileSuffix.equals(".xls")){
            wb = new HSSFWorkbook(file.getInputStream());
        }
        //获取sheet个数
        int numberOfSheets = wb.getNumberOfSheets();
        if(numberOfSheets<1){
            throw new ServiceException("sheet not is zero");
        }

        //获取sheet
        Sheet sheet = wb.getSheetAt(0);

        //获取全部行数
        int ofRows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i <ofRows ; i++) {
            Row row = sheet.getRow(i);
            //获取当前行的列数
            int physicalNumberOfCells = row.getPhysicalNumberOfCells();
            for (int j = 0; j < physicalNumberOfCells; j++) {
                Cell cell = row.getCell(j);
                System.out.println(getValue(cell));
            }
        }
    }


    /**
     * 数据转换
     * @param cell
     * @return
     */
    private String getValue(Cell cell) {
        switch (cell.getCellTypeEnum()){
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)){
                    return new SimpleDateFormat("yyyy/MM/dd").format(cell.getDateCellValue());
                }else{
                    return String.valueOf(cell.getNumericCellValue());
                }
            case FORMULA:
                return cell.getCellFormula();
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            case BLANK:
                return "";
            default: return null;
        }
    }

}
