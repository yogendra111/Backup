package com.dtproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dtproject.model.CartItem;
import com.dtproject.model.Product;
import com.dtproject.model.User;
import com.dtproject.service.CartItemService;
import com.dtproject.service.CartService;
import com.dtproject.service.ProductService;

@Controller
public class CartController 
{
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
@RequestMapping("/addIntoCart")
private String addIntoCart(@RequestParam("pid") String productId,@RequestParam("quantity") String productQuantity)
{
	System.out.println("add into cart "+productId+" "+productQuantity);
	return "redirect:/myFlow?pid="+productId+"&quantity="+productQuantity;
	
}

@RequestMapping(value="cart")
public ModelAndView cart(HttpServletRequest request) {
	System.out.println("cart");
	ModelAndView mv = new ModelAndView();
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	List<CartItem> cartItemList= cartItemService.findByCartId(user.getCartId());

	Map<CartItem,Product> map = new HashMap<CartItem,Product>();
	int total=0,item=0;
	
	for(CartItem c : cartItemList) {
		total=(int)c.getProductprice()+total;
		System.out.println(total);
		item=item+1;
		System.out.println(item);
		Product product= productService.findProductById(c.getProductId());
		map.put(c, product);
	}
	
	mv.addObject("total",total);
	mv.addObject("item",item);
	mv.addObject("itemList", map);
	mv.setViewName("cart");
	return mv;
}

@RequestMapping(value="updateCart/{cartItemId}/{q}")
public String updateCartItem(@PathVariable int cartItemId,@PathVariable int q) {
	cartService.updateCartItem(cartItemId,q);
	
	return "redirect:/cart";
}

@RequestMapping(value="deleteCart/{cartItemId}")
public String deleteCartItem(@PathVariable int cartItemId) {
	cartItemService.deleteCartItem(cartItemId);
	return "redirect:/cart";
}
}
