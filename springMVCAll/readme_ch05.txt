04-return 控制器方法的返回值表示的处理结果
1. ModelAndView: 有数据和视图，对试图执行forward
2. String:表示视图，可以逻辑名称，也可以是完整视图路径
3. void:在处理ajax的时候，可以用void返回值
4. Object: 例如string, integer, Map, List, Student, 对象有属性，属性就是数据。返回Object就是表示数据，和视图无关。
           可以使用对象表示的数据，响应ajax的请求。
           



Spring mvc中实现Ajax
1. 加入jackson依赖
2. 在springmvc加入注解驱动 <mvc：annotation-driven>
    相当于json = om.writeValueAsString(s);
    注解驱动实现对java到json，xml，二进制的转换，内部是靠HttpMessageConverter接口实现的
    当 <mvc：annotation-driven>加入到springmvc配置文件后，会自动创建HttpMessageConverter接口的7个实现类对象，
    包括MappingJaskson2HttpMessageConverter(使用jackson工具库中的objectmapper实现java对象转为json格式字符串)


3. 在控制类方法中上面加入@ResponseBody注解
    相当于
     response.setContentType("application/json；charset=utf-8");//告诉浏览器是json数据
        PrintWriter pw = response.getWriter();
        pw.write(json)  
    
    通过HttpServletResponse输出数据，相应ajax请求

steps:
1. New web maven project

2. 加入依赖 （在pom.xml加入jar包）
    springmvc依赖，间接把spring的依赖加入到项目
    jsp, servlet依赖

3. 在web.xml中注册springmvc的核心对象dispatcherservlet （配置web.xml文件）
    1）dispatcherservlet is 中央调度器 是一个servelt 父类是继承httpservelt
    2）dispatcherservlet is also a front controller 前端控制器
    3）负责接收用户提交的请求，调用其他的控制器对象，并把请求的处理结果显示给用户

4. 创建发起请求的页面

5. 创建控制器类
    1）在class中加入@controlller注解，创建对象，并放到springmvc容器中
    2）在class中的方法上面加入@requestmapping的注解

6. 创建显示结果的jsp

7. 创建springmvc的配置文件
    1）声明组件扫描器，指定@controller注解所在的包名
    2）声明视图解析器，并处理视图
 