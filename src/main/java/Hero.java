import java.util.List;
import java.util.ArrayList;

public class Hero{
  private String mName;
  private int mAge;
  private String mSuperPowers;
  private String mWeaknesses;
  private static List<Hero> instances=new ArrayList<Hero>();
  private int mId;
  //private List<Hero> mHeroes;

  public Hero(String name, int age, String powers, String weaknesses){
    mName=name;
    mAge=age;
    mSuperPowers=powers;
    mWeaknesses=weaknesses;
    instances.add(this);
    mId=instances.size();
  //  mHeroes=new ArrayList<Hero>();
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
