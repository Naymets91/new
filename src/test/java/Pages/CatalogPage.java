package Pages;

import Set.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage extends Page{
    String nameProductPage;
    Integer priceProductPage;

    Product produrt = new Product();

@Step ("Выбор рандомного товара")
    public void selectProduct(){
        Integer sizeProduct =$$(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li")).size();
        Integer randomProduct = getRandomNumber(1, sizeProduct);

        print("Количество товаров = " + sizeProduct);
        System.out.println("");
        print("Выбран товар № " + randomProduct);

        parsDate(randomProduct);
        goToProductPage(randomProduct);
    }

    @Step("Информация о товаре на странице товара")
    public void parsDataPageProduct() {
        nameProductPage = parsName();
        priceProductPage = parsPrice();
        System.out.println("");

        makeScreenshot("Screen");
    }

    @Step ("Сравнения даных о товаре в каталоге и на странице товара")
    public void equalsData() {
        equalsName();
        equalsPrice();
    }

    public void equalsPrice() {
        if ( produrt.getPrice().equals(priceProductPage)){
            print("Ожидаемый результат = " + produrt.getPrice() + "  " + "Фактический результат = " + priceProductPage);
            makeScreenshot("screen");
        }else {
            print("Ожидаемый результат = " + produrt.getPrice() + "  " + "Фактический результат = " + priceProductPage);
            makeScreenshot("screen");
            throw new Error();
        }
    }

    public void equalsName() {
        if ( produrt.getName().equals(nameProductPage)){
            print("Ожидаемый результат = " + produrt.getName() + "  " + "Фактический результат = " + nameProductPage);
            makeScreenshot("screen");
        }else {
            print("Ожидаемый результат = " + produrt.getName() + " !!!!!! " + "Фактический результат = " + nameProductPage);
            makeScreenshot("screen");
            throw new Error();
        }
    }

    private String parsName() {
        String name = $(By.xpath("//h1[@class='product__title']")).getText();
        print("Название товара = " + name);
        return name;
    }
    public Integer parsPrice() {
        String tempPrice = $(By.xpath("//div[@class='product-prices__inner ng-star-inserted']/p")).getText();
        tempPrice = tempPrice.replace(" ","");
        tempPrice = tempPrice.substring(0, tempPrice.indexOf("₴"));
        print("Цена товара = " + tempPrice);
        return Integer.valueOf(tempPrice);
    }


    public void parsDate(Integer randomProduct){
        String name = parsName(randomProduct);
        Integer price = parsPrice(randomProduct);

        produrt.setName(name);
        produrt.setPrice(price);


        makeScreenshot("Screen");
    }


    public String parsName(Integer randomProduct) {
        String tempName = $(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li[" + randomProduct +"]//span[@class='goods-tile__title']")).getText();
        print("Название товара = " + tempName);
        return tempName;
    }
    public Integer parsPrice(Integer randomProduct) {
        String tempPrice = $(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li[" + randomProduct +"]//span[@class='goods-tile__price-value']")).getText();
        $(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li[" + randomProduct +"]//span[@class='goods-tile__price-value']")).click();
        tempPrice = tempPrice.replace(" ","");
        print("Цена товара = " + tempPrice);
        return Integer.valueOf(tempPrice);
    }

    private void goToProductPage(Integer randomProduct) {
        $(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li[" + randomProduct +"]//span[@class='goods-tile__title']")).click();
        System.out.println("");
        System.out.println("Переход на страницу с товаром");
    }


}
