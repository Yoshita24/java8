/*
* While creating object when object contain many attributes there are many problem which arise
* We have to pass many arguments to create object
* some paramters might be optional
* factory class takes all responsibility for creating object.
* If the object is heavy then all the complexity is part of factory class
* So in builder pattern we create object step by step and finally return
* final object with desired values of attributes
*
*
* */

public class BuilderDesignPattern {
    public static void main(String[] args) {
        //Phone p = new Phone("Android",2,"Quad",50,100);
        Phone p = new PhoneBuilder().setOs("Android").setRam(2).getPhone();
        System.out.println(p);
    }
}

class Phone
{
    private String os;
    private int ram;
    private String processor;
    private double screensize;
    private int battery;

    public Phone(String os, int ram, String processor, double screensize, int battery) {
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screensize = screensize;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screensize=" + screensize +
                ", battery=" + battery +
                '}';
    }
}
class PhoneBuilder
{
    private String os;
    private int ram;
    private String processor;
    private double screensize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreensize(double screensize) {
        this.screensize = screensize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }
    public Phone getPhone()
    {
        return new Phone( os,  ram,  processor,  screensize,  battery);
    }
}