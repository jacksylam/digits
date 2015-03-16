package models;

/**
 * Model for contacts.
 * Created by Jack on 3/14/2015.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private String address;

  /**
   * Creates a model of a contact.
   *
   * @param firstName The first name.
   * @param lastName  The second name.
   * @param telephone The telephone number.
   * @param address The address.
   *
   */
  public Contact(String firstName, String lastName, String telephone, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.address = address;
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
   * Gets telephone number.
   *
   * @return Telephone number.
   */
  public String getTelephone() {
    return telephone;
  }


  /**
   * Gets address.
   *
   * @return Address.
   */
  public String getAddress() {
    return address;
  }
}
