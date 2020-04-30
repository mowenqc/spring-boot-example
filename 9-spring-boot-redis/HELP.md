1. 新建一个filter 实现javax.servlet.Filter
2. 写拦截的内容
3. 添加注解@WebFilter(urlPatterns = "/*")
4. 在Application上增加注解
@ServletComponentScan(basePackages = {"com.mowen.filter.filter"})