  import java.util.ArrayList;

  public class Definition {
    private String mFirstDefinition;
    private static ArrayList<Definition> instances = new ArrayList<Definition>();
    private int mId;

    public Definition(String firstDefinition) {
      mFirstDefinition = firstDefinition;
      instances.add(this);
      mId = instances.size();
    }

    public String getFirstDefinition() {
      return mFirstDefinition;
    }

    public static ArrayList<Definition> all() {
      return instances;
    }

    public static void clear() {
      instances.clear();
    }

    public int getId() {
      return mId;
    }

    public static Definition find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }
}
