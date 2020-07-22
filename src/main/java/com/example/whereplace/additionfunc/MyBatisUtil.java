package com.example.whereplace.additionfunc;

import com.example.whereplace.entity.Goods;
import com.example.whereplace.entity.Store;
import com.example.whereplace.entity.Userinformation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class MyBatisUtil {

    // 获取bean的属性 根据属性评价 resultMap
    // 并将驼峰修改为'_'
    public static String getResultMapNew(Class<?> cls) throws Exception {
        String str = "";
        // 头部 <resultMap id="BaseResultMap" type="com.huajie.entity.sys.SysMenuinfo">
        str = "<resultMap id=\"" + cls.getSimpleName() + "ResultMap\" type=\"" + cls.getName() + "\"> \r\n";
        // 每一行字符串
        String linestr = "";
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            linestr = "<result column=\"" + getUpCaseReplace(field.getName()) + "\" property=\"" + field.getName()
                    +  "\"/>";
            linestr += "\r\n";
            str += linestr;
        }
        str+="</resultMap>";
        return str;
    }

    public static String getParameterMapNew(Class<?> cls) throws Exception {
        String str = "";
        // 头部 <resultMap id="BaseResultMap" type="com.huajie.entity.sys.SysMenuinfo">
        str = "<parameterMap id=\"" + cls.getSimpleName() + "ParameterMap\" type=\"" + cls.getName() + "\"> \r\n";
        // 每一行字符串
        String linestr = "";
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            linestr = "<parameter property=\"" + field.getName() + "\" resultMap=\"" + cls.getSimpleName()+"ResultMap"
                    +  "\"/>";
            linestr += "\r\n";
            str += linestr;
        }
        str+="</parameterMap>";
        return str;
    }
    
    
    // 获取Base_Column_List sql语句字段
    public static String getColumnList(Class<?> cls) throws Exception {
        // 每一行字符串 <result column="BID_SECTION_CODE" property="BID_SECTION_CODE"
        // jdbcType="VARCHAR" />
        String linestr = "";
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            linestr = linestr + field.getName() + ",";
        }
        String str = linestr.substring(0, linestr.length() - 1);
        System.out.println(str);
        return str;
    }

    /**
     * 将字符串中的驼峰写法替换成下划线
     *
     * @param str
     * @return
     */
    private static String getUpCaseReplace(String str) {
        List<String> listChar = getUpCaseList(str);
        for (int i = 0; i < listChar.size(); i++) {
            str = str.replace(listChar.get(i), "_"+listChar.get(i).toLowerCase());
        }
        return str;
    }

    /**
     * @Description: 输出字符串中的大写字母
     * @param str
     */
    private static List<String> getUpCaseList(String str) {
        List<String> listChar = new ArrayList<String>();
        // 转为char数组
        char[] ch = str.toCharArray();
        // 得到大写字母
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                listChar.add(String.valueOf(ch[i]));
            }
        }
        return listChar;
    }

    /**
     * @Description: 输出字符串中的大写字母
     */
    private static String getColumnListNew(Class<?> cls) throws Exception {
        // 每一行字符串 <result column="BID_SECTION_CODE" property="BID_SECTION_CODE"
        // jdbcType="VARCHAR" />
        String linestr = "";
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            linestr = linestr + getUpCaseReplace(field.getName()) + ",";
        }
        String str = linestr.substring(0, linestr.length() - 1);
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) throws Exception {
        Userinformation a=new Userinformation();
        System.out.println(getResultMapNew(a.getClass()));
        // getColumnListNew(a.getClass());
        Goods goods=new Goods();
        Store store=new Store();
        System.out.println(getParameterMapNew(goods.getClass()));
        System.out.println(getParameterMapNew(store.getClass()));

    }
}
