package Rest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName)
            throws Exception {

        FileInputStream fis = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();

        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                Cell cell = sheet.getRow(i).getCell(j);

                data[i - 1][j] = formatter.formatCellValue(cell);
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}