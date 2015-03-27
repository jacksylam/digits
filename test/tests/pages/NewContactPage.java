package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides testing support for the Index page.
 *
 * @author Philip Johnson
 */
public class NewContactPage extends FluentPage {
  private String url;

  /**
   * Create the IndexPage.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newcontact";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("New Contact digits");
  }


  /**
   * Creates a new contact with specific first name, last name, and telephone number.
   * Will also submit the forms.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   */
  public void createContact(String firstName, String lastName, String telephone) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#telephone").with(telephone);
    submit("#submit");
  }
}
