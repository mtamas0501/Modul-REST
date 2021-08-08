package hu.ulyssys.java.course.javaee.demo.service.impl;

import hu.ulyssys.java.course.javaee.demo.entity.Car;
import hu.ulyssys.java.course.javaee.demo.service.CarService;
import hu.ulyssys.java.course.javaee.demo.service.XLSExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class XLSExportServiceImpl implements XLSExportService {
    @Inject
    private CarService carService;

    @Override
    public void processExport() {

        //https://poi.apache.org/components/spreadsheet/quick-guide.html
        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet carSheet = wb.createSheet("Car");

        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setCharSet(FontCharset.ARABIC.getValue());
        font.setBold(true);
        style.setFont(font);

        Row headerRow = carSheet.createRow(0);
        Cell id = headerRow.createCell(0);
        id.setCellValue("ID");
        id.setCellStyle(style);

        Cell manufacturer = headerRow.createCell(1);
        manufacturer.setCellValue("Név");
        manufacturer.setCellStyle(style);

        Cell vehicleType = headerRow.createCell(2);
        vehicleType.setCellValue("Jármű tipusa");
        vehicleType.setCellStyle(style);

        Cell type = headerRow.createCell(3);
        type.setCellValue("Kocsi típusa");
        type.setCellStyle(style);


        int i = 1;
        for (Car car : carService.getAll()) {
            Row row = carSheet.createRow(i);
            row.createCell(0).setCellValue(car.getId());
            row.createCell(1).setCellValue(car.getManufacturer());
            row.createCell(2).setCellValue(car.getVehicleType().toString());
            row.createCell(3).setCellValue(car.getType());
            i++;
        }

        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}