package com.ai.eve.ui.demo.utils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: mbao
 * Date: 14-3-4
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil {

    public static final String REGEX_EMAIL = "(\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)";
    public static final String REGEX_TEL_NUM = "(1[345678][0-9０-９\\-－ 　]{9,11})|([0-9]{3,4}[\\- ][0-9０-９\\-－ 　]{7,8}|\\d{7,8})";
    public static final String REGEX_QQ_NUM = "(qq|扣扣).{0,3}[1-9０-９][0-9０-９\\s]{3,}[0-9０-９]";
    public static final String REGEX_URL_NUM = "([a-zA-z]+://[^\\s]*)|([/]*[\\w-]+\\.[\\w-]+\\.[\\w-]*)";
    public static final String REGEX_GENERAL_NUM = "[0-9０-９-－ 　]{6,}";
    public static final String REGEX_XSS = "[><].*(a |xml|img|script|alert|src|onload|body|iframe|input|link|meta|style|div|table|embed|base|href|object).*[><]*";
    public static final String DEFAULT_REPLACE_STR = "";
    public static final String DEFAULT_WEIBO_LOGO_FORMAT = "http://tp4.sinaimg.cn/%d/180/0/1";

    public static String[] sournames = {"宇文",
            "尉迟",
            "延陵",
            "羊舌",
            "羊角",
            "乐正",
            "诸葛",
            "颛孙",
            "仲孙",
            "仲长",
            "长孙",
            "钟离",
            "宗政",
            "左丘",
            "主父",
            "宰父",
            "子书",
            "子车",
            "子桑",
            "百里",
            "北堂",
            "北野",
            "哥舒",
            "谷梁",
            "闻人",
            "王孙",
            "王官",
            "王叔",
            "巫马",
            "微生",
            "淳于",
            "单于",
            "成公",
            "叱干",
            "叱利",
            "褚师",
            "端木",
            "东方",
            "东郭",
            "东宫",
            "东野",
            "东里",
            "东门",
            "第二",
            "第五",
            "公祖",
            "公玉",
            "公西",
            "公孟",
            "公伯",
            "公仲",
            "公孙",
            "公广",
            "公上",
            "公冶",
            "公羊",
            "公良",
            "公户",
            "公仪",
            "公山",
            "公门",
            "公坚",
            "公乘",
            "欧阳",
            "濮阳",
            "青阳",
            "漆雕",
            "壤驷",
            "上官",
            "司徒",
            "司马",
            "司空",
            "司寇",
            "士孙",
            "申屠",
            "叔孙",
            "叔仲",
            "侍其",
            "令狐",
            "梁丘",
            "闾丘",
            "刘傅",
            "慕容",
            "万俟",
            "谷利",
            "高堂",
            "南宫",
            "南门",
            "南荣",
            "南野",
            "女娲",
            "纳兰",
            "澹台",
            "拓跋",
            "太史",
            "太叔",
            "太公",
            "秃发",
            "夏侯",
            "西门",
            "鲜于",
            "轩辕",
            "相里",
            "皇甫",
            "赫连",
            "呼延",
            "胡母",
            "亓官",
            "夹谷",
            "即墨",
            "独孤",
            "段干",
            "达奚",
    };

    public static <T> String implode(List<T> list, String delimiter) {
        if (list == null) {
            return null;
        }
        if (delimiter == null) {
            delimiter = ",";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (T val : list) {
            if (val != null) {
                if (flag) {
                    sb.append(delimiter);
                } else {
                    flag = true;
                }
                sb.append(val.toString());
            }
        }
        return sb.toString();
    }

    public static <T> String implode(T[] array, String delimiter) {
        return implode(java.util.Arrays.asList(array), delimiter);
    }

    public static <T> String implode(List<T> list) {
        return implode(list, ",");
    }

    public static <T> String implode(T[] array) {
        return implode(java.util.Arrays.asList(array), ",");
    }

    public static ArrayList<String> explode(String string, String separator) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String[] array = string.split(separator);
        ArrayList<String> result = new ArrayList<String>();
        Collections.addAll(result, array);
        return result;
    }

    public static <T> String implodeForSqlRange(List<T> list) {
//        if (CommonUtil.isEmpty(list)) {
//            return null;
//        }
        StringBuilder sb = new StringBuilder("'");
        boolean flag = false;
        for (T val : list) {
            if (flag) {
                sb.append("','");
            } else {
                flag = true;
            }
            sb.append(val.toString().trim());
        }
        sb.append("'");
        return sb.toString();
    }

    public static <T> String implodeForSqlRange(T[] array) {
        return implodeForSqlRange(java.util.Arrays.asList(array));
    }

    public static String filterEmail(String content) {
        return filterEmail(content, "***");
    }

    public static String filterEmail(String content, String replaceStr) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher m = pattern.matcher(content);
        return m.replaceAll(replaceStr);
    }

    public static String filterTelNumber(String content, String replaceStr) {
        Pattern pattern = Pattern.compile(REGEX_TEL_NUM);
        Matcher m = pattern.matcher(content);
        return m.replaceAll(replaceStr);
    }

    public static String filterTelNumber(String content) {
        return filterTelNumber(content, "***");
    }

    public static String filterQQNumber(String content, String replaceStr) {
        Pattern pattern = Pattern.compile(REGEX_QQ_NUM);
        Matcher m = pattern.matcher(content);
        return m.replaceAll(replaceStr);
    }

    public static String filterQQNumber(String content) {
        return filterQQNumber(content, "***");
    }

    public static String filterUrl(String content, String replaceStr) {
        Pattern pattern = Pattern.compile(REGEX_URL_NUM);
        Matcher m = pattern.matcher(content);
        return m.replaceAll(replaceStr);
    }

    public static String filterUrl(String content) {
        return filterUrl(content, "***");
    }

    public static String filerString(String content, String replaceStr, String... regex) {
        if (content != null && regex != null && regex.length > 0) {
            if (replaceStr == null) {
                replaceStr = DEFAULT_REPLACE_STR;
            }
            Pattern pattern;
            Matcher matcher;
            for (String val : regex) {
                pattern = Pattern.compile(val, Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(content);
                content = matcher.replaceAll(replaceStr);
            }
        }
        return content;
    }

    public static String getSourName(String name) {
        if (name == null || name.length() < 2) {
            return name;
        } else if (name.length() == 2) {
            return name.substring(0, 1);
        } else {
            String prefix = name.substring(0, 2);
            for (String surename : sournames) {
                if (surename.equals(prefix)) {
                    return surename;
                }
            }
            return name.substring(0, 1);
        }
    }

    public static List<String> eachAppend(List<String> list, String appendStr) {
        if (list != null && list.size() > 0) {
            List<String> result = new ArrayList<String>(list.size());
            for (String item : list) {
                result.add(item + appendStr);
            }
            return result;
        }
        return list;
    }


    public static String urlEncoder(String url) {
        try {
            url = URLEncoder.encode(url, "utf-8").replaceAll("%2C", ",").replaceAll("%2F", "/").replaceAll("%3A", ":").replaceAll("%3B", ";").replaceAll("%7B", "{").replaceAll("%22", "\"").replaceAll("%7D", "}").replaceAll("\\+", "%20");
        } catch (Exception ignore) {
        }
        return url;
    }

//    public static String getEmailDomain(String email) {
//        String[] strings = StringUtils.split(email, "@");
//        if (strings.length == 2) {
//            return strings[1].toLowerCase();
//        }
//        return "";
//    }

    public static String generateKey(int length, boolean onlyNum) {
        char[] str;
        if (onlyNum) {
            str = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        } else {
            str = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        }
        StringBuilder result = new StringBuilder();
        int randomMaxRange = str.length;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(str[random.nextInt(randomMaxRange)]);
        }
        return result.toString();
    }

}
