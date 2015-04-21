import models.Contact;
import models.ContactDB;
import models.DietType;
import models.TelephoneType;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Initializes application with four contacts.
 * Created by Jack on 3/30/2015.
 */
public class Global extends GlobalSettings {


  @Override
  public void onStart(Application application) {
    super.onStart(application);

    if (TelephoneType.find().all().isEmpty()) {
      ContactDB.addTelephoneType(new TelephoneType("Mobile"));
      ContactDB.addTelephoneType(new TelephoneType("Home"));
      ContactDB.addTelephoneType(new TelephoneType("Work"));
    }
    if (DietType.find().all().isEmpty()) {
      ContactDB.addDietType(new DietType("Chicken"));
      ContactDB.addDietType(new DietType("Fish"));
      ContactDB.addDietType(new DietType("Beef"));
      ContactDB.addDietType(new DietType("Dairy"));
      ContactDB.addDietType(new DietType("Gluten"));
    }

    List<String> diets = new ArrayList<>();
    if (Contact.find().all().isEmpty()) {
      ContactDB.addContact(new ContactFormData("Max", "Smith", "555-555-1111", "Mobile", diets));
      ContactDB.addContact(new ContactFormData("Bob", "Smith", "555-555-2222", "Home", diets));
      ContactDB.addContact(new ContactFormData("Sam", "Smith", "555-555-3333", "Work", diets));
      ContactDB.addContact(new ContactFormData("Rob", "Smith", "555-555-4444", "Work", diets));
    }
  }
}
