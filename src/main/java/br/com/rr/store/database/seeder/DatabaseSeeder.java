package br.com.rr.store.database.seeder;

import br.com.rr.store.category.domain.entity.Category;
import br.com.rr.store.category.domain.repository.CategoryRepository;
import br.com.rr.store.order.domain.entity.Order;
import br.com.rr.store.order.domain.enums.OrderStatus;
import br.com.rr.store.order.domain.repository.OrderRepository;
import br.com.rr.store.orderitem.entity.OrderItem;
import br.com.rr.store.payment.domain.entity.Payment;
import br.com.rr.store.product.domain.entity.Product;
import br.com.rr.store.product.domain.repository.ProductRepository;
import br.com.rr.store.user.domain.entity.User;
import br.com.rr.store.user.domain.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Component
public class DatabaseSeeder {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;

    public DatabaseSeeder(UserRepository userRepository,
                          ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void init() {
        //create categories
        Category electronic = new Category(null, "Eletrônicos");
        Category books = new Category(null,"Livros");
        categoryRepository.saveAll(List.of(electronic,books));

        //create products

        Product product1 = new Product(null,"Celular","Samsung 23", 2.500,"teste.pdf");
        Product product2 = new Product(null,"Senhor dos anéis","livro", 33.00,"teste.pdf");
        Product product3 = new Product(null,"Notebook","Dell", 3000.0,"teste.pdf");
        productRepository.saveAll(List.of(product1,product2,product3));

        //Category_product

        electronic.addProduct(product1);
        electronic.addProduct(product3);


        books.addProduct(product2);




        categoryRepository.saveAll(List.of(electronic, books));


        User user = new User(null, "Maria Silva", "maria@gmail.com",LocalDate.of(1990, 5, 20),"11988887777","1234");
        userRepository.save(user);


        Order order = new Order(null, Instant.now(), OrderStatus.PAID, user);
        OrderItem item1 = new OrderItem(null, 1, product1.getPrice(), order, product1);
        OrderItem item2 = new OrderItem(null, 2, product2.getPrice(), order, product2);

        order.addItem((item1));
        order.addItem((item2));
        Payment payment = new Payment(null, order, Instant.now());
        order.setPayment(payment);

        orderRepository.save(order);



    }

}
