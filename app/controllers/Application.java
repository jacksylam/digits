package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.DietTypes;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;

import java.util.Map;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns New contact page.
   *
   * @param id The id.
   * @return The NewContact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
    Map<String, Boolean> dietTypeMap = DietTypes.getTypes(data.dietTypes);
    return ok(NewContact.render(formData, telephoneTypeMap, dietTypeMap));
  }

  /**
   * Processes form fields from new contacts page.
   *
   * @return The NewContact.
   */
  public static Result postContact() {
    System.out.println("In post Contact.");
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Form has errors.");
      return badRequest(NewContact.render(formData, TelephoneTypes.getTypes(), DietTypes.getTypes()));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      System.out.println(data.firstName + " " + data.lastName + " " + data.telephone + " " + data.telephoneType);
      return ok(NewContact.render(formData, TelephoneTypes.getTypes(data.telephoneType), DietTypes.getTypes(data.dietTypes)));
    }
  }
}