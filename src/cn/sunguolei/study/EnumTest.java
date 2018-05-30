package cn.sunguolei.study;

/**
 * @author Sun Guolei 2018/5/30 10:39
 */
public enum EnumTest {
    C2B("1", "c1卖车"),
    B2C("2", "c2买车"),
    C2C("3", "待定");

    private String code;
    private String desc;

    EnumTest(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static EnumTest getDescriptionByCode(String code) {
        for (EnumTest enumTest : EnumTest.values()) {
            // org.apache.commons.lang3.StringUtils
//            if (StringUtils.equals(code, enumTest.getCode())) {
            if (code.equals(enumTest.getCode())) {
                return enumTest;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EnumTest enumTest = EnumTest.getDescriptionByCode("3");
        if (enumTest != null) {
            System.out.println(enumTest.getDesc());
        }
    }
}
