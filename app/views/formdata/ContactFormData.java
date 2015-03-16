package views.formdata;

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
   * The address.
   */
  public String address = "";

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

    if (address == null || address.length() == 0) {
      errors.add(new ValidationError("address", "Address is required."));
    }

    if (address.length() < 24) {
      errors.add(new ValidationError("address", "Address should be at least 24 characters long."));
    }

    return errors.isEmpty() ? null : errors;
  }

}
