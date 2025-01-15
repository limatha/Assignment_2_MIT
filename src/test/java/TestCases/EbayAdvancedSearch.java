package TestCases;

import BaseClass.BaseTest;
import Pages.AdvanceSearchPage;
import Pages.HomePage;
import Utils.ExcelHandler;
import Utils.TakeErrorScreenShots;
import org.testng.annotations.Test;

public class EbayAdvancedSearch extends BaseTest {

    @Test
    public void advancedSearchOption() {

        HomePage homePage = new HomePage(driver);
        AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testdata/TestData.xlsx";
        String sheetName = "Data";

        // Initialize ExcelUtils
        ExcelHandler excel = new ExcelHandler(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(5, 1); // Row 1, Column 1
        System.out.println("ths is the selection"+mobileBrand);
        setReportName("Advanced Search Scenario- Test Case 8");
        startTest("Advanced Search Scenario- Test Case 8");
        homePage.advancedSearchFor();
        test = extent.createTest("Successfully Navigated to Advanced Searched", "System Successfully Navigated to Advanced Searched");
        String screenshotPath1 = TakeErrorScreenShots.takeScreenshot(driver, "Success Navigated to Advanced Searched");
        test.pass("System Successfully Navigated to Advanced Searched").addScreenCaptureFromPath(screenshotPath1);
        advanceSearchPage.advanceSearchFor(mobileBrand);
        test = extent.createTest("Initiating the advance search ", "System Successfully Initiating the advance search");
        String screenshotPath2 = TakeErrorScreenShots.takeScreenshot(driver, "Initiating the advance search");
        test.pass("System Successfully Initiating the advance search").addScreenCaptureFromPath(screenshotPath2);
        advanceSearchPage.advancedSearchClick();
        test = extent.createTest("Done the advance search ", "System Successfully Done the advance search");
        String screenshotPath3 = TakeErrorScreenShots.takeScreenshot(driver, "Done the advance search");
        test.pass("System Successfully Done the advance search").addScreenCaptureFromPath(screenshotPath3);
        // Write data back to the Excel file
        excel.setCellData(5, 2, "Samsung is the phone", excelFilePath);

        // Step 3: Proceed to add To search Results
        test = extent.createTest("Successfully Searched", "Successfully Searched");
        String screenshotPath4 = TakeErrorScreenShots.takeScreenshot(driver, "Successfully Searched");
        test.pass("System Successfully Searched").addScreenCaptureFromPath(screenshotPath4);

        // Close workbook
        excel.closeWorkbook();
    }


}
