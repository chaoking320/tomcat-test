tomcat：C:\Program Files\Java\apache-tomcat-8.5.6\webapps
nginx：C:\Program Files\Java\nginx-1.12.2\html

idea  spring boot  更改默认端口 application.properties 文件，相应配置：server.port=8181
1、刚开始MyHttpClient类放在了utils目录下，加上Component注解也无法识别，原因是目录问题，将其放在跟controller同一目录下即可，
   或者可以在demoapplication中添加注解，具体参见google/baidu
   具体报错信息如下：“Consider defining a bean of type 'xxx' in your configuration”
2、启动nginx的方法：
    1）直接双击nginx.exe，双击后一个黑色的弹窗一闪而过。
    2）打开cmd命令窗口，切换到nginx目录下，输入命令 nginx.exe 或者 start nginx ，回车即可。
   nginx的配置文件：conf/nginx.conf
3、跨域问题终于搞定，采用jsonp的方式处理
    服务端代码：
    @RequestMapping(value = "/callback4jsonp", method = RequestMethod.GET)
    @ResponseBody
    public String callback4Jsonp(HttpServletRequest request) throws IOException {
        String callback = request.getParameter("callback");
        Long orderId = Long.parseLong(request.getParameter("orderId"));
        String msg ="({\"userId\":\"E540365921\"})";
        return callback+"("+msg+")";
    }
    客户端代码：
    function dotest4jsonp() {
        $.ajax({
            type: "GET", //Post传参
            url: "http://localhost:8181/test/callback4jsonp",//服务地址
            data: "x=x&orderId=1",//参数
            dataType: "jsonp",
            jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
            jsonpCallback:"testcallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
            //contentType: "application/json;charset=utf-8",
            success: function (result) {
                successFun(result);
            },
            error: function (jqXHR, error, errorThrown) {
                errorFun(jqXHR, error, errorThrown);
            }
        })
    }
    // callback的方法
    function testcallback(json){
        alert(json.userId);
    }
