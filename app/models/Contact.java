package models;

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


  /**
   * Creates a model of a contact.
   *
   * @param id            The id.
   * @param firstName     The first name.
   * @param lastName      The second name.
   * @param telephone     The telephone number.
   * @param telephoneType The telephone type.
   */
  public Contact(long id, String firstName, String lastName, String telephone, String telephoneType) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
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
}
