package org.redrock.ClassInfo.Parcel_4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang on 2017/8/17.
 */
public class TypeCounter extends HashMap<Class<?>, Integer>{
    private Class<?> baseType;
    public TypeCounter(Class<?> baseType) {this.baseType = baseType;}

    public void count(Object obj) {
        Class<?> type = obj.getClass();
        //校验所传递的对象是否属于我们感兴趣的继承结构
        if (!baseType.isAssignableFrom(type))
            throw new RuntimeException();

        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            sb.append(pair.getKey().getSimpleName());
            sb.append("=");
            sb.append(pair.getValue());
            sb.append(",  ");
        }

        sb.delete(sb.length()-3, sb.length());
        sb.append("}");
        return sb.toString();
    }
}
