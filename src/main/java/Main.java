import entity.EmployeesEntity;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            EmployeesEntity alex = new EmployeesEntity();
            alex.setName("Alexey");
            alex.setSurname("Vershinin");
            alex.setDepartment("IT");
            alex.setSalary(3500);
            entityManager.persist(alex);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
