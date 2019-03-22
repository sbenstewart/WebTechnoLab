/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author sf52
 */
import java.net.URL;  
import javax.xml.namespace.QName;  
import javax.xml.ws.Service;  
public class HelloWorldClient{  
    public static void main(String[] args) throws Exception {  
    URL url = new URL("http://localhost:7779/ws/hello?wsdl");  
   
        //1st argument service URI, refer to wsdl document above  
    //2nd argument is service name, refer to wsdl document above  
        QName qname = new QName("http://helloworld/", "HelloWorldImplService");  
        Service service = Service.create(url, qname);  
        HelloWorld hello = service.getPort(HelloWorld.class);  
        System.out.println(hello.getHelloWorldAsString("india is democratic"));  
     }  
 }  
