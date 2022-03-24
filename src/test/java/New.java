import Config.SetupClass;
import Config.SetupMetod;
import Pages.CatalogPage;
import Pages.CategoriesPage;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class New {
    SetupClass setupClass = new SetupClass();
    SetupMetod setupMetod = new SetupMetod();
    CatalogPage catalogPg = new CatalogPage();
    CategoriesPage categoriesPg = new CategoriesPage();


    @BeforeClass
    public void setUpBeforeClass() {
        setupClass.startClass(true);
    }

    @BeforeMethod
    public void setUpBeforeMethod() {
        setupMetod.startMethod();
    }

    @Test
    public void checkingDataOnTheCatalogPageAndProductCard() {
        categoriesPg.goToPageTelefonyTvEhlektronika();
        categoriesPg.goToPageTv();
        catalogPg.selectProduct();
        catalogPg.parsDataPageProduct();
        catalogPg.equalsData();
    }


    @AfterMethod
    public void afterMethod(ITestResult testResult, final Method method) {
        setupMetod.finishMethod(testResult, method);
    }

    @AfterClass
    public void afterClass() {
        setupClass.finishClass();
    }

}
