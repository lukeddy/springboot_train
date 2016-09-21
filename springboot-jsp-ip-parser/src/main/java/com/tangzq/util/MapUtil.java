package com.tangzq.util;

import java.util.*;

/**
 * Map工具类
 */
public class MapUtil {

    /**
     * 根据map的key排序
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V>  sortByKey( Map<K, V> map ){
        return  new TreeMap<K, V>(map);
    }

    /**
     * 根据map的值进行排序
     * @param map
     * @param isReverse  是否降需排序
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V>  sortByValue( Map<K, V> map,boolean  isReverse)
    {
        List<Map.Entry<K, V>> list =new LinkedList( map.entrySet() );
        Collections.sort( list, (o1, o2) -> (o1.getValue()).compareTo( o2.getValue() ));
        if(isReverse){
            Collections.reverse(list);
        }
        Map<K, V> result = new LinkedHashMap();
        for (Map.Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }


}
