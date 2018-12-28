import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;


public class Main {

    int i;
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String str = "Hello World";
        String anotherString = "hello world";
        Object objStr = str;

        System.out.println( str.compareTo(anotherString) );
        System.out.println( str.compareToIgnoreCase(anotherString) );  //忽略大小写
        System.out.println( str.compareTo(objStr.toString()));

        Object objStr1 = "cweqwee";
        System.out.println(str.compareTo(objStr1.toString()));
        int lastIndex = objStr1.toString().lastIndexOf("q");
        System.out.println(lastIndex);
        System.out.println(((String) objStr1).length());
        System.out.println("我的名字是:".concat("bzzear"));
        System.out.println(objStr1.toString().hashCode());
        System.out.println(objStr.toString().toUpperCase());
        remvoeChar();
        System.out.println("=================================================");
        System.out.println(objStr1.toString().indexOf("ee"));
        expolde("www-bai-du-com", "-");
        compare();
        append();

        Date date = new Date();
        System.out.println(date);
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println(sdf.format(date));
    }

    //移除和替换一个字符
    public static void remvoeChar(){
        String str = "make a file ,wa, wa,wa";
        String str1 = removeChar(str,5);
        System.out.println(str1);
        String str2 = str.replace("w","");
        System.out.println(str2);
    }

    public static String removeChar(String s,int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
    //字符串转换成数组
    public static void  expolde(String str, String delimeter){
        String [] tmp;
        tmp = str.split(delimeter);
        System.out.println(Arrays.toString(tmp));
    }

    public static void  compare() {
        int j;
        String first_str = "Welcome to Microsoft";
        String second_str = "I work with microsoft";
        boolean match1 = first_str.
                regionMatches(11, second_str, 12, 9);
        boolean match2 = first_str.
                regionMatches(true, 11, second_str, 12, 9); //第一个参数 true 表示忽略大小写区别
        System.out.println("区分大小写返回值：" + match1);
        System.out.println("不区分大小写返回值：" + match2);
    }

    public static  void append() {
        long startTime = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            String result = "This is"
                    + "testing the"
                    + "difference"+ "between"
                    + "String"+ "and"+ "StringBuffer";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 + 操作符 : "
                + (endTime - startTime)+ " ms");
        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            StringBuffer result = new StringBuffer();
            result.append("This is");
            result.append("testing the");
            result.append("difference");
            result.append("between");
            result.append("String");
            result.append("and");
            result.append("StringBuffer");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 StringBuffer : "
                + (endTime1 - startTime1)+ " ms");
    }


}
