package com.tangzq.producer;

import com.tangzq.producer.config.ZookeeperProperties;
import kafka.admin.AdminUtils;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 项目启动时做一些初始化工作
 */
@Component
@EnableConfigurationProperties(ZookeeperProperties.class)
public class BootstrapHelper implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapHelper.class);

    @Autowired
    private ZookeeperProperties zookeeperProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      logger.info("项目开始启动....");
      logger.info("开始创建topic");
       initKafkaTopics();
      logger.info("创建topic完成");
      logger.info("项目启动初始化工作完成！Great!");
    }

    private void initKafkaTopics(){
        ZkClient zkClient = null;
        try{
            String [] topics={"topic01","topic02","topic03","topic04"};
            String zookeeperHosts = zookeeperProperties.getZookeeperAddress(); //多台用逗号分隔-> String zookeeperHosts = "192.168.20.1:2181,192.168.20.2:2181";
            zkClient = new ZkClient(zookeeperHosts, 10000, 10000);
            for(String topic:topics){
                if(!AdminUtils.topicExists(zkClient,topic)){
                    AdminUtils.createTopic(zkClient, topic, 1, 1, new Properties());
                    logger.info(topic+ " 创建成功！");
                }else{
                    logger.warn(topic+ " 已经存在！");
                }
            }
        }catch (Exception e){
            logger.error("创建topic出错",e);
        }finally {
            if (zkClient != null) {
                zkClient.close();
            }
        }
    }
}
