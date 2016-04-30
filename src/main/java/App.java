import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Word newWord = new Word(name);
      model.put("template", "templates/word-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}



// import java.util.Map;
// import java.util.HashMap;
// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;
// import java.util.ArrayList;
//
// public class App {
//   public static void main(String[] args) {
//     staticFileLocation("/public");
//     String layout = "templates/layout.vtl";
//
//     get("/", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/index.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("definitions/new", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/definition-form.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/definitions", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       model.put("definitions", Definition.all());
//       model.put("template", "templates/definitions.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/definitions", (request,response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       String firstDefinition = request.queryParams("firstDefinition");
//       Definition newDefinition = new Definition(firstDefinition);
//       model.put("template", "templates/success.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/definitions/:id", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
//       model.put("definition", definition);
//       model.put("template", "templates/definition.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/definitions/:id", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
//       model.put("definition", definition);
//       model.put("template", "templates/definition.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//   }
// }


//     post("/definitions", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//
//       ArrayList<Definition> definitions = request.session().attribute("definitions");
//       if (definitions == null) {
//         definitions = new ArrayList<Definition>();
//         request.session().attribute("definitions", definitions);
//       }
//
//       String firstDefinition = request.queryParams("firstDefinition");
//       Definition newDefinition = new Definition(firstDefinition);
//       definitions.add(newDefinition);
//
//       model.put("template", "templates/success.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//
//   }
// }
