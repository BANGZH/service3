package com.cloud.service3;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class CodeGeneratorV1 {


    private static final String jdbcUserName = "";
    private static final String jdbcPassword = "";

    //表名，可以设置多个，通过英文逗号分隔
    //数据库用户密码，必须使用表的所有者（Owner）
    private static final String tables = "";
    private static final String moduleName = "";//模块名称，分业务，不要漏最后面一个点

    private static final String tablePrefix = "";//表名前缀

    /**
     * 代码生成器的配置常量
     */
    private static final String outPutDir = "/service3/src/main/java";
    //Oracle：jdbc:oracle:thin:@192.168.110.2:1521:ORAPLAN

    private static final String jdbcUrl = "jdbc:mysql://";

    //oracle.jdbc.OracleDriver
    //oracle.jdbc.driver.OracleDriver
    //com.mysql.cj.jdbc.Driver
    private static final String jdbcDriverClassName = "com.mysql.cj.jdbc.Driver";

    private static final String parentPackage = "";

    private static final String authorName = "";//作者

    private static final String mapperPattern = "%sMapper";//dao文件命名格式
    private static final String mapperName = moduleName + "repository";
    private static final String xmlName = mapperName;

    private static final String serviceNamePattern = "%sService";//Service文件命名格式
    private static final String serviceName =  moduleName + "service";
    private static final String implName =  moduleName + "service";
    private static final String pojoName =  moduleName + "domain.entity";
    private static final String controllerName =  moduleName + "controller";


    // 当前工程路径   配合outPutDir使用，例如多模块开发 Demo/test1，Demo/test2
    // projectPath拿到的是Demo路径，把outPutDir设置成/test1即可
    private static final String projectPath = System.getProperty("user.dir");

    public static void generator() {

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + outPutDir);
        gc.setAuthor(authorName);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        // 覆盖生成的文件
        gc.setFileOverride(true);
        gc.setServiceName(serviceNamePattern);
        gc.setMapperName(mapperPattern);
        gc.setEnableCache(false);//是否在xml中添加二级缓存配置：false不生成
        gc.setOpen(false);//true:生成文件后，自动打开文件夹
        gc.setDateType(DateType.ONLY_DATE);//设置时间类型
        gc.setSwagger2(true);//设置生成Swagger2 Api注解

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);

        //设置类型转换，默认不太好
        //这个是Oracle的
        /*
        dsc.setTypeConvert(new OracleTypeConvert() {

            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                String fileTypeLower = fieldType.toLowerCase();
                if(fileTypeLower.contains("number")) {
                    //System.out.println("fileTypeLower = " + fileTypeLower);

                    if(fileTypeLower.equals("number")) {//默认长度为38位，占用22个字节空间
                        return DbColumnType.LONG;
                    }
                    if(fileTypeLower.contains(",")) {
                        return DbColumnType.DOUBLE;
                    }else {
                        String num = StrUtils.getNumberText(fileTypeLower);
                        int numInt = Integer.parseInt(num);
                        if(numInt == 1) {
                            return DbColumnType.BYTE;
                        }
                        if(numInt > 1 && numInt <=4) {
                            return DbColumnType.SHORT;
                        }
                        if(numInt > 4 && numInt <=9) {
                            return DbColumnType.INTEGER;
                        }
                        if(numInt > 9 && numInt <=18) {
                            return DbColumnType.LONG;
                        }
                        if(numInt > 18) {
                            return DbColumnType.BIG_DECIMAL;
                        }
                        return DbColumnType.LONG;
                    }
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        */
        dsc.setUrl(jdbcUrl);
        dsc.setDriverName(jdbcDriverClassName);
        dsc.setUsername(jdbcUserName);
        dsc.setPassword(jdbcPassword);
        // dsc.setSchemaName("public");


        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent(parentPackage);

        pc.setParent(parentPackage);
        pc.setMapper(mapperName);
        pc.setEntity(pojoName);
        pc.setService(serviceName);
        pc.setController(controllerName);
        pc.setServiceImpl(implName);
        pc.setXml(xmlName);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("BaseEntity");
        strategy.setEntityLombokModel(true);//设置Lombok模式
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(false);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        if(!StringUtils.isBlank(tablePrefix)) {
            strategy.setTablePrefix(tablePrefix);
        }
        //strategy.entityTableFieldAnnotationEnable(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setInclude(tables.toUpperCase().split(","));//Oracle数据，表名一定要大写，且表名要对应创建的用户，否则不生成代码


        InjectionConfig injectionConfig = new InjectionConfig() {

            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setPackageInfo(pc);
        mpg.setStrategy(strategy);
        mpg.setCfg(injectionConfig);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    public static void main(String[] args) {
        generator();
    }
}