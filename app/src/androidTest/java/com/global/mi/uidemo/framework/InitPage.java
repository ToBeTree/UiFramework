package com.global.mi.uidemo.framework;

import android.content.Context;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import dalvik.system.DexFile;

public class InitPage {

    /**
     * 初始化所有page包中继承自BasePage的类中的FindBy注解
     * 格式: Type#value@[clazz]&[position]
     *
     * @param context 测试应用上下文
     * @throws Exception
     */
    public static void setAllField(Context context) throws Exception {
        List<Class> classes = getAllClassByBaseClass(context, Class.forName(ConstDefs.BASE_PAGE));
        Log.i(ConstDefs.TAG,"start init pages fields...");
        for (Class clazz:classes){
//            clazz.getAnnotations();
            Field[] fields = clazz.getFields();
            for (Field field: fields) {
                field.setAccessible(true);
                FindBy by = field.getAnnotation(FindBy.class);
                String fieldValue = "";
                if (by != null){
                    if (!by.depth().isEmpty()){
                        //depth类型一定跟着Clazz和position
                        fieldValue = spliceSelector(ConstDefs.DEPTH,by.depth(),by.clazz(),by.position());
//                        fieldValue = ConstDefs.DEPTH+ConstDefs.TYPE_OPERATOR+ConstDefs.CLAZZ+ConstDefs.CLASS_OPERATOR+ConstDefs.POSITION_OPERATOR;
                    }else if(!by.res().isEmpty()){
                        fieldValue = spliceSelector(ConstDefs.RES,by.res());
                    }else if(!by.contentDesc().isEmpty()){
                        fieldValue = spliceSelector(ConstDefs.DESC,by.contentDesc());
                    }else if(!by.clazz().isEmpty()){
                        fieldValue = spliceSelector(ConstDefs.CLAZZ,by.clazz());
                    }else if(!by.text().isEmpty()){
                        fieldValue = spliceSelector(ConstDefs.TEXT,by.text());
                    }
                }
                Log.i(ConstDefs.TAG,fieldValue);
                if (!"".equals(fieldValue)){
                    field.set(clazz,fieldValue);
                }
            }

        }
        Log.i(ConstDefs.TAG,"end init pages fields.");
    }

    private static String spliceSelector(String type,String value){
        String selector;
        selector = type + ConstDefs.TYPE_OPERATOR + value;
        return selector;
    }

    private static String spliceSelector(String type,String value,String position){
        String selector;
        selector = type + ConstDefs.TYPE_OPERATOR + value + ConstDefs.POSITION_OPERATOR + position;
        return selector;
    }

    private static String spliceSelector(String type,String value,String clazz,String position){
        String selector;
        selector = type + ConstDefs.TYPE_OPERATOR + value + ConstDefs.CLASS_OPERATOR + clazz + ConstDefs.POSITION_OPERATOR + position;
        return selector;
    }


    /**
     * 通过基类查找所有继承该基类的子类
     * @param context   测试应用上下文
     * @param clazz   基类
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    private static List<Class> getAllClassByBaseClass(Context context, Class clazz) throws IOException, ClassNotFoundException {
        List<Class> classes = new ArrayList<>();

        DexFile df = new DexFile(context.getPackageResourcePath());
        Enumeration<String> classNames = df.entries();
        //只有继承了BasePage的类才会添加进去
        while(classNames.hasMoreElements()){
            String className = classNames.nextElement();
            if (className.contains(ConstDefs.BASE_PAGE_PATH)){
                Class pClass = Class.forName(className);
                if(clazz.isAssignableFrom(pClass)){
                    classes.add(pClass);
                }
            }
        }

        return classes;
    }
}
