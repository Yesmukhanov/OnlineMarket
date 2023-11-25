package FullStack.FinalProject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import FullStack.FinalProject.Mapper.CategoryMapper;
import FullStack.FinalProject.Mapper.OrderMapper;
import FullStack.FinalProject.Mapper.ProductMapper;
import FullStack.FinalProject.Mapper.UserMapper;
import FullStack.FinalProject.dto.CategoryDTO;
import FullStack.FinalProject.dto.OrderDTO;
import FullStack.FinalProject.dto.ProductDTO;
import FullStack.FinalProject.dto.UserDTO;
import FullStack.FinalProject.model.Category;
import FullStack.FinalProject.model.Order;
import FullStack.FinalProject.model.Product;
import FullStack.FinalProject.model.User;
import FullStack.FinalProject.services.CategoryService;
import FullStack.FinalProject.services.ProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FinalProjectOfFinalApplicationTests {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CategoryService categoryService;
	@Autowired private ProductService productService;


	@Test
	void contextLoads() {
	}

	@Test
	void checkCategoryDTO(){
		Category category = new Category();
		category.setId(1L);
		category.setName("Laptop");
		CategoryDTO categoryDTO = categoryMapper.toDTO(category);

		Assertions.assertEquals(category.getId(), categoryDTO.getId());
		Assertions.assertEquals(category.getName(), categoryDTO.getName());
	}

	@Test
	void checkUserDTO(){
		User user = new User();
		user.setId(1L);
		user.setFullName("Dauren Yesmukhanov");
		user.setEmail("yesmukhanov04@gmail.com");
		user.setStatus(false);
		user.setRoleId(1);
		Product product = new Product();
		product.setId(1L);
		product.setName("Iphone");
		Category category = new Category();
		category.setId(1L);
		category.setName("Phone");
		product.setCategory(category);
		product.setPrice(854);
		product.setDescription("The best mobile phone");
		List<Product> products = new ArrayList<>();
		products.add(product);
		user.setProducts(products);
		UserDTO userDTO = userMapper.toDTO(user);
		
		Assertions.assertEquals(user.getId(), userDTO.getId());
		Assertions.assertEquals(user.getFullName(), userDTO.getFullName());
		Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
		Assertions.assertEquals(user.getRoleId(), userDTO.getRoleId());
		Assertions.assertEquals(user.isStatus(), userDTO.isStatus());
	}

	@Test
	void checkProductDTO(){
		Product product = new Product();
        product.setId(1L);
        product.setName("Tablet");
        product.setPrice(854);
        product.setDescription("Tablet is the best");
        ProductDTO productDTO = productMapper.toDto(product);

		Assertions.assertEquals(product.getId(), productDTO.getId());
		Assertions.assertEquals(product.getName(), productDTO.getName());
		Assertions.assertEquals(product.getPrice(), productDTO.getPrice());
		Assertions.assertEquals(product.getDescription(), productDTO.getDescription());

	}

	@Test
	void checkOrderDTO(){
		Order order = new Order();
        order.setId(1L);
        order.setStatus(1);
        order.setDate(LocalDateTime.now());
        OrderDTO orderDTO = orderMapper.toDTO(order);
        Assertions.assertEquals(order.getId(), orderDTO.getId());
        Assertions.assertEquals(order.getStatus(), orderDTO.getStatus());
        Assertions.assertEquals(order.getDate(), orderDTO.getDate());
	}

	@Test
	void checkInsertDb(){

		Category category = new Category();
		category.setName("Phone");

		CategoryDTO categoryDTO = categoryService.addCategory(categoryMapper.toDTO(category));

		Assertions.assertNotNull(categoryDTO);
		Assertions.assertNotNull(categoryDTO.getId());
		Assertions.assertEquals(category.getName(), categoryDTO.getName());

		categoryService.deleteCategory(categoryDTO.getId());
	}


	@Test
	void checkProductInsertToDb(){

		Product product = new Product();
		product.setName("Iphone");
		product.setDescription("The best for using everyday");
		Category category = new Category();
		category.setId(1L);
		category.setName("Phones");
		product.setCategory(category);
		product.setPrice(12004);

		ProductDTO productDTO = productService.addProduct(productMapper.toDto(product));

		Assertions.assertNotNull(productDTO);
		Assertions.assertNotNull(productDTO.getId());
		Assertions.assertEquals(product.getDescription(), productDTO.getDescription());
		Assertions.assertEquals(product.getCategory(), productDTO.getCategory());
		Assertions.assertEquals(product.getPrice(), productDTO.getPrice());
		Assertions.assertEquals(product.getName(), productDTO.getName());


	}


}
