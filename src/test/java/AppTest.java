import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary!");
    assertThat(pageSource()).contains("View Word List");
    assertThat(pageSource()).contains("Add a New Word");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Frabjous");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Frabjous");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Frabjous");
  }

  @Test
  public void wordShowPageDisplaysName() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Doughty");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Doughty"));
    assertThat(pageSource()).contains("Doughty");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Irresolute");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Irresolute"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a definition to Irresolute");
  }

  @Test
  public void definitionsIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Uncertain");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Uncertain"));
    click("a", withText("Add a new definition"));
    fill("#firstDefinition").with("Ambiguous");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Uncertain"));
    assertThat(pageSource()).contains("Ambiguous");
  }


}




// import org.fluentlenium.adapter.FluentTest;
// import org.junit.ClassRule;
// import org.junit.Test;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.htmlunit.HtmlUnitDriver;
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.fluentlenium.core.filter.FilterConstructor.*;
//
// public class AppTest extends FluentTest {
//   public WebDriver webDriver = new HtmlUnitDriver();
//
//   @Override
//   public WebDriver getDefaultDriver() {
//     return webDriver;
//   }
//
//   @ClassRule
//   public static ServerRule server = new ServerRule();
//
//   @Test
//   public void rootTest() {
//     goTo("http://localhost:4567/");
//     assertThat(pageSource()).contains("Dictionary!");
//   }
//
//   @Test
//   public void DefinitionIsCreatedTest() {
//     goTo("http://localhost:4567/");
//     click("a", withText("Add a new definition"));
//     fill("#firstDefinition").with("Delightful");
//     submit(".btn");
//     assertThat(pageSource()).contains("Your definition has been saved.");
//   }
//
//   @Test
//   public void definitionIsDisplayedTest() {
//     goTo("http://localhost:4567/definitions/new");
//     fill("#firstDefinition").with("Delightful");
//     submit(".btn");
//     click("a", withText("View definitions"));
//     assertThat(pageSource()).contains("Delightful");
//   }
//
//   @Test
//   public void multipleDefinitionsAreDisplayedTest() {
//     goTo("http://localhost:4567/definitions/new");
//     fill("#firstDefinition").with("Delightful");
//     submit(".btn");
//     goTo("http://localhost:4567/definitions/new");
//     fill("#firstDefinition").with("Wonderful");
//     submit(".btn");
//     click("a", withText("View definitions"));
//     assertThat(pageSource()).contains("Delightful");
//     assertThat(pageSource()).contains("Wonderful");
//   }
//
//   @Test
//   public void definitionShowPageDisplaysFirstDefinition() {
//     goTo("http://localhost:4567/definitions/new");
//     fill("#firstDefinition").with("Splendid");
//     submit(".btn");
//     click("a", withText("View definitions"));
//     click("a", withText("Splendid"));
//     assertThat(pageSource()).contains("Splendid");
//   }
//
//   @Test
//   public void definitionNotFoundMessageShown() {
//     goTo("http://localhost:4567/definitions/999");
//     assertThat(pageSource()).contains("Definition not found");
//   }
//
// }
