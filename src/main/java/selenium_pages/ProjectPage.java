package selenium_pages;

public class ProjectPage {
    private String seleniumWebDriverBlock = "//div[contains(@class,'alert alert-webdriver')]//h2[@class='alert-heading pb-3']";
    private String seleniumIdeBlock = "//div[contains(@class,'alert alert-blue')]//h2[@class='alert-heading pb-3']";
    private String seleniumGridBlock = "//div[contains(@class,'alert alert-purple')]//h2[@class='alert-heading pb-3']";
    private String sponsorBlock = "//div[@class='col-lg-3 col-md-6 mb-4 mb-lg-0 align-self-center px-5 py-3']";

    public String getSeleniumWebDriverBlock() {
        return seleniumWebDriverBlock;
    }

    public String getSeleniumIdeBlock() {
        return seleniumIdeBlock;
    }

    public String getSeleniumGridBlock() {
        return seleniumGridBlock;
    }

    public String getSponsorBlock() {
        return sponsorBlock;
    }
}
