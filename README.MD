# production-propratice
基于spring boot的电商项目生产实习报告
1.	设计任务及要求
1、了解企业实际工作过程中的制度和要求、熟悉企业的工作流程和工作方式； 
2、熟悉实际项目分析、设计、开发、测试、提交等完整流程，熟悉企业各类文档模板，并按 照这些模板撰写项目文档； 
3、熟练使用各种开发工具、数据库设计工具、系统设计工具、项目管理工具；
4、熟练掌握 Java 语言引用及其相关的开发技术，并将这些技术灵活的运用到项目中； 
5、掌握企业开发常用的建模工具和设计模式；
6、养成良好的表达、沟通和团队协作能力，掌握快速学习方法，培养良好的分析问题和解决 问题的能力； 
7、了解数据库设计流程，了解电商项目的组成部分，熟悉和掌握基于 springboot 的微服务 架构开发方式和 rest 架构风格
1.1	背景
随着互联网技术的不断进取，一个一个的电商平台如雨后春笋版涌现出来，我们比较熟 悉的淘宝，天猫，京东都是这个时代背景下知名电商平台。
互联网+电商正在带着一大批从 业者迈向成功的道路。那么如何让我们的学生在这个大时代背景下快速融入到这个互联网电 商平台中来，这是我们这次实训要解决的一个重要问题。 结合学院的教学计划，与行业前景分析。 
本次计划采用目前最流行的 Java 技术- 基于 springboot 的电商项目来提升学生的实践能力。
Web模块：提供了基础的面向Web的集成特性，例如，多文件上传、使用Servlet listeners初始化IoC容器以及一个面向Web的应用上下文，它还包含了Spring远程支持中Web的相关部分
Web-Servlet模块web.servlet.jar：该模块包含Spring的model-view-controller(MVC)实现，Spring的MVC框架使得模型范围内的代码和web forms之间能够清楚地分离开来，并与Spring框架的其他特性基础在一起
Web-Struts模块：该模块提供了对Struts的支持，使得类在Spring应用中能够与一个典型的Struts Web层集成在一起
Web-Porlet模块：提供了用于Portlet环境和Web-Servlet模块的MVC的实现

 
1、前端控制器（不需要开发，只需配置）
作用：接收前台页面的请求，并响应结果到前台页面。中间做请求转发，相当于中央处理器。
2、处理器映射器（不需要开发，只需配置）
作用：根据请求的URL查找处理器
3、处理器适配器（不需要开发，只需配置）
作用：执行符合特定规则（HandlerAdapter要求的规则）的处理器
4、处理器（后端控制器：程序员开发）
注意：编写Handler时要符合HandlerAdapter的规则，否则处理器适配器无法正确执行。
5、视图解析器（不需要开发，只需配置）
作用：进行视图解析，根据逻辑视图名解析成真正的视图。
6、视图（程序员开发）
View是一个接口，实现类支持不同的view类型（jsp、freemarker、pdf等）
1.2正文
项目名称：基于 javaEE 最新技术-springboot 电商平台。 技术点：Java 基础，Java 高级，springboot，数据库技术，SQL 语句，web 前端。 实现功能： 
1、能够通过 springboot 快速搭建微服务架构开发平台。
2、能够设计出一套基础的电商平台的数据库。 
3、能够让外部客户方便的登录和注册用户。 
4、能够提供商品列表，分类展示商品，商品搜索等功能。 
5、能够实现购物车的功能 
6、能够实现直接购买和购物车结算的功能 
7、能够实现订单整合与历史订单查询的功能

2.	总体设计
整个电商网站主要包括四个子模块，分别为用户模块、商品模块、购物模块、订单模块
这些模块可继续细分用户模块包括用户登录和用户注册；商品模块包括商品分页、商品分类、商品详情页；购物车模块包括查看购物车、添加购物车、修改购物车；订单模块包括单商品订单、多商品订单、订单查询、订单详情（目前只实现了多商品订单）；
 
