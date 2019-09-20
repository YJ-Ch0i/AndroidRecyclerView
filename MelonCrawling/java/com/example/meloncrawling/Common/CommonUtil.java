package com.example.meloncrawling.Common;

/**
 * 공통 메소드
 */
public class CommonUtil {

    /**
     * String 변수 null체크
     * @param str
     * @return true : 빈 값일경우, false: 빈 값이 아닐경우
     */
    public static boolean isNullString(String str){
        if(null == str || Constant.BLANK.equals(str.trim())){
            return true;
        }
        return false;
    }

    public static boolean isNotNullString(String str){
        return !isNullString(str);
    }

    /**
     * 문자열 -> 정수형 형변환
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        if (isNullString(str)) {
            return 0;
        }
        return Integer.parseInt(str.trim());
    }
}
