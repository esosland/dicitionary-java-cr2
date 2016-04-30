import org.junit.*;
import static org.junit.Assert.*;

public class WordTest{
  @After
  public void tearDown() {
    Word.clear();
    Definition.clear();
  }

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

  @Test
  public void clear_emptiesAllWordsFromList_0() {
    Word testWord = new Word("Frabjous");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void getId_wordsInstantiateWithAnId_1() {
    Word testWord = new Word("Frabjous");
    assertEquals(1, testWord.getId());
  }

  // @Test
  // public void find_returnsWordWithSameId_secondWord() {
  //   Word firstWord = new Word("Frabjous");
  //   Word secondWord = new Word("Irresolute");
  //   assertEquals(Word.find(secondWord.getId()), secondWord);
  // }




}
