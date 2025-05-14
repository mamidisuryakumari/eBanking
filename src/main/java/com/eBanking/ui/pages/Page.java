package com.eBanking.ui.pages;

import org.openqa.selenium.WebDriver;

import com.eBanking.ui.engine.Bot;
import com.eBanking.ui.engine.BrowserFactory;

public abstract class Page {
	
	public final Bot bot = BrowserFactory.getBot();
	public final WebDriver driver = BrowserFactory.getDriver();

}
