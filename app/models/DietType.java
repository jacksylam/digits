package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * A model for telephone type.
 * Created by Jack on 4/19/2015.
 */
@Entity
public class DietType extends Model {
  @Id
  private long id;
  private String dietType;

  @ManyToMany(mappedBy = "dietTypes")
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Gets the id for the diet type.
   *
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Updates the id for the diet type.
   *
   * @param id The new id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the diet type.
   *
   * @return The diet type.
   */
  public String getDietType() {
    return dietType;
  }

  /**
   * Updates the diet type to the new type.
   *
   * @param dietType The new diet type.
   */
  public void setDietType(String dietType) {
    this.dietType = dietType;
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
   * Adds new contact to diet types.
   * @param contact The contact.
   */
  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }

  /**
   * Constructs a new diet type.
   * @param dietType The diet type.
   */
  public DietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, DietType> find() {
    return new Finder<Long, DietType>(Long.class, DietType.class);
  }
}
