/**
 * FileName: SwaggerConfig
 * Author:   xph
 * Date:     2019/4/12 16:41
 * Description:
 */
package org.i9.xiaofang.web.config;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lenovo
 * @create 2019/4/12
 * @since 1.0.0
 */
public class SwaggerConfig {


//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    /*@Bean
    public Docket createRestApi (){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("org.i9.xiaofang.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring boot 中使用Swagger2构建RESTFUL APIS")
                .description("欢迎使用")
                .termsOfServiceUrl("http:www.baidu.com")
                .version("1.0")
                .build();
    }*/
}
