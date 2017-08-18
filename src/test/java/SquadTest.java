  import org.junit.*;
import static org.junit.Assert.*;


 public class SquadTest{
//    @After
//    public void tearDown(){
//   Squad.clear();
// }
   @Test
   public void squadObjectInstantiatesCorrectly_(){
     Squad mySquad=new Squad("empire", "pollution");
     assertEquals(true, mySquad instanceof Squad);
   }
      //test if it correctly returns name of the squad
   @Test
   public void returnsNameOfSquad_(){
     Squad mySquad=new Squad("empire", "pollution");
     assertEquals("empire", mySquad.getSquadName());
   }
      //test if it correctly returns name of the cause
   @Test
   public void returnsCauseSquadIsDedicatedTo_(){
     Squad mySquad=new Squad("empire", "pollution");
     assertEquals("pollution", mySquad.getCause());
   }
   //test if it correctly returns size of squad
  //  @Test
  //  public void returnsSizeOfSquad_(){
  //    Squad mySquad=new Squad("empire", "pollution", 1, "captain america");
  //    assertEquals(1, Squad.getSize());
  //  }
   @Test
   public void returnsAllInstancesOfCategory_true(){
     Squad mySquad=new Squad("marvel", "killing evil people");
     Squad anotherSquad=new Squad("Chinkus", "refurbishing all railway lines");
     assertEquals(true, Squad.all().contains(mySquad));
     assertEquals(true,Squad.all().contains(anotherSquad));
   }

   @Test
   public void testIfNewHeroCanBeAddedToASquad_(){
     Squad mySquad=new Squad("empire", "pollution");
     Hero newHero=new Hero("robin hood", 20, "breathes fire", "eats alot");
     mySquad.addHeroToSquad(newHero);
     assertTrue(mySquad.getHeroes().contains(newHero));
   }
   //test to empty list during development
   @Test
   public void testIfListIsCleared_0(){
     Squad mySquad=new Squad("empire", "pollution");
     Squad.clear();
     assertEquals(Squad.all().size(), 0);
   }
   //test if it Squad Object correctly returns ID of created squad instances
   @Test
   public void returnsIdOfSquadObject_1(){
     Squad.clear();
     Squad mySquad=new Squad("empire", "pollution");
     assertEquals(1, mySquad.getId());
   }
   //test if it returns the correct ID of the squad
   @Test
   public void find_returnsSquadWithSameID_anotherSquad(){
     Squad.clear();
     Squad mySquad=new Squad("empire", "pollution");
     Squad anotherSquad=new Squad("Chinkus", "refurbishing all railway lines");
     assertEquals(Squad.find(anotherSquad.getId()),anotherSquad);
        }
   //test is squad object initially returns an empty List
   @Test
   public void squadReturnsEmptyList_ArrayList(){
     Squad.clear();
     Squad mySquad=new Squad("empire", "pollution");
     assertEquals(0, mySquad.getHeroes().size());

   }
 }
