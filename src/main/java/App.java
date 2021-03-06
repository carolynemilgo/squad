import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


public class App{
  public static void main(String[]args){
    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
        port = Integer.parseInt(process.environment().get("PORT"));
    } else {
        port = 4567;
    }

   setPort(port);


    staticFileLocation("/public");
    String layout="templates/layout.vtl";

    get("/", (request,response) ->{
      Map <String, Object> model=new HashMap<String, Object>();
      //model.put("hero", request.session().attribute("hero"));
      model.put("template", "templates/index.vtl");
      model.put("heroes",Hero.all());
      model.put("squads",Squad.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heroes/new", (request, response) ->{
      Map <String, Object> model=new HashMap<String, Object>();
      model.put("squads", Squad.all());
      model.put("template", "templates/hero-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heroes", (request, response) ->{
      Map <String, Object> model=new HashMap<String, Object>();
      model.put("heroes", Hero.all());
      model.put("template", "templates/heroes.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heroes", (request, response) ->{
      Map<String, Object> model=new HashMap<String, Object>();
      String name=request.queryParams("name");
      String powers=request.queryParams("powers");
      String weaknesses=request.queryParams("weaknesses");
      int age=Integer.parseInt(request.queryParams("age"));
      Hero myHero= new Hero(name, age, powers,weaknesses);
    //  newHero.joinSquad(squadId);
      model.put("template", "templates/success.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
//dynamically routing to heroes view
  get("/heroes/:id", (request, response) ->{
      Map<String, Object> model= new HashMap<String, Object>();
      Hero hero=Hero.find(Integer.parseInt(request.params(":id")));
      model.put("hero", hero);
      model.put("template", "templates/hero.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

//allow users to create new squads through use of a form and save them
get("/squads/new", (request,response) ->{
      Map<String, Object> model=new HashMap<String, Object>();
      model.put("template", "templates/squad-form.vtl");
      return new ModelAndView(model,layout);
      }, new VelocityTemplateEngine());


post("/squads", (request, response) ->{
      Map<String, Object> model=new HashMap<String, Object>();
      String squadName=request.queryParams("squadName");
      String cause=request.queryParams("cause");
      Squad mySquad=new Squad(squadName, cause);
      model.put("template", "templates/squad-success.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

get("/squads", (request, response) ->{
  Map<String, Object> model=new HashMap<String, Object>();
  model.put("squads", Squad.all());
  model.put("template", "templates/squads.vtl");
return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

get("/squads/:id", (request, response) ->{
  Map<String, Object> model=new HashMap<String, Object>();
  Squad squad= Squad.find(Integer.parseInt(request.params(":id")));
  model.put("squad", squad);
  model.put("template", "templates/squad.vtl");
  return new ModelAndView(model,layout);
  }, new VelocityTemplateEngine());

  get("/squads/:id/heroes/new", (request, response) ->{
    Map<String, Object> model= new HashMap<String, Object>();
    Squad squad=Squad.find(Integer.parseInt(request.params(":id")));
    //Hero heros=Hero.find(Integer.parseInt(request.params(":id")));
    model.put("squad", squad);
    model.put("heros", Hero.all());
    model.put("template", "templates/squad-heroes-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


  post("/squads/:idOfSquad/heroAssignment/:idOfHero", (request, response) ->{
    Map<String, Object> model= new HashMap<String, Object>();
    Squad squad=Squad.find(Integer.parseInt(request.params(":idOfSquad")));
    Hero hero=Hero.find(Integer.parseInt(request.params(":idOfHero")));
    squad.addHeroToSquad(hero);
    model.put("squad", squad);
    model.put("heros", Hero.all());
    //model.put("template", "templates/assignSquad.vtl");
    model.put("template", "templates/squad-heroes-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }
}
