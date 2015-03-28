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

  /**
   * Adds a contact to the contact database. If form id is 0, new id is created.
   * Otherwise, previous id contact is updated.
   *
   * @param formData Form data for a contact.
   */
  public static void addContact(ContactFormData formData) {
    long idValue = (formData.id == 0) ? currentID++ : formData.id;
    Contact contact = new Contact(idValue, formData.firstName, formData.lastName, formData.telephone,
        formData.telephoneType);
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
}
