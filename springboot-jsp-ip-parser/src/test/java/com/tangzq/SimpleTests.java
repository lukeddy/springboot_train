package com.tangzq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tangzq.model.PieData;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;


public class SimpleTests {

    ObjectMapper mapper=new ObjectMapper();

    @Test
    public void testCounter() throws IOException {
        FileInputStream fileInputStream=new FileInputStream(new File("D:\\workspace_github\\springboot_train\\springboot-jsp-ip-parser\\data\\ip.txt"));
        FileOutputStream fileOutputStream=new FileOutputStream(new File("D:\\workspace_github\\springboot_train\\springboot-jsp-ip-parser\\data\\output.txt"));
        List<String> lines=IOUtils.readLines(fileInputStream, Charset.forName("utf-8"));
        for(String line:lines){
            //System.out.println(line.split(" ")[0]);
            String newLine=line+" aaaa\n";
            IOUtils.write(newLine,fileOutputStream);
        }
    }

    @Test
    public void testStatisData() throws IOException {
        FileInputStream fileInputStream=new FileInputStream(new File("D:\\workspace_github\\springboot_train\\springboot-jsp-ip-parser\\data\\output.txt"));
        List<String> lines=IOUtils.readLines(fileInputStream);

        List<String> provinceList=new ArrayList();
        List<String> cityList=new ArrayList();
        List<String> districtList=new ArrayList();


        for(String line:lines){
            String ipInfo=line.split(" ")[5];
            if(ipInfo.contains(",")){
                //System.out.println(ipInfo);
                String []ipInfoArr=ipInfo.split(",");
                provinceList.add(ipInfoArr[1]);
                cityList.add(ipInfoArr[2]);
                districtList.add(ipInfoArr[3]);
            }
        }


//        System.out.println(provinceList);
//        System.out.println(cityList);
//        System.out.println(districtList);

        Set<String> provinceSet=new HashSet();
        Set<String> citySet=new HashSet();
        Set<String> districtSet=new HashSet();

        for(String province:provinceList){
            provinceSet.add(province);
        }
        for(String city:cityList){
            citySet.add(city);
        }
        for(String district:districtList){
            districtSet.add(district);
        }

//        System.out.println(provinceSet);
//        System.out.println(citySet);
//        System.out.println(districtSet);

        Map<String,Integer> provinceMap=new HashMap();
        for(String province:provinceSet){
            provinceMap.put(province,calAreaCount(province,provinceList));
        }

        Map<String,Integer> cityMap=new HashMap();
        for(String city:citySet){
            cityMap.put(city,calAreaCount(city,cityList));
        }

        Map<String,Integer> districtMap=new HashMap();
        for(String district:districtSet){
            districtMap.put(district,calAreaCount(district,districtList));
        }


        System.out.println(provinceMap);
        System.out.println(cityMap);
        System.out.println(districtMap);


        Map<String,Set<String>> provinceCityMap=new HashMap();
        for(String province:provinceList){
            Set<String> tempCitySet=new HashSet();
            for(String line:lines){
                String ipInfo=line.split(" ")[5];
                if(ipInfo.contains(",")){
                    //System.out.println(ipInfo);
                    String []ipInfoArr=ipInfo.split(",");
                    if(province.equals(ipInfoArr[1])){
                        tempCitySet.add(ipInfoArr[2]);
                    }
                }
            }
            provinceCityMap.put(province,tempCitySet);
        }

        Map<String,Set<String>> cityDistrictMap=new HashMap();
        for(String city:cityList){
            Set<String> tempDistrictSet=new HashSet();
            for(String line:lines){
                String ipInfo=line.split(" ")[5];
                if(ipInfo.contains(",")){
                    //System.out.println(ipInfo);
                    String []ipInfoArr=ipInfo.split(",");
                    if(city.equals(ipInfoArr[2])){
                        tempDistrictSet.add(ipInfoArr[3]);
                    }
                }
            }
            cityDistrictMap.put(city,tempDistrictSet);
        }

        //System.out.println(provinceCityMap);
        //System.out.println(cityDistrictMap);

        //指定省份
        Map<String,Integer> siChuanCityCountMap=new HashMap();
        for(String city:provinceCityMap.get("四川")){
            //System.out.print(city+"\t");
            int cityIpCount=0;
            for(String line:lines){
                String ipInfo=line.split(" ")[5];
                if(ipInfo.contains(",")){
                    String []ipInfoArr=ipInfo.split(",");
                    if(city.equals(ipInfoArr[2])){
                        cityIpCount++;
                    }
                }
            }
            siChuanCityCountMap.put(city,cityIpCount);
        }

        System.out.println(siChuanCityCountMap);

        //形成饼图数据
       String provinceJSON= mapper.writeValueAsString(convert2PieDat(provinceMap));
        String cityJSON=mapper.writeValueAsString(convert2PieDat(cityMap));
        String districtJSON=mapper.writeValueAsString(convert2PieDat(districtMap));
        String sichuanCityJSON=mapper.writeValueAsString(convert2PieDat(siChuanCityCountMap));

        System.out.println(provinceJSON);
        System.out.println(cityJSON);
        System.out.println(districtJSON);
        System.out.println(sichuanCityJSON);

    }

    private List<PieData> convert2PieDat(Map<String,Integer> map){
        List<PieData> pieDataList=new ArrayList();
        Set<String> keys=map.keySet();
        for(String key:keys){
            pieDataList.add(new PieData(key,map.get(key)));
        }
        return pieDataList;
    }

    private Integer calAreaCount(String targetArea,List<String> areaList){
        int areaCount=0;
        for(String area:areaList){
            if(targetArea.equals(area)){
                areaCount++;
            }
        }
        return areaCount;
    }
}
