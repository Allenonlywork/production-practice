package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
//设置自动扫描的需要生产Mapper代理类的包
@MapperScan("com.example.demo.dao")

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	/*@RequestMapping("/checkout")
	public String checkout(){
		return "checkout";
	}*/



	/*@RequestMapping("/index")
	public String index(){
		return "index";
	}*/

/*	@RequestMapping("/login")*/
/*	public String login(){
		return "login";
	}*/

	@RequestMapping("/mail")
	public String mail(){
		return "mail";
	}

/*	@RequestMapping("/products")
	public String products(){
		return "products";
	}*/

    /*@RequestMapping("/cart")
    public String cart(){
        return "cart";
    }*/
	/*@RequestMapping("/order")
    public String order(){
        return "order";
    }*/


	/*@RequestMapping("/short-codes")
	public String short_codes(){
		return "short-codes";
	}*/

/*	@RequestMapping("/single")
	public String single(){
		return "single";
	}*/

}

