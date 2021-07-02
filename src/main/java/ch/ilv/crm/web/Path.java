package ch.ilv.crm.web;

public class Path {

    public static class Web {
        public static final String INDEX = "index";
        
        public static final String CUSTOMER = "customer";
        public static final String CUSTOMERS = "customers";
        public static final String CREATE_CUSTOMER = "createcustomer";
        
        public static final String PRODUCT = "product";
        public static final String PRODUCTS = "products";
        public static final String CREATE_PRODUCT = "createproduct";
    }

    public static class Template {
    	public static final String INDEX = "public/index.html";
        public static final String NOT_FOUND = "public/notFound.html";
        
        public static final String CUSTOMER = "public/customer.html";
        public static final String CUSTOMERS = "public/customers.html";
        
        public static final String PRODUCT = "public/product.html";
        public static final String PRODUCTS = "public/products.html";
    }

}
