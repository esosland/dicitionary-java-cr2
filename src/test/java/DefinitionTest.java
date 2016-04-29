import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("Delightful");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithFirstDefinition_String() {
    Definition myDefinition = new Definition("Delightful");
    assertEquals("Delightful", myDefinition.getFirstDefinition());
  }


}
