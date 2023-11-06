package pageActions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BaseClass;

public class Date extends BaseClass {

	public static void setTodayDate(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");

		LocalDate today = LocalDate.now();
		String formattedDate = today.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		driver.findElement(By.xpath("//input[@formcontrolname='startDate']"));
		jsExecutor.executeScript(script, element, formattedDate);
	}

	public static void setTodayDate(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");

		LocalDate today = LocalDate.now();
		String formattedDate = today.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='startDate']")),
				formattedDate);
	}

	public static void setTomorrowDate(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
		String formattedDate = tomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='endDate']")),
				formattedDate);
	}

	public static String todayDate() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(formatter);
		return formattedDate;
	}

	public static void setTomorrowDate(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
		String formattedDate = tomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";

		jsExecutor.executeScript(script, element, formattedDate);

		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='endDate']")),
				formattedDate);
	}

	public static void setDayAfterTomorrowDate(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate tomorrow = LocalDate.now().plusDays(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
		String formattedDate = tomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		jsExecutor.executeScript(script, element, formattedDate);
	}

}
