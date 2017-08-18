import java.util.List;
import java.util.ArrayList;


public class Hero{
  private String mName;
  private int mAge;
  private String mSuperPowers;
  private String mWeaknesses;
  private static List<Hero> instances=new ArrayList<Hero>();
  private int mId;
  private int mSquadId;
  //private boolean mAssign;
  //private List<Hero> mHeroes;

  public Hero(String name, int age, String powers, String weaknesses){
    mName=name;
    mAge=age;
    mSuperPowers=powers;
    mWeaknesses=weaknesses;
    instances.add(this);
    mId=instances.size();
    //mAssign=false;
    //mHeroes=new ArrayList<Hero>();
  }
  // public boolean isAssigned(){
  //   return mAssign;
  // }


public int getSquadId(){
  return mSquadId;
}

public void assignSquad(int squadId){
  mSquadId=squadId;

}
public String getName(){
    return mName;
  }
  public int getAge(){
    return mAge;
  }
  public String getPowers(){
    return mSuperPowers;
  }
  public String getWeaknesses(){
    return mWeaknesses;
  }
  public static List<Hero> all() {
  return instances;
  }
  public static void clear() {
  instances.clear();
  }
  public int getId() {
  return mId;
  }
  public static Hero find(int id){
    return instances.get(id-1);
  }
}
