package com.tangzq;

import com.tangzq.model.*;
import com.tangzq.service.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private IPService ipService;

	@Test
	public void test() throws Exception {
		IPResponse ipResponse=ipService.queryByIP("11.14.110.111");
		if(ipResponse.getErrNum()==0){
			System.out.println("成功!");
			System.out.println(ipResponse.getRetData().toString());
		}
		if(ipResponse.getErrNum()!=0){
			System.out.printf(ipResponse.getErrMsg());
			System.out.printf(ipResponse.getRetData().toString());
		}
		Assert.notNull(ipResponse);
		System.out.println(ipResponse);
	}


	/**
	 * ip.txt文件中数据格式：
		 IP  METHOD  PV  错误访问次数  流量
		 139.200.100.53  GET 43  0 10.926MB
		 218.89.99.70  GET 43  0 11.261MB
		 222.213.192.105 GET 43  0 11.48MB
	 * 批量查询IP并导出到文件
	 * @throws Exception
	 */
	@Test
	public void testQueryByIP() throws Exception {
		FileInputStream fileInputStream=new FileInputStream(new File("D:\\workspace_github\\springboot_train\\springboot-jsp-ip-parser\\data\\ip.txt"));
		FileOutputStream fileOutputStream=new FileOutputStream(new File("D:\\workspace_github\\springboot_train\\springboot-jsp-ip-parser\\data\\ip_output.txt"));
		List<String> lines= IOUtils.readLines(fileInputStream);
		String newLine="";
		for(String line:lines){
			String ip=line.split(" ")[0];
			if("IP".equals(ip)){
				newLine=line+" 查询结果\n";
			}else{
				IPResponse ipResponse=ipService.queryByIP(ip);
				if(ipResponse.getErrNum()==0){
					System.out.println("成功!");
					Map<String,String> map=(HashMap<String,String>)ipResponse.getRetData();
					//String values=StringUtils.join(map.values(), ",");
					newLine=line+" "+getValStr(map)+"\n";
				}
				if(ipResponse.getErrNum()!=0){
					System.out.printf(ipResponse.getErrMsg());
					newLine=line+" 未知\n";
				}
			}
			IOUtils.write(newLine,fileOutputStream);
		}
	}


	/**
	 * 不需要IP地址：
	 *格式：
	 {"ip":"183.222.249.239",
	 "country":"\u4e2d\u56fd",
	 "province":"\u56db\u5ddd",
	 "city":"\u8fbe\u5dde",
	 "district":"\u5ba3\u6c49",
	 "carrier":"\u4e2d\u56fd\u79fb\u52a8"}
	 * @param map
	 * @return
	 */
	private String getValStr(Map<String,String> map){
		return map.get("country")+","+map.get("province")+","+map.get("city")+","+map.get("district")+","+map.get("carrier");
	}
}
