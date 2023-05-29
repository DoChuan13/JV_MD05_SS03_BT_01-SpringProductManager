package backend.controller;

import backend.model.Product;
import backend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "product"})
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showListProduct() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailProduct(
            @PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        Product product = new Product();
        int id = productService.generateLinearId();
        product.setId(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/create")
    public String actionCreate(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(
            @PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String actionEdit(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String actionDelete(
            @PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
