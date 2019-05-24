package org.i9.xiaofang.web.MybatisGenerator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MpGenerator {

        /**
         * <p>
         * 读取控制台内容
         * </p>
         */
        public static String scanner(String tip) {
            Scanner scanner = new Scanner(System.in);
            StringBuilder help = new StringBuilder();
            help.append("请输入" + tip + "：");
            System.out.println(help.toString());
            if (scanner.hasNext()) {
                String ipt = scanner.next();
                if (StringUtils.isNotEmpty(ipt)) {
                    return ipt;
                }
            }
            throw new MybatisPlusException("请输入正确的" + tip + "！");
        }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/i9-xiaofang-web/src/main/java");
        gc.setAuthor("xuepuhao");
        gc.setOpen(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/lockplatform?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123qwe");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        Map<String, String> configPathInfo = new HashMap() {
            {
                put(ConstVal.XML_PATH, projectPath+"/i9-xiaofang-service/src/main/resources/mapper");
                put(ConstVal.MAPPER_PATH, projectPath+"/i9-xiaofang-service/src//main/java/org/i9/xiaofang/service/repository/mapper");
                put(ConstVal.ENTITY_PATH, projectPath+"/i9-xiaofang-service/src/main/java/org/i9/xiaofang/service/repository/model");
                put(ConstVal.SERVICE_PATH, projectPath+"/i9-xiaofang-service/src/main/java/org/i9/xiaofang/service");
                put(ConstVal.SERVICE_IMPL_PATH, projectPath+"/i9-xiaofang-service/src/main/java/org/i9/xiaofang/service/Impl");
                put(ConstVal.CONTROLLER_PATH, projectPath+"/i9-xiaofang-web/src/main/java/org/i9/xiaofang/web/controller");
            }
        };
        pc.setPathInfo(configPathInfo);
        pc.setModuleName("");
        pc.setParent("org.i9.xiaofang");
        pc.setController("web.controller");
        pc.setMapper("service.repository.mapper");
        pc.setService("service");
        pc.setServiceImpl("service.Impl");
        pc.setEntity("service.repository.model");
        mpg.setPackageInfo(pc);

        mpg.setTemplate(new TemplateConfig());

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(scanner("表名"));
        // 自定义 controller 父类
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
