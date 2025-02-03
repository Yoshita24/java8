import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//Design pattern are well proven solution of commonly occurring problem in software design
//SingletonDesignPattern is creational Design pattern
// example database connection - 1 time only created required
public class SingletonDesignPattern implements Serializable{
    private volatile static SingletonDesignPattern singletonDesignPattern=null;
   /*
    Eager initialization
    private volatile static SingletonDesignPattern singletonDesignPattern=new SingletonDesignPattern();
    public SingletonDesignPattern getSingletonDesignPatternInstance()
    {
        return singletonDesignPattern;
    }
    */
    private SingletonDesignPattern()
    {
    if(singletonDesignPattern!=null)
    {
        throw  new RuntimeException("You are trying to break singletonDesignPattern");
    }
    }
    //lazy way initialized
    public static SingletonDesignPattern getSingletonDesignPatternInstance()
    {
        if(singletonDesignPattern==null)
        {
            synchronized (SingletonDesignPattern.class)
            {
                if(singletonDesignPattern==null)
                {
                    singletonDesignPattern=new SingletonDesignPattern();
                }
            }
        }
        return singletonDesignPattern;
    }

    public Object readResolve()
    {
        return singletonDesignPattern;
    }
    public SingletonDesignPattern clone()
    {
        return singletonDesignPattern;
    }
}
class SingletonDesignPatternDemo
{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        SingletonDesignPattern original = SingletonDesignPattern.getSingletonDesignPatternInstance();
        System.out.println("Original ::: "+original.hashCode());
        Constructor<SingletonDesignPattern> declaredConstructor = SingletonDesignPattern.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        //SingletonDesignPattern reflectionConstructor= declaredConstructor.newInstance();
       // System.out.println("Reflection ::: "+reflectionConstructor.hashCode());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"));
        oos.writeObject(original);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.txt"));
        SingletonDesignPattern serializedsingletonDesignPattern = (SingletonDesignPattern) ois.readObject();
        System.out.println("Serialization ::: "+serializedsingletonDesignPattern.hashCode());

        SingletonDesignPattern cloned = original.clone();
        System.out.println("Cloned ::: "+cloned.hashCode());

    }
}