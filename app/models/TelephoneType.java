package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A model for telephone type.
 * Created by Jack on 4/19/2015.
 */
public class TelephoneType {
  private long id;
  private String telephoneType;
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Gets the id for the telephone type.
   *
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Updates the id for the telephone type.
   *
   * @param id The new id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the telephone type.
   *
   * @return The telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /**
   * Updates the telephone type to the new type.
   *
   * @param telephoneType The new telephone type.
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Gets the contacts.
   *
   * @return The list of contacts.
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * Updates the list of contacts.
   *
   * @param contacts The new list of contacts.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Adds new contact to telephone types.
   * @param contact The contact.
   */
  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }

  /**
   * Constructs a new telephone type.
   * @param telephoneType The telephone type.
   */
  public TelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }
}
