import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

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
    fill("#firstDefinition").with("Delightful");
    submit(".btn");
    assertThat(pageSource()).contains("Your definition has been saved.");
  }

  @Test
  public void DefinitionIsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#firstDefinition").with("Delightful");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Delightful");
  }

  @Test
  public void multipleDefinitionsAreDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#firstDefinition").with("Delightful");
    submit(".btn");
    click("a", withText("Go Back"));
    fill("#firstDefinition").with("Wonderful");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Delightful");
    assertThat(pageSource()).contains("Wonderful");
  }
}
