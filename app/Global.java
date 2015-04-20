import models.ContactDB;
import models.DietType;
import models.TelephoneType;
import play.GlobalSettings;
import views.formdata.ContactFormData;
import play.Application;

/**
 * Initializes application with four contacts.
 * Created by Jack on 3/30/2015.
 */
public class Global extends GlobalSettings {


  @Override
    public void onStart(Application application) {
    super.onStart(application);

    ContactDB.addTelephoneType(new TelephoneType("Mobile"));
    ContactDB.addTelephoneType(new TelephoneType("Home"));
    ContactDB.addTelephoneType(new TelephoneType("Work"));
    ContactDB.addDietType(new DietType("Chicken"));
    ContactDB.addDietType(new DietType("Fish"));
    ContactDB.addDietType(new DietType("Beef"));
    ContactDB.addDietType(new DietType("Dairy"));
    ContactDB.addDietType(new DietType("Gluten"));


    ContactDB.addContact(new ContactFormData("Max", "Smith", "555-555-1111", "Mobile"));
    ContactDB.addContact(new ContactFormData("Bob", "Smith", "555-555-2222", "Home"));
    ContactDB.addContact(new ContactFormData("Sam", "Smith", "555-555-3333", "Work"));
    ContactDB.addContact(new ContactFormData("Rob", "Smith", "555-555-4444", "Work"));
  }
}
