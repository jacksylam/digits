package models;

import java.util.List;

/**
 * Model for contacts.
 * Created by Jack on 3/14/2015.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private long id;
  private String telephoneType;
  private List<String> dietTypes;




  /**
   * Creates a model of a contact.
   *
   * @param id            The id.
   * @param firstName     The first name.
   * @param lastName      The second name.
   * @param telephone     The telephone number.
   * @param telephoneType The telephone type.
   * @param dietTypes     The diet types.

   */
  public Contact(long id, String firstName, String lastName, String telephone, String telephoneType, List<String> dietTypes) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * Gets first name.
   *
   * @return First name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets last name.
   *
   * @return Last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Gets telephone type.
   *
   * @return Telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }


  /**
   * Gets telephone number.
   *
   * @return Telephone number.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Gets the id.
   *
   * @return Id.
   */
  public long getId() {
    return id;
  }

  /**
   * Gets the diet types.
   * @return The diet types.
   */
  public List<String> getDietTypes() {
    return dietTypes;
  }
}
