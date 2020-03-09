1.运行环境，jdk1.8
2.配置汇率在配置文件在源码 resource/application.properties，格式为json格式
3.对于配置汇率的币种，在运行时会显示相应的美元金额
4.运行步骤：
  4.1 命令行进入 payment-test-master/target
  4.2 运行命令 java -jar payment-1.0-SNAPSHOT.jar
  4.3 在提示输入文件名时，输入data.txt,或者skip,跳过这一步
  4.4 输入“USD 100”这种格式文本