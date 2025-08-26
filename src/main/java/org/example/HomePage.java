package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    By inventoryItem = By.xpath("//*[@data-test='inventory-item']");
    By inventoryItemName = By.xpath("//*[@data-test='inventory-item-name']");
    By inventoryItemPrice = By.xpath("//*[@data-test='inventory-item-price']");
    By inventoryItemAddToCard = By.xpath("//button[text()='Add to cart']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllProductNames(){
        List<String> itemNames = new ArrayList<>();
        List<WebElement> allElements = this.getAllElements(inventoryItemName);
        for(WebElement e : allElements){
               itemNames.add(e.getText());
        }
        return itemNames;
    }

    public float getItemPrice(String itemName) {
        WebElement item = getItemWithName(itemName);
        return Float.parseFloat(item.findElement(inventoryItemPrice).getText().replace("$", ""));
    }

    public boolean addItemToCart(){
        return true;
    }

    private WebElement getItemWithName(String itemName){
        return this.getAllElements(inventoryItem).stream()
                .filter(e -> e.findElement(inventoryItemName).getText().equals(itemName))
                .findFirst()
                .orElseThrow();
    }
}
