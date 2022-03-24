package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CategoriesPage extends Page{
    @Step ("Переход на страницу Смартфони, ТВ і Електроніка")
    public void goToPageTelefonyTvEhlektronika(){
       $(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[2]")).click();
        System.out.println("Переход на страницу Смартфони, ТВ і Електроніка");
    }



    @Step ("Переход на страницу Смартфони")
    public void goToPageMobilePhones(){
        $(By.xpath("//section[@class='portal-section']/ul/li[1]")).click();
        System.out.println("Переход на страницу Смартфони");
    }
    @Step ("Переход на страницу Телевизоры")
    public void goToPageTv(){
        $(By.xpath("//section[@class='portal-section']/ul/li[2]")).click();
        System.out.println("Переход на страницу Телевизоры");
    }
}
