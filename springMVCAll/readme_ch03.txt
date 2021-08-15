03-receiveparam - 接受用户请求的参数
1) HttpServletRequest 
2) HttpServletResponse
3) HttpSession
4) 用户提交数据

接受用户提交数据的方式：
1.逐个接受
2.对象接受


注意
   1. 如果name是中文，用get可以正常显示，但用post不能会显示乱码，以前servlet的解决方法是
        public void doGet(HttpServletRequest request){
            request.setCharacterEncoding("utf-8");
        }
       Spring框架可以用过滤器解决乱码问题
       1)在web.xml中配置
       2)过滤器可以自定义
       3)也可以使用框架中的CharacterEncodingFilter


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
 