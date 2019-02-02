package src.cn.sunguolei.study.Java.AnnotationTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author GuoLei Sun
 * Date: 2019/2/2 2:25 PM
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person person =  new Person();
        person.setName("国磊");
        person.setUserName("guolei");
        String sql = query(person);
        System.out.println(sql);
    }

    public static String query(Person person) {
        StringBuilder sb = new StringBuilder();

        Class p = person.getClass();

        boolean isAnnotationExist = p.isAnnotationPresent(Table.class);

        if (isAnnotationExist) {
            Table table = (Table) p.getAnnotation(Table.class);
            String tableName = table.value();
            sb.append("select * from ").append(tableName).append(" where 1 = 1");

            Field[] fields = p.getDeclaredFields();

            for (Field field : fields) {
                boolean isFieldExist = field.isAnnotationPresent(Column.class);

                if (!isFieldExist) {
                    continue;
                }
                Column column = field.getAnnotation(Column.class);
                String columnName = column.value();

                String fieldName = field.getName();
                Object fieldValue = null;

                try {
                    Method method = p.getMethod("get" + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1));
                    fieldValue = method.invoke(person);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (field.getType().equals(String.class)) {
                    sb.append(" and ").append(columnName).append("='").append(fieldValue).append("'");
                } else if (field.getType().equals(int.class)) {
                    sb.append(" and ").append(columnName).append("=").append(fieldValue);
                }
            }
        }

        return sb.toString();
    }
}
