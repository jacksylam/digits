package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.NewContactPage;

import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {
  /**
   * The port to be used for testing.
   */
  private final int port = 3333;

  /**
   * Check to see that both the index page can be retrieved.
   */
  @Test
  public void testRetrieveIndexPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            IndexPage indexPage = new IndexPage(browser.getDriver(), port);
            browser.goTo(indexPage);
            indexPage.isAt();
          }
        });
  }

  /**
   * Checks to see if NewContactPage can create a new contact and show in the index page.
   */
  @Test
  public void testCreateNewContact() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            browser.maximizeWindow();
            IndexPage indexPage = new IndexPage(browser.getDriver(), port);
            NewContactPage newContactPage = new NewContactPage(browser.getDriver(), port);
            browser.goTo(newContactPage);
            newContactPage.isAt();
            String firstName = "Bob";
            String lastName = "Smith";
            String telephone = "808-555-6666";
            newContactPage.createContact(firstName, lastName, telephone);
            browser.goTo(indexPage);
            indexPage.hasContact(firstName, lastName, telephone);
          }
        });
  }

}
