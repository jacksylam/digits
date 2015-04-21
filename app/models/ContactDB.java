package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Mockup database for the contacts.
 * Created by Jack on 3/14/2015.
 */
public class ContactDB {

  //private static Map<Long, Contact> contacts = new HashMap<>();
  //private static long currentID = 1;

  //private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  //private static Map<String, DietType> dietTypes = new HashMap<>();

  /**
   * Adds a contact to the contact database. If form id is 0, new id is created.
   * Otherwise, previous id contact is updated.
   *
   * @param formData Form data for a contact.
   */
  public static void addContact(ContactFormData formData) {
    TelephoneType telephoneType = getTelephoneType(formData.telephoneType);

    List<DietType> dietTypes = new ArrayList<>();
    for (String dietString : formData.dietTypes) {
      dietTypes.add(getDietType(dietString));
    }

    Contact contact = (formData.id == 0) ? new Contact() : Contact.find().byId(formData.id);
    contact.setFirstName(formData.firstName);
    contact.setLastName(formData.lastName);
    contact.setTelephone(formData.telephone);
    contact.setTelephoneType(telephoneType);
    contact.setDietTypes(dietTypes);

    //Make relationships bidirectional
    telephoneType.addContact(contact);
    for (DietType dietType : dietTypes) {
      dietType.addContact(contact);
    }
    contact.save();
  }


  /**
   * Returns associated contact with id. Throws exception if id is not found.
   *
   * @param id The id.
   * @return The contact.
   */
  public static Contact getContact(long id) {
    Contact contact = Contact.find().byId(id);
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
    return Contact.find().all();
  }


  /**
   * Updates the database with a new telephone type.
   *
   * @param telephoneType -The telephone type to add.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneType.save();
  }


  /**
   * Updates the database with a new diet type.
   *
   * @param dietType -The diet type to add.
   */
  public static void addDietType(DietType dietType) {
    dietType.save();
  }

  /**
   * Returns the telephone type with the typeString or throws exception if not found.
   *
   * @param typeString The telephone type.
   * @return The instance if found.
   */
  public static TelephoneType getTelephoneType(String typeString) {
    TelephoneType telephoneType = TelephoneType.find().where().eq("telephoneType", typeString).findUnique();
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
    DietType dietType = DietType.find().where().eq("dietType", typeString).findUnique();
    if (dietType == null) {
      throw new RuntimeException("Illegal telephone type: " + typeString);
    }
    return dietType;
  }
}
