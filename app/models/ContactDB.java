package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mockup database for the contacts.
 * Created by Jack on 3/14/2015.
 */
public class ContactDB {

  private static Map<Long, Contact> contacts = new HashMap<>();
  private static long currentID = 1;

  private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  private static Map<String, DietType> dietTypes = new HashMap<>();

  /**
   * Adds a contact to the contact database. If form id is 0, new id is created.
   * Otherwise, previous id contact is updated.
   *
   * @param formData Form data for a contact.
   */
  public static void addContact(ContactFormData formData) {
    long idValue = (formData.id == 0) ? currentID++ : formData.id;
    TelephoneType telephoneType = getTelephoneType(formData.telephoneType);


    List<DietType> dietTypes = new ArrayList<>();
    for (String dietString : formData.dietTypes) {
      dietTypes.add(getDietType(dietString));
    }

    Contact contact = new Contact(idValue, formData.firstName, formData.lastName, formData.telephone,
        telephoneType, dietTypes);
    contacts.put(idValue, contact);
  }


  /**
   * Returns associated contact with id. Throws exception if id is not found.
   *
   * @param id The id.
   * @return The contact.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Can not find associated id.");
    }
    return contact;
  }

  /**
   * Gets the list of contacts.
   *
   * @return The contact list.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }


  /**
   * Updates the database with a new telephone type.
   *
   * @param telephoneType -The telephone type to add.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneTypes.put(telephoneType.getTelephoneType(), telephoneType);
  }


  /**
   * Updates the database with a new diet type.
   *
   * @param dietType -The diet type to add.
   */
  public static void addDietType(DietType dietType) {
    dietTypes.put(dietType.getDietType(), dietType);
  }

  /**
   * Returns the telephone type with the typeString or throws exception if not found.
   *
   * @param typeString The telephone type.
   * @return The instance if found.
   */
  public static TelephoneType getTelephoneType(String typeString) {
    TelephoneType telephoneType = telephoneTypes.get(typeString);
    if (telephoneType == null) {
      throw new RuntimeException("Illegal telephone type: " + typeString);
    }
    return telephoneType;
  }

  /**
   * Returns the diet type with the typeString or throws exception if not found.
   *
   * @param typeString The diet type.
   * @return The instance if found.
   */
  public static DietType getDietType(String typeString) {
    DietType dietType = dietTypes.get(typeString);
    if (dietType == null) {
      throw new RuntimeException("Illegal telephone type: " + typeString);
    }
    return dietType;
  }
}
