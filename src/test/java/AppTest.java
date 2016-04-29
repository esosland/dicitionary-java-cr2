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
  }

  @Test
  public void DefinitionIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new definition"));
    fill("#firstDefinition").with("Delightful");
    submit(".btn");
    assertThat(pageSource()).contains("Your definition has been saved.");
  }

  @Test
  public void definitionIsDisplayedTest() {
    goTo("http://localhost:4567/definitions/new");
    fill("#firstDefinition").with("Delightful");
    submit(".btn");
    click("a", withText("View definitions"));
    assertThat(pageSource()).contains("Delightful");
  }

  @Test
  public void multipleDefinitionsAreDisplayedTest() {
    goTo("http://localhost:4567/definitions/new");
    fill("#firstDefinition").with("Delightful");
    submit(".btn");
    goTo("http://localhost:4567/definitions/new");
    fill("#firstDefinition").with("Wonderful");
    submit(".btn");
    click("a", withText("View definitions"));
    assertThat(pageSource()).contains("Delightful");
    assertThat(pageSource()).contains("Wonderful");
  }

  @Test
  public void definitionShowPageDisplaysFirstDefinition() {
    goTo("http://localhost:4567/definitions/new");
    fill("#firstDefinition").with("Splendid");
    submit(".btn");
    click("a", withText("View definitions"));
    click("a", withText("Splendid"));
    assertThat(pageSource()).contains("Splendid");
  }

  @Test
  public void definitionNotFoundMessageShown() {
    goTo("http://localhost:4567/definitions/999");
    assertThat(pageSource()).contains("Definition not found");
  }

}
