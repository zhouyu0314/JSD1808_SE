package enum1;

public class typeEnum2Demo {
    public static void main(String[] args) {
        typeEnum2 enu = typeEnum2.IMAGE;
        String name = enu.name;
        System.out.println("name:"+name);
        System.out.println(enu.getName() + ":" + enu.getValue());

        typeEnum2[] values = typeEnum2.values();
        System.out.println(values[1].getName());

    }
}
