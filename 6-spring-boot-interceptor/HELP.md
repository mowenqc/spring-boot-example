1. 建立拦截器，实现HandlerInterceptor
2. 实现接口HandlerInterceptor 的preHandle方法，书写拦截的内容
3. 建立 Webconfig 配置 实现WebMvcConfigurer
4. 实现WebMvcConfigurer的addInterceptors方法，书写拦截的url内容以及排除的内容
5.启动验证，可以正常的拦截登录