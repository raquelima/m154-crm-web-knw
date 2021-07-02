package ch.ilv.crm.web.controller;

import java.util.HashMap;
import java.util.Map;

import ch.ilv.crm.business.product.IProduct;
import ch.ilv.crm.business.product.ProductFactory;
import ch.ilv.crm.web.Path;
import io.javalin.http.Handler;

public class ProductController {
    public static Handler selectProduct = ctx -> {
        Map<String, Object> model = new HashMap<String, Object>();
       
        int id = Integer.parseInt(ctx.formParam("id"));
        
        IProduct product = ProductFactory.getInstance().findProduct(id);
        
        model.put("product", product);
        ctx.render(Path.Template.PRODUCT, model);
    };
    
    public static Handler createProduct = ctx -> {
        Map<String, Object> model = new HashMap<String, Object>();
        
        String desc = ctx.formParam("description");
        
        IProduct newProduct = ProductFactory.getInstance().createProduct(desc);
        ProductFactory.getInstance().saveProduct(newProduct);
        
        model.put("msg", "Product " + newProduct.getDescription() + " saved!");
        ctx.render(Path.Template.PRODUCTS, model);
    };
    
    public static Handler showIndex = ctx -> {
        ctx.render(Path.Template.PRODUCTS);
    };
}
