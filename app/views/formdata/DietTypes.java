package views.formdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to support diet type maps.
 * <p>
 * Created by Jack on 3/27/2015.
 */
public class DietTypes {

  private static String[] types = {"Chicken", "Fish", "Beef", "Dairy", "Gluten"};


  /**
   * Makes map of diet types initialized to false.
   *
   * @return The diet type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type : types) {
      typeMap.put(type, false);
    }

    return typeMap;
  }

  /**
   * Checks if type is in diet type map.
   *
   * @param type The type to check
   * @return True if in map, false otherwise.
   */
  public static Boolean isType(String type) {
    return getTypes().containsKey(type);
  }

  /**
   * Makes map of diet type where one type is set to true.
   *
   * @param type The type to set true.
   * @return The diet type map.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> typeMap = getTypes();
    if (isType(type)) {
      typeMap.put(type, true);
    }

    return typeMap;
  }

  /**
   * Makes map of diet type where one type is set to true.
   *
   * @param types The types to set true.
   * @return The diet type map.
   */
  public static Map<String, Boolean> getTypes(List<String> types) {
    Map<String, Boolean> typeMap = getTypes();

    for (String type : types) {
      if (isType(type)) {
        typeMap.put(type, true);
      }
    }

    return typeMap;
  }

}
