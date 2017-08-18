import java.util.List;
import java.util.ArrayList;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

public class Squad {
  private String mSquadName;
  private String mCause;
  private static int mSize;
  private static List<Squad> squads=new ArrayList<Squad>();
  private List<Hero> mHeroes;
  private int mId;

public Squad(String squadName, String cause){
  mSquadName=squadName;
  mCause=cause;
  squads.add(this);
  mId=squads.size();
  mHeroes=new ArrayList<Hero>();

  //squads.add(hero);
}
public String getSquadName(){
  return mSquadName;
}
public String getCause(){
  return mCause;
}
public static List<Squad> all() {
return squads;
}
public int getId(){
  return mId;
}
public static void clear() {
  squads.clear();
}
public List<Hero> getHeroes(){
  return mHeroes;
}
public void addHeroToSquad(Hero hero){
  mHeroes.add(hero);
}
public static Squad find(int id){
  return squads.get(id-1);
}
// public List<Heroes> addHero(){
//     squads.addHero(heroes);
// }
}
