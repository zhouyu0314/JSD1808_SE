package enum1;

import javax.lang.model.element.TypeElement;

public class Demo01 {

    public static void main(String[] args) {
        entity e = new entity();
        e.setId(1);
        e.setType(typeEnum.AUDIO);
        System.out.println(e);
    }
}

class entity{
    private int id;
    private typeEnum type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public typeEnum getType() {
        return type;
    }

    public void setType(typeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "entity{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}