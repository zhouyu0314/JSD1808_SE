package enum1;

public enum typeEnum2 {
    VIDEO(1,"视频"),AUDIO(2,"音频"),TEXT(3,"文本"),IMAGE(4,"图像");

    int value;
    String name;

    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    typeEnum2(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public typeEnum2 getByValue(int value) {
        for(typeEnum2 typeEnum : typeEnum2.values()) {
            if(typeEnum.value == value) {
                return typeEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }


}
