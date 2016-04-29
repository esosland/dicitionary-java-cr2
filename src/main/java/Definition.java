import java.util.ArrayList;

public class Definition {
  private String mFirstDefinition;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  public Definition(String firstDefinition) {
    mFirstDefinition = firstDefinition;
    instances.add(this);
  }

  public String getFirstDefinition() {
    return mFirstDefinition;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

}
