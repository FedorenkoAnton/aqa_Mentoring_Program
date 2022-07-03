package selenium_pages;

public class HomePage extends BasePage {

    private String documentationButton = "[href='/documentation']";
    private String projectButton = "//a[@href='/projects']";
    private String dropdownAbout = "//li[@class='nav-item dropdown']";
    private String eventsFromDropdown = "//a[@href='/events']";

    public String getDocumentationButton() {
        return documentationButton;
    }

    public String getProjectButton() {
        return projectButton;
    }

    public String getDropdownAbout() {
        return dropdownAbout;
    }

    public String getEventsFromDropdown() {
        return eventsFromDropdown;
    }
}
