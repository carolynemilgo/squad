import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest{
  //Test to confirm instatiation of Hero Objects
  @Test
  public void Hero_correctlyInstantiates_true(){
    Hero myHero=new Hero("captain america", 20, "breathes fire", "eats alot");
    assertEquals(true, myHero instanceof Hero);
  }
  //Test to confirm if it returns name of the Hero
  @Test
  public void returnsNameOfHero(){
    Hero myHero=new Hero("captain america", 20, "breathes fire", "eats alot");
    assertEquals("captain america", myHero.getName());
  }
  @Test
  public void returnsAgeOfHero(){
    Hero myHero=new Hero("captain america", 20, "breathes fire", "eats alot");
    assertEquals(20, myHero.getAge());
  }
  @Test
  public void returnsSuperPowers(){
    Hero myHero=new Hero("captain america", 20, "breathes fire", "eats alot");
    assertEquals("breathes fire", myHero.getPowers());
  }
  @Test
  public void returnsWeaknesses(){
    Hero myHero=new Hero("captain america", 20, "breathes fire", "eats alot");
    assertEquals("eats alot", myHero.getWeaknesses());
  }
  @Test
  public void all_returnsAllInstancesOfHeroObject_true() {
    Hero oneHero = new Hero("captain america", 20, "breathes fire", "eats alot");
    Hero anotherHero = new Hero("robin hood", 30, "master of archery", "heavy sleeper");
    assertEquals(true, Hero.all().contains(oneHero));
    assertEquals(true, Hero.all().contains(anotherHero));
  }
  @Test
  public void clear_removesAllHeroesFromArrayList_0(){
    Hero myHero=new Hero("captain america", 20, "breathes fire", "eats alot");
    Hero.clear();
    assertEquals(Hero.all().size(), 0);
  }
  @Test
  public void getId_heroesInstantiateWIthId_1(){
    Hero.clear();
    Hero myHero=new Hero("captain america", 20, "breathes fire", "eats alot");
    assertEquals(1, myHero.getId());

  }
}
