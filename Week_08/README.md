学习笔记
# 分库分表策略是通过shardingsphere-proxy来实现
## 版本是5.0.0alpha
## 分库分表配置文件config-sharding.yaml

## 启动shardingsphere-proxy
![avatar](启动.png)

##插入代码示例
![avatar](插入.png)

## 接口调用
![avatar](调用.png)

## 结果日志
![avatar](日志.png)

## 数据库展示
![avatar](数据库.png)


#最后总结：
### 第一次执行的时候，由于插入的数据少，插入的也慢，导致雪花算法生成的id范围小，取模结果一直是0和1；后来经过秦老师的提醒，改用多线程插入，数据增大到100万，这样插入的数据范围大了，插入的也快了，雪花算法生成的id范围也大了，取模的结果也就分散开了