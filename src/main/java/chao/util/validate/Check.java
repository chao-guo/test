package chao.util.validate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Check {
    public static void checkObject(List<?> list, Map<String, ValidateInfo> validateInfoMap) throws Exception {
        for (Object obj : list) {
            Class<?> clazz = obj.getClass();
            Field[] declaredFields = getAllField(clazz);
            for (Field field : declaredFields) {
                validateInfoMap.get(field.getName()).handler(field.getName(), field.get(obj) == null ? null : field.get(obj).toString());
            }

        }
    }

    public static Field[] getAllField(Class<?> clazz) {
        ArrayList<Field> fieldList = new ArrayList();
        Field[] dFields = clazz.getDeclaredFields();
        if (dFields != null && dFields.length > 0) {
            fieldList.addAll(Arrays.asList(dFields));
        }

        Class<?> superClass = clazz.getSuperclass();
        Field[] superFields;
        if (superClass != Object.class && !superClass.getName().equals("pcitc.imp.common.ettool.baseresrep.BaseResRep")) {
            superFields = getAllField(superClass);
            if (superFields != null && superFields.length > 0) {
                Field[] var8 = superFields;
                int var7 = superFields.length;

                for (int var6 = 0; var6 < var7; ++var6) {
                    Field field = var8[var6];
                    if (!isFieldContains(fieldList, field)) {
                        fieldList.add(field);
                    }
                }
            }
        }

        superFields = new Field[fieldList.size()];
        fieldList.toArray(superFields);
        return superFields;
    }

    private static boolean isFieldContains(ArrayList<Field> fieldList, Field field) {
        Iterator var3 = fieldList.iterator();
        while (var3.hasNext()) {
            Field temp = (Field) var3.next();
            if (temp.getName().equals(field.getName())) {
                return true;
            }
        }

        return false;
    }

}