package Grammar.NetWork;

import java.net.*;
import java.io.*;
class  URLConnectionDemo
{
    public static void main(String[] args) throws Exception
    {
        URL url = new URL("http://192.168.1.254:8080/myweb/demo.html");

        URLConnection conn = url.openConnection();
        System.out.println(conn);

        InputStream in = conn.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        System.out.println(new String(buf,0,len));






    }
}

class URLDemo
{
    public static void main(String[] args) throws MalformedURLException
    {
        URL url = new URL("http://192.168.1.254/myweb/demo.html?name=haha&age=30");


        System.out.println("getProtocol() :"+url.getProtocol());
        System.out.println("getHost() :"+url.getHost());
        System.out.println("getPort() :"+url.getPort());
        System.out.println("getPath() :"+url.getPath());
        System.out.println("getFile() :"+url.getFile());
        System.out.println("getQuery() :"+url.getQuery());

		/*int port = getPort();
		if(port==-1)
			port = 80;

		getPort()==-1
		*/
    }
}
/*
 String getFile()
          获取此 URL 的文件名。
 String getHost()
          获取此 URL 的主机名（如果适用）。
 String getPath()
          获取此 URL 的路径部分。
 int getPort()
          获取此 URL 的端口号。
 String getProtocol()
          获取此 URL 的协议名称。
 String getQuery()
          获取此 URL 的查询部

*/
