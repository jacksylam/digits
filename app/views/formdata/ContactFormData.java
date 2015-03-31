package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backend for contact form data.
 * Created by Jack on 3/14/2015.
 */
public class ContactFormData {
  /**
   * The first name.
   */
  public String firstName = "";
  /**
   * The last name.
   */
  public String lastName = "";
  /**
   * The telephone number.
   */
  public String telephone = "";

  /**
   * The telephone type.
   */
  public String telephoneType = "";

  /**
   * The id.
   */
  public long id;

  /**
   * Public no arg constructor for Play.
   */
  public ContactFormData() {
    //no arg constructor
  }

  /**
   * Creates a ContactFormData given a contact.
   *
   * @param contact The contact.
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.telephoneType = contact.getTelephoneType();
    this.id = contact.getId();
  }

  /**
   * Creates a contact given the first name, last name, telephone number, and telephone type.
   * Method used only for testing.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
  }


  /**
   * Validates the form's fields.
   *
   * @return null if valid, list of errors if there are any.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }

    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }

    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }

    if (telephone.length() != 12) {
      errors.add(new ValidationError("telephone", "Telephone should be xxx-xxx-xxxx"));
    }

    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Telephone type is invalid."));
    }

    return errors.isEmpty() ? null : errors;
  }

}
