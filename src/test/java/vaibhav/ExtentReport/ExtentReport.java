package vaibhav.ExtentReport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {


    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {

            String folderPath=System.getProperty("user.dir") + "\\AutomationReport";

            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String reportPath = System.getProperty("user.dir") + "\\AutomationReport\\ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

             extent.setSystemInfo("Tester", "Vaibhav Dubey");
             extent.setSystemInfo("Environment", "QA");
        }
        return extent;

    }

}
