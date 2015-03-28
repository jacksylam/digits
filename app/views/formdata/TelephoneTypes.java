package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to support telephone type maps.
 * <p>
 * Created by Jack on 3/27/2015.
 */
public class TelephoneTypes {

  private static String[] types = {"Home", "Work", "Mobile"};


  /**
   * Makes map of telephone types initialized to false.
   *
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type : types) {
      typeMap.put(type, false);
    }

    return typeMap;
  }

  /**
   * Checks if type is in telephone type map.
   *
   * @param type The type to check
   * @return True if in map, false otherwise.
   */
  public static Boolean isType(String type) {
    return getTypes().containsKey(type);
  }

  /**
   * Makes map of telephone type where one type is set to true.
   *
   * @param type the type to set true.
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> typeMap = getTypes();
    if (isType(type)) {
      typeMap.put(type, true);
    }

    return typeMap;
  }

}
