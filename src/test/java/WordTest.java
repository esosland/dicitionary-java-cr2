import org.junit.*;
import static org.junit.Assert.*;

public class WordTest{


@Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Frabjous");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
    public void getName_wordInstantiatesWithName_Frabjous() {
      Word testWord = new Word("Frabjous");
      assertEquals("Frabjous", testWord.getName());
    }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Frabjous");
    Word secondWord = new Word("Irresolute");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

}
