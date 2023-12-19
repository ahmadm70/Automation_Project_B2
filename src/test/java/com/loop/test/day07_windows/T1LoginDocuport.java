package com.loop.test.day07_windows;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtilities;
import org.testng.annotations.Test;

public class T1LoginDocuport extends TestBase{
    @Test
    public void test_login_logout_docuport() throws InterruptedException {
        DocuportUtilities.login(driver, DocuportConstants.ADVISOR);
        DocuportUtilities.logout(driver);
        DocuportUtilities.login(driver, DocuportConstants.CLIENT);
        DocuportUtilities.logout(driver);
        DocuportUtilities.login(driver, DocuportConstants.EMPLOYEE);
        DocuportUtilities.logout(driver);
        DocuportUtilities.login(driver, DocuportConstants.SUPERVISOR);
        DocuportUtilities.logout(driver);
    }
}