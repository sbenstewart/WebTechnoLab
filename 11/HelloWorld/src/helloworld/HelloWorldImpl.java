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
import javax.jws.WebService;
@WebService(endpointInterface = "helloworld.HelloWorld")  
public class HelloWorldImpl implements HelloWorld{    
    public String getHelloWorldAsString(String name) {  
        return "Server: Roger that... copy...." + name + " ...over";  
    }  
}  
