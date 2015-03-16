package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Mockup database for the contacts.
 * Created by Jack on 3/14/2015.
 */
public class ContactDB {

  private static List<Contact> contacts = new ArrayList<>();

  /**
   * Adds a contact to the contact database.
   *
   * @param formData Form data for a contact.
   */
  public static void addContact(ContactFormData formData) {
    contacts.add(new Contact(formData.firstName, formData.lastName, formData.telephone, formData.address));
  }

  /**
   * Gets the list of contacts.
   *
   * @return The contact list.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
}
