package FrameWork.TestComponents;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

    @Test(dataProvider = "LoginData")
    public void getDatas(String order, String email, String pass, String msg) {
        System.out.println(email);
    }

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {
        String path = "C:\\Users\\kharb\\eclipse-workspace\\FrameWorkDesign\\testData\\Data.xlsx"; // Path to Excel file

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalrows = xlutil.getRowCount("Data");
        int totalcol = xlutil.getCellCount("Data", 1);

        Object[][] logindata = new Object[totalrows -1][totalcol]; // Adjusting for header row (assuming row 0 is header)

        for (int i = 1; i < totalrows; i++) { // Skipping the header row
            for (int j = 0; j < totalcol; j++) {
            	
                logindata[i - 1][j] = xlutil.getCellData("Data", i, j);
                
            }
        }
        return logindata;
    }
}
