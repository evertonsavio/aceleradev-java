package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	public Double getProductPrice(Long productId){
		Optional<Product> product = productRepository.findById(productId);

		if(product.isPresent() && product.get().getIsSale()){
			return product.get().getValue()*0.8;
		}

		return product.get().getValue();
	}

	@Override
	public Double calculateOrderValue(List<OrderItem> items) {

		return items.stream()
				.map(item -> this.getProductPrice(item.getProductId()) * item.getQuantity())
				.mapToDouble(Double::doubleValue)
				.sum();
	}

	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.map(productRepository::findById)
				.filter(p -> p.isPresent())
				.map(p -> p.get())
				.collect(Collectors.toSet());
	}

	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream()
				.map(this::calculateOrderValue)
				.mapToDouble(Double::doubleValue)
				.sum();
	}

	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream()
				.map(produto -> productRepository.findById(produto))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.groupingBy(Product::getIsSale));
	}
}