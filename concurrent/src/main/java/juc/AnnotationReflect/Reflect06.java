package juc.AnnotationReflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * todo: 反射获取泛型信息
 */
public class Reflect06 {
    public void test01(Map<String, User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String, User> test02(Map<String, User> map){
        System.out.println("test02");
        return null;
    }

    //todo: 获取泛型信息
    public static void main(String[] args) throws NoSuchMethodException {
        Method test01 = Reflect06.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = test01.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes){
            Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments){
                System.out.println(actualTypeArgument);
            }
        }

        Method test02 = Reflect06.class.getMethod("test02", Map.class);
        Type genericReturnType = test02.getGenericReturnType(); // 获取返回值泛型类型
    }
}
