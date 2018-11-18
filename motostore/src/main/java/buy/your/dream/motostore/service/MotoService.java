package buy.your.dream.motostore.service;


import buy.your.dream.motostore.entity.Motorcycle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MotoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void init() {
        String[] motorcycles = {"Yamaha", "Jawa", "Indian", "Harley-Davidson"};
        for (String brand : motorcycles) {
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.setBrand(brand);
            entityManager.persist(motorcycle);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Motorcycle getMotorcycle(int id) {
        return entityManager.find(Motorcycle.class, id);
    }

//    private int getMotoQuantity(){int motoQuantity = mot; return motoQuantity; }
}
