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
import javax.xml.ws.Endpoint;  
//Endpoint publisher  
public class HelloWorldPublisher{  
    public static void main(String[] args) {  
       Endpoint.publish("http://localhost:7779/ws/hello", new HelloWorldImpl());  
        }  
}