3.	详细设计
3.1 数据库设计
在任何有关于电子商务的系统开发中，数据库设计是整个开发过程中必不可少的过程也是技术的核心。良好的数据库设计模式，可以为系统开发者提供友好的开发环境，用以开发满足用户需求的系统。只有合理的设计后台数据库，才能够提供数据的存储和操作效率，简单快捷的开发过程，可以提高系统的安全性和性能。一个好的数据库结构可以提高服务器处理速度，减小系统占用资源的空间，使得操作更简洁。用统一的一个数据库代替人工来管理大量的数据已经成为大型系统开发的主要趋势，并且已经开发出许多数据库，如MySQL、Oracle、Nosql等，由于Mysql数据库具有处理数据快、并发访问，占用资源较小，所以本系统开发使用的数据库是Mysql。
数据库的概念设计的主要数据名称如表4.1所示。 
表3.1 主要的数据名称表
表名	说明
member
category	用户表
商品分类表
brand
product	品牌分类表
商品表
cart
orders
order_detail
address	购物车表
订单表
订单详情表
用户地址表

数据库建表语句：
-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `aid` int(6) NOT NULL AUTO_INCREMENT,
  `addr` varchar(200) NOT NULL,
  `name` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `mid` int(6) NOT NULL,
  `is_default` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`aid`),
  KEY `fk_address_mid` (`mid`),
  CONSTRAINT `fk_address_mid` FOREIGN KEY (`mid`) REFERENCES `member` (`mid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `bid` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `status` int(11) DEFAULT '1',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `mid` int(6) NOT NULL,
  `pid` int(6) NOT NULL,
  `quantity` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cart_mid` (`mid`),
  KEY `fk_cart_pid` (`pid`),
  CONSTRAINT `fk_cart_mid` FOREIGN KEY (`mid`) REFERENCES `member` (`mid`) ON DELETE CASCADE,
  CONSTRAINT `fk_cart_pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `status` int(11) DEFAULT '1',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `mid` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `gender` int(1) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `member_id` int(6) DEFAULT NULL,
  `address_id` int(6) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_orders_member_id` (`member_id`),
  KEY `fk_orders_address_id` (`address_id`),
  CONSTRAINT `fk_orders_member_id` FOREIGN KEY (`member_id`) REFERENCES `member` (`mid`),
  CONSTRAINT `fk_orders_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `order_id` int(6) DEFAULT NULL,
  `product_id` int(6) DEFAULT NULL,
  `quantity` int(3) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_detail_order_id` (`order_id`),
  KEY `fk_order_detail_product_id` (`product_id`),
  CONSTRAINT `fk_order_detail_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `fk_order_detail_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(6) NOT NULL AUTO_INCREMENT,
  `cid` int(6) DEFAULT NULL,
  `bid` int(6) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `original_price` double(10,2) DEFAULT NULL,
  `price` double(10,2) NOT NULL,
  `img_url` varchar(200) DEFAULT NULL,
  `inventory` int(5) DEFAULT NULL,
  `sales_volume` int(5) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`),
  KEY `fk_product_cid` (`cid`),
  KEY `fk_product_bid` (`bid`),
  CONSTRAINT `fk_product_bid` FOREIGN KEY (`bid`) REFERENCES `brand` (`bid`) ON DELETE CASCADE,
  CONSTRAINT `fk_product_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

项目目录结构：
 

通过controller层 对请求进行处理，具体的业务逻辑在service 层定义接口提供业务操作，在 impl提供具体业务层方法的实现，由po 层提供实体类，数据库中每一张表对应一个实体，获取数据库中数据进行存储到对应的实体类，在 dao 层创建接口提供业务操作需要的方法，在mapper 文件中实现dao 层接口提供的接口，使用Mybatis 框架实现对数据库的连接以及具体的数据库操作（数据库的增删改查）
在.properties 文件配置数据库连接需要用到的信息（各个字段）如下：
 
在webapp 中配置需要用的的静态页面，static文件中包含前端页面需要的静态文件
 
3.2具体实现的功能：
1、用户登录与注销；
2、全部商品展示
3、商品分类；
4、根据商品分类进行查询；
5、模糊查询；
6、单个商品信息详情
7、购物车模块（购物车详情、添加到购物车、删除购物车中商品）
8、订单模块（订单详情、通过购物车下订单、）
	3.3具体实现
3.3.1.登录模块：
@RequestMapping("/login")
public String login(String name, String pass, HttpSession session){
    Member member = accountService.login(name,pass);
    if(member != null){
        System.out.println("登录成功");
        session.setAttribute("member",member);
    }else {
        System.out.println("登录失败");
    }
    return "redirect:/index";
}
在controller 层，接收前端页面的请求，在 accountService 中进行处理，提供一个login方法
@Override
public Member login(String name, String pass) {
    Map<String,Object> param = new HashMap<>();
    param.put("name",name);
    param.put("pass",pass);
    return memberMapper.query(param);
}
将用户提交的数据保存到 HashMap 中，返回一个 Member 对象，通过将用户的数据保存到session 中，在浏览器中从session中取出用户信息，同时可以通过判断session 中是否存在用户信息，进行一些简单的权限管理操作
注销用户比较简单代码如下：
@RequestMapping("/logout")
public String logout(HttpSession session){
    session.invalidate();
    return "redirect:/index";
}
当用户前台发起“/logout”的url请求时，清除session 中的数据，重定向到index 页面
3.3.2.商品模块
商品模块包括全部商品，商品分类，商品查询，商品详情
用户对list 页面发起请求由ListController 进行响应，对用户数据进行处理，通过从前台获取商品的cid,bid,keyword,进行简单的逻辑判断，可以实现商品分类查询以及模糊查询；
在ProductController实现响应用户对商品详情页的请求，接收到前台传过来的 pid，业务层提供商品查询的方法，在mapper 层执行具体的数据库操作。
具体的业务逻辑由service 层完成，ProductService提供商品查询的方法，ProductServiceImpl实现这个接口
ProductPage query(Integer cid, Integer bid, String keyWord, Integer page);
Product queryByPid(Integer pid);
具体实现：
public ProductPage query(Integer cid, Integer bid, String keyWord, Integer page) {
        Map<String,Object> param = new HashMap<>();
        ProductPage productPage = new ProductPage();

        if(cid != null){
            param.put("cid",cid);
            productPage.setCid(cid);
        }
        if(bid != null){
            param.put("bid",bid);
            productPage.setBid(bid);
        }
        if(keyWord != null){
            param.put("keyWord",keyWord);
            productPage.setKeyWord(keyWord);
        }

        //开始分页查询
        PageHelper.startPage(page,3);
        List<Product> products = productMapper.query(param);
        productPage.setProducts(products);
        //获取查询结果总条数
        long count = PageHelper.count(new ISelect(){
            @Override
            public void doSelect() {
                productMapper.query(param);
            }
        });
        productPage.setTotalCount(count);
//      System.out.println("count = " + count);
//      总页数 = 向上取整(总条数 / 每页条数)
        double pageCount = Math.ceil(((double) count) / 3);
//      System.out.println("pageCount = " + pageCount);
        productPage.setPageCount((int) pageCount);
        productPage.setCurrentPage(page);
        return productPage;
    }
对数据库的操作在Mapper 层进行处理，在.xml 文件中编写sql 语句，执行对数据库的增删改查
3.3.3.购物车模块
当用户发起请求访问购物车页面，对session中数据进行判断，若session 中用户信息为空，通过拦截器进行拦截，若用户已登录，则查询该用户对应的购物车信息将用户对应购物车中的商品查询出来保存到cartDetail 对象中，提供一个List 集合保存用户的地址信息，通过queryAddressByMid 方法实现
还有添加到购物车，删除购物车中商品，更改需要添加到购物车的商品数量
控制层代码如下：
@RequestMapping("/cart")
public String cart(HttpSession session, Model model){
    Member member = (Member) session.getAttribute("member");
    Integer mid = member.getMid();
    List<ProductInCart> productInCarts = cartService.queryByMid(mid);
    List<Nav> nav = navService.getNav();
    CartDetail cartDetail = cartService.queryTotal(mid);
    List<Address> addresses = cartService.queryAddressByMid(mid);
    model.addAttribute("addresses",addresses);
    model.addAttribute("productInCarts",productInCarts);
    model.addAttribute("nav",nav);
    model.addAttribute("cartDetail",cartDetail);
    return "cart";
 }
@RequestMapping("/add2Cart")
public String add2Cart(HttpSession session,Integer pid,Integer quantity){
    System.out.println("pid = [" + pid + "], quantity = [" + quantity + "]");
    Member member = (Member) session.getAttribute("member");
    Integer mid = Math.toIntExact(member.getMid());
    cartService.add2Cart(mid,pid,quantity);
    return "redirect:/cart";
}

@RequestMapping("/delete")
public String delete(HttpSession session,Integer pid){
    Member member = (Member) session.getAttribute("member");
    Integer mid = Math.toIntExact(member.getMid());
    cartService.delete(mid,pid);
    return "redirect:/cart";
}

@RequestMapping("/updateQuantity")
public String updateQuantity(HttpSession session, Integer pid,Integer quantity){
    Member member = (Member) session.getAttribute("member");
    Integer mid = member.getMid();
    if (quantity > 0){
        cartService.updateQuantity(mid,pid,quantity);
    }
    return "redirect:/cart";
}

3.3.4.订单模块
@RequestMapping("/order")
public String order(Model model, HttpSession session){
    Member member = (Member) session.getAttribute("member");
    Integer mid = member.getMid();
    List<Nav> nav = navService.getNav();
    List<OrderItem> orderItems = orderService.queryByMid(mid);
    System.out.println(JSON.toJSONString(orderItems));
    model.addAttribute("nav",nav);
    model.addAttribute("orderItems",orderItems);
    return "order";
}
@RequestMapping("/checkout")
public String checkout(HttpSession session, Integer aid){
    Member member = (Member) session.getAttribute("member");
    Integer mid = member.getMid();
    int checkout = orderService.checkout(mid, aid);
    System.out.println(checkout);
    return "redirect:/order";
}

3.4设计结果
效果展示
3.4.1.首页以及商品列表
 
图1
3.4.2.商品分类查询
 
图二
3.4.3.通过关键字查询
 
图三
3.4.4.购物车详情
 
图四
3.4.5订单详情

 
图五
4.心得体会
	通过这次生产实习我了解了 java 语言，了解基于 springboot 的微服务架构风格，了解电商平台研发过程。 对互联网高新技术有基本了解和掌握，对 restful 风格有一定的掌握，熟练掌握软件开发 流程； 对团队开发流程有一定了解，熟悉掌握常用团队项目管理技能； 学员在软件开发领域方面发现问题、分析问题、解决问题的能力得到迅速的提升。
了解了 springboot框架的使用，认识到使用框架开发可以大大提升开发效率，通过使用mybatis 框架提供映射标签，支持对象与数据库的orm字段关系映射提供对象关系映射标签，支持对象关系组建维护提供xml标签，支持编写动态sql。
在此次开发过程中，起步的时候进行环境配置也遇到了较多的问题，通过百度一步一步的解决。在servlet 层对数据库的操作不太熟悉导致花了不少的时间进行调试以及改 BUG；最终出来一个可以使用的网站，通过这次实习加深了我对知识的了解，极大的提高了自我动手能力。


 
基于JavaEE电商项目生产实习报告
1.	设计任务及要求
1.1实训目标
1)	了解企业实际工作过程中的制度和要求、熟悉企业的工作流程和工作方式。
2)	熟悉实际项目分析、设计、开发、测试、提交等完整流程，熟悉企业各类文档模板，并按 照这些模板撰写项目文档。
3)	熟练使用各种开发工具、数据库设计工具、系统设计工具、项目管理工具；
4)	熟练掌握 Java 语言引用及其相关的开发技术，并将这些技术灵活的运用到项目中。
5)	掌握企业开发常用的建模工具和设计模式。
6)	养成良好的表达、沟通和团队协作能力，掌握快速学习方法，培养良好的分析问题和解决 问题的能力。
7)	了解数据库设计流程，了解电商项目的组成部分。
1.2实现功能
1)	设计出一套基础的电商平台的数据库。
2)	能够让外部客户方便的登录和注册用户。
3)	能够提供商品列表，分类展示商品功能。
1.3实训流程
1)	基础知识：数据库应用与开发（学习Mysql数据库的基础知识以及数据库的建立）、Java高级应用框架（学习JavaEE规范，MVC设计模式，servlet3.0重要组件）、WEB前端（JQuery核心语法，第二代Ajax技术。
2)	运行环境安装和配置：学习Java开发环境，电商平台开发环境的搭配与配置。
3)	项目讲解：学习概要设计，明确模块层次结构以及调用关系，模块功能等。
4)	项目实训：跟着老师进行具体项目的代码的编写，完成简单功能。
5)	产品及测试：调试代码，完善商城功能。

