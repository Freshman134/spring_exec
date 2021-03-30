package com.howieLuk.spring_exec.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.howieLuk.spring_exec.exec.controller.CarController;
import com.howieLuk.spring_exec.exec.controller.UserController;
import com.howieLuk.spring_exec.exec.dao.CarDao;
import com.howieLuk.spring_exec.exec.dao.UserDao;
import com.howieLuk.spring_exec.exec.dao.mappers.StudentDao;
import com.howieLuk.spring_exec.exec.dao.mappers.UserMapper;
import com.howieLuk.spring_exec.exec.pojo.Car;
import com.howieLuk.spring_exec.exec.pojo.Student;
import com.howieLuk.spring_exec.exec.pojo.User;


//@ContextConfiguration(locations = "classpath:exec_spring2.xml")  //使用指定配置文件创建容器
//@RunWith(SpringJUnit4ClassRunner.class)  //使用Spring测试模块执行@Test测试方法
public class HelloWorld {
	
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("exec_spring_mybatis.xml", "exec_spring2.xml");
		test_exec_spring_2(app);
	}
	
	public static void test_mybatis_save_get(ApplicationContext app) {
		StudentDao dao = app.getBean("studentDao", StudentDao.class);
		System.out.println(dao);
		Student stu = new Student();
		stu.setName("howie");
		stu.setNo("130");
		stu.setGrade(17);
		stu.setSex(true);
		stu.setClassName("网络17-1");
		dao.save(stu);
		System.out.println(dao.get(1));
	}
	
	public static void test_aop(ApplicationContext app) {
		UserDao userDao = (UserDao) app.getBean("userDao");
		//aop测试
		userDao.methodStart();
		System.out.println("===================");
		try {
			userDao.throwError();
		} catch (Exception e) {}
	}
	
	//暂时不能用，但是笔记是正确的
	public static void test_exec_spring_2(ApplicationContext app) {
		//注解注册、装配测试
		UserController userController = app.getBean("userController", UserController.class);
		userController.run();
		userController.save("root", "root@123.com");
		CarController carController = app.getBean("carController", CarController.class);
		carController.run();
		carController.save();
		//泛型依赖注入
		//当一个对象有泛型时，spring是可以根据运行时的具体类型进行注入对应的类（属于该泛型对象的具体子类）
		//如果找到两个以上对应的类会报错
		userController.b_run();
		userController.b_save("root", "root@123.com");
		carController.b_run();
		carController.b_save();
		//泛型的完整父类
		System.out.println("泛型的完整父类 " + userController.getUserBaseService().getClass().getGenericSuperclass());
		
	}
	
	public static void test_exec_spring(ApplicationContext app) {
		User user = (User)app.getBean("root");
		//通过id寻找bean
		System.out.println(user);
		//通过bean类型获取bean，有可能抛出bean重复异常
//		user = app.getBean(User.class);
//		System.out.println(user);
		//通过id与类型
		user = app.getBean("user1", User.class);
		System.out.println(user);
		//内部类调用测试
		Car car1 = app.getBean("car1", Car.class);
		System.out.println(car1);
		Car car2 = app.getBean("car2", Car.class);
		System.out.println(car2);
		//bean模板测试
		user = app.getBean("user4", User.class);
		System.out.println(user);
		//工厂测试
		user = app.getBean("user5", User.class);
		System.out.println(user);
		user = app.getBean("user6", User.class);
		System.out.println(user);
		Car car5 = app.getBean("car5", Car.class);
		System.out.println(car5);
	}
	
	
	
}
