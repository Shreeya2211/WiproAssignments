package mymockitos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductMockitoDemo {

    @InjectMocks
    private ProductService123 productService;  // Class under test

    @Mock
    private ProductRepository123 productRepository; // Dependency

    private AutoCloseable closeable; // To close mocks after tests

    @Before
    public void setUp() {
        // ✅ Use openMocks for Mockito 5
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProductName() {
        // Arrange
        Product123 mockProduct = new Product123(101, "Laptop", 75000);
        when(productRepository.findProductById(101)).thenReturn(mockProduct);

        // Act
        String name = productService.getProductName(101);

        // Assert
        verify(productRepository, times(1)).findProductById(101);
        assertEquals("Laptop", name);
    }
}
