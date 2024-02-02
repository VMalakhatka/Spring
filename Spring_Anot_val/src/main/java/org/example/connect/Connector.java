package org.example.connect;

import org.example.properties.ConnectionProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Connector {

    private ConnectionProperties connectionProperties;

//    @Autowired
    public Connector(ConnectionProperties connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public void connect(){
        System.out.println(" Пробую сделать соединение с host " + connectionProperties.host()+
                " с портом "+ connectionProperties.port());
        try {
            Thread.sleep(3000);
            System.out.println("Успешное соединени");
        } catch (InterruptedException e) {
            System.out.println("Не удалось востановить соединение");
            throw new RuntimeException(e);

        }

    }
}
