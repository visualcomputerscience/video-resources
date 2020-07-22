import java.util.List;

interface Product {
    void setPrice();
    void setWeight();
}

interface Employee {
    void setName();
    void setAge();
}

interface StoreFactory {
    List<Product> createProducts();
    List<Employee> createEmployees();
}

class VegetablesStoreFactory implements StoreFactory {

    @Override
    public List<Product> createProducts() {
        // Custom code
        return null;
    }

    @Override
    public List<Employee> createEmployees() {
        // Custom code
        return null;
    }
}
class AutoPartsStoreFactory implements StoreFactory {

    @Override
    public List<Product> createProducts() {
        // Custom code
        return null;
    }

    @Override
    public List<Employee> createEmployees() {
        // Custom code
        return null;
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        StoreFactory storeFactory = new VegetablesStoreFactory();

        List<Employee> employees = storeFactory.createEmployees();
        List<Product> products = storeFactory.createProducts();

        storeFactory = new AutoPartsStoreFactory();
        employees = storeFactory.createEmployees();
        products = storeFactory.createProducts();
    }
}
