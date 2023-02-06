package top.jayczee.backend.enums;

public enum SensorDataType {
    PH(0,"ph","ph值"),
    P(1,"p","磷元素"),
    AIR_TEMP(2,"airTemp","空气温度"),
    BASE(3,"base","基质浓度"),
    N(4,"n","氮元素"),
    K(5,"k","钾元素"),
    AIR_WET(6,"airWet","空气湿度"),
    BASE_TEMP(7,"baseTemp","基质温度")
    ;
    private final int id;
    private final String code;
    private final String name;

    public static final int $id=-1;
    public static final String $code = "";
    public static final String $name= "";

    SensorDataType(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getCode(){
        return this.code;
    }

    public String getName(){
        return name;
    }
}
