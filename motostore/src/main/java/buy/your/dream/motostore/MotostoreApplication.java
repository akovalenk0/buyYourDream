package buy.your.dream.motostore;

import buy.your.dream.motostore.entity.Motorcycle;
//import org.apache.log4j.PropertyConfigurator;
import buy.your.dream.motostore.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MotostoreApplication {
    @Autowired
    private MotoService service;

    public static void main(String[] args) {
//        PropertyConfigurator.configure(MotostoreApplication.class.getResource("/log4j.properties"));
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        context.getBean(MotostoreApplication.class).execute();
    }

    public void execute() {
        service.init();

        int x;
        for (x = 1; x< 4; x++){
            Motorcycle moto = service.getMotorcycle(x);
            System.out.println(
                    String.format(
                            "===> {'Motorcycle.id'='%1$s', 'Motorcycle.brand'='%2$s'}",
                            moto.getId(),
                            moto.getBrand()));
        }

    }
}
