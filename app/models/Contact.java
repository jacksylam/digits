package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Model for contacts.
 * Created by Jack on 3/14/2015.
 */
@Entity
public class Contact extends Model {
  private String firstName;
  private String lastName;
  private String telephone;
  @Id
  private long id;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private TelephoneType telephoneType;

  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<DietType> dietTypes;


  /**
   * Creates a model of a contact.
   *
   * @param firstName     The first name.
   * @param lastName      The second name.
   * @param telephone     The telephone number.
   * @param telephoneType The telephone type.
   * @param dietTypes     The diet types.
   */
  public Contact(String firstName, String lastName, String telephone,
                 TelephoneType telephoneType, List<DietType> dietTypes) {
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
  public TelephoneType getTelephoneType() {
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
   *
   * @return The diet types.
   */
  public List<DietType> getDietTypes() {
    return dietTypes;
  }


  /**
   * Gets the diet types as a string.
   *
   * @return The diet types as a string.
   */
  public String getDietTypesString() {
    String diets = "";
    for (DietType diet : dietTypes) {
      diets += diet.getDietType() + ",";
    }
    if (diets.length() == 0) {
      return diets;
    }
    else {
      return diets.substring(0, diets.length() - 1);
    }
  }

  /**
   * Sets the first name.
   *
   * @param firstName The first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Sets the last name.
   *
   * @param lastName The last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Sets the telephone.
   *
   * @param telephone The telephone.
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Sets the id.
   *
   * @param id the id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Sets the telephone type.
   *
   * @param telephoneType The telephone type.
   */
  public void setTelephoneType(TelephoneType telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Sets the diet types.
   *
   * @param dietTypes The diet types.
   */
  public void setDietTypes(List<DietType> dietTypes) {
    this.dietTypes = dietTypes;
  }

  /**
   * Returns a list of diet types strings for this contact.
   *
   * @return The list of diet type strings.
   */
  public List<String> getDietTypesList() {
    List<String> dietList = new ArrayList<>();
    for (DietType dietType : this.dietTypes) {
      dietList.add(dietType.getDietType());
    }
    return dietList;
  }

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }
}
