import java.util.HashMap;
import java.util.Objects;

public class HashMapDemo {
    public static void main(String[] args) {
        Empl empl=new Empl(1,"Yoshita");
        Empl empl2=new Empl(2,"Deven");
        Empl empl3=new Empl(1,"Yoshita");
        HashMap<Empl,String> emplHashMap=new HashMap();
        emplHashMap.put(empl,"Hello");
        emplHashMap.put(empl2,"There");

        emplHashMap.put(empl3,"World");
        System.out.println(emplHashMap.size());

    }
}
class Empl
{
    int id;
    String name;

    public Empl(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empl empl = (Empl) o;
        return id == empl.id && Objects.equals(name, empl.name);
    }

    @Override
    public int hashCode() {
        return 1;
        //return Objects.hash(id, name);
    }
}