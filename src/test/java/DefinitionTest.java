
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @After
  public void tearDown() {
    Definition.clear();
  }

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("Delightful");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void definition_instantiatesWithFirstDefinition_String() {
    Definition myDefinition = new Definition("Delightful");
    assertEquals("Delightful", myDefinition.getFirstDefinition());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("Delightful");
    Definition secondDefinition= new Definition("Wonderful");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("Delightful");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_definitionsInstantiateWithAnID_1() {
    Definition myDefinition = new Definition("Delightful");
    assertEquals(1, myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("Delightful");
    Definition secondDefinition = new Definition("Wonderful");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999) == null);
  }
}
