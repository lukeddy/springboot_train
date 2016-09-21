package com.tangzq.util;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 文章工具类
 */
public class ChapterUtil {
    private static final int ONE=1;

    /**
     * 解析每个字符出现的次数
     * @param input
     * @return
     */
    public static Map<Character,Integer> countByWord(String input,boolean isValueReverse){
        Map<Character,Integer> map=new HashMap();
        char[] ch=input.toCharArray();
        for(int i=0;i<input.length();i++){
            Integer freq=map.get(ch[i]);
            map.put(ch[i],(freq==null?ONE:freq.intValue()+1));
        }
        return MapUtil.sortByValue(map,isValueReverse);
    }

    /**
     * 指定字符或者字符串出现了多少次
     * @param input
     * @param findStr
     * @return
     */
    public static int countWordsOccurTimes(String input,String findStr){
        return StringUtils.countMatches(input, findStr);
    }


    /**
     * 找到出现次数最多的字符
     * @param input
     * @return
     */
    public static List<Map.Entry<String, Integer>>  findTopFrequentWord(String input) {
        /**
         * 第一步：
         *   使用TreeSet快速找到所有出现的字符串
         *   将输入的字符串按升序排列
         */
        //将String转换为字符数组
        char[] chars=input.toCharArray();
        ArrayList<String> lists=new ArrayList<String>();
        //TreeSet是一个有序集合，TreeSet中的元素将按照升序排列
        //通过TreeSet的不重复性，快速找到所有出现的字符串
        TreeSet<String> set=new TreeSet<String>();
        for (int i = 0; i < chars.length; i++) {
            lists.add(String.valueOf(chars[i]));
            set.add(String.valueOf(chars[i]));
        }
        //set= [a, b, c, d, e, g, h, l, n, o, p, s, t, u, y]
        //System.out.println("set=  "+set);
        //排序
        Collections.sort(lists);
        //lists=  [a, b, c, d, e, e, g, g, g, h, l, n, n, n, n, o, o, p, p, s, t, t, t, u, y]
        //System.out.println("lists=  "+lists);
        //将排序好的字符数组转换为StringBuffer
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < lists.size(); i++) {
            sb.append(lists.get(i));
        }
        input=sb.toString();
        //input= abcdeeggghlnnnnooppstttuy
        //System.out.println("input= "+input);
        /**
         * 第二步： 找出出现相同的字符并记录出现多少次
         */
        //最多重复出现多少次
        int max=0;
        //重复出现的字符
        String maxString="";
        //用来保存出现最多的字符串和次数
        HashMap<String, Integer> hm=new HashMap();
        //将出现过的字符遍历
        Iterator<String> its=set.iterator();
        while (its.hasNext()) {
            String os=its.next();
            //字符出现在排序后input中的第一次位置
            int begin=input.indexOf(os);
            //字符出现在排序后input中的最后一次位置
            int end=input.lastIndexOf(os);
            //字符出现的次数
            int value=end-begin+1;
            if (value>=max) {
                max=value;
                maxString=os;
                hm.put(maxString, max);
            }
        }
        //System.out.println(hm);
        List<Map.Entry<String, Integer>> occorMostList=new ArrayList();
        for (Map.Entry<String, Integer> enties: hm.entrySet()) {
            if (enties.getValue()==max) {
                //System.out.print("重复最多的字母是:"+enties.getKey());
                //System.out.println("重复最多的次数是:"+enties.getValue());
                occorMostList.add(enties);
            }
        }
        return occorMostList;
    }
}