2.	总体设计
Servlet ：控制层
service : 业务逻辑层，用来做逻辑判断
Dao:持久层，专门用来做数据库的增删改查
utils : 工具类
model: 实体类层
项目目录结构：
 
3.	详细设计
数据库表结构设计
 
表3.1 主要的数据名称表
表名	说明
admin
category
orderitem
orders
products
shoppingcart
user	管理员表
商品分类表
订单详情表
订单表
商品表
购物车
用户表

对首页请求的处理
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//调用业务层，查询所有商品类型
			CategoryService cs = new CategoryService();
			//查询所有商品类型
			List<Category> categorys = cs.getAllList();
			req.setAttribute("categorys", categorys);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
对注册请求的处理
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//请求的乱码问题解决
		req.setCharacterEncoding("utf-8");
		//响应的乱码问题解决
		resp.setContentType("text/html;charset=utf-8");
		//PrintWriter writer = resp.getWriter();
		try {
			String username = req.getParameter("username");
			String realname = req.getParameter("realname");
			String password = req.getParameter("password");
			String gender = req.getParameter("gender");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			User user = new User(username,realname,password,gender,phone,email);
			UserService userService = new UserService();
			
			boolean flag = userService.register(user);
			
			if(flag) {
					System.out.println("注册成功");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else {
				System.out.println("注册失败");
				req.setAttribute("msg", "注册失败，请重新注册");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
对登录请求的处理
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//请求的乱码问题解决
		req.setCharacterEncoding("utf-8");
		//响应的乱码问题解决
		resp.setContentType("text/html;charset=utf-8");
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			LoginService loginservice = new LoginService();
			HttpSession session = req.getSession();
			boolean flag = loginservice.login(username,password,session);
			if(flag) {
				//HttpSession session = req.getSession();
				/*session.setAttribute("user", user);*/
				resp.sendRedirect("index");
				System.out.println("登录成功");
				
				
			}else {
				req.setAttribute("username", username);
				req.setAttribute("password", password);
				req.setAttribute("msg", "用户名或密码错误");
				System.out.println("登陆失败");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
退出登录
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();  			//销毁用户的session对象
		resp.sendRedirect("index.jsp"); 	//返回主页
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
全部商品展示
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//调用业务层，查询所有商品类型
			CategoryService cs = new CategoryService();
			//查询所有商品类型
			List<Category> categorys = cs.getAllList();
			
			ProductService ps = new ProductService();
			List<Product> products = ps.getAllList();
			HttpSession session = req.getSession(true);
			System.out.println(products);
			req.setAttribute("categorys", categorys);
			req.setAttribute("products", products);
			req.getRequestDispatcher("products.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
查询商品详情
@WebServlet("/single")
public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前台数据
				String pid = req.getParameter("pid");
				try {
					//调用service根据商品id查询该商品信息
					ProductService ps = new ProductService();
					
					Product product = ps.getProductById(pid);
					HttpSession session = req.getSession(true);
					req.setAttribute("product", product);
					req.getRequestDispatcher("single.jsp").forward(req, resp);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
4.	设计结果
效果展示
4.1注册页
 
图一
4.2登录页
 
图二
4.3 全部商品展示
 
图三
4.4单个商品详情

 
图四

5.	心得体会
     做东西的时候思路很重要！当看不到路的时候不要急于往前走，不然会很耗时的。我一般先在纸上画画，尝试着勾勒出流程。这样在写的时候就变得很用目的了效率自然也会提高。
学习到建立一个网站的具体流程，包括需求分析，系统设计，数据库设计，前台和后台开发分层。通过借助 mvc 模式实现表现层、模型、控制器 三层互相分离使系统隔离开，方便实现和维护。
对 servlet 等技术有所生疏，导致开发系统时代码的可读性差，结构也不是太清晰，要对servlet 等一些其他的知识点进行巩固学习。
