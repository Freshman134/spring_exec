package com.howieLuk.spring_exec.exec.dao.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.howieLuk.spring_exec.exec.pojo.User;

@Repository
public interface UserMapper extends BaseDao<User> {
	/*通过@param注解为多参数注入提供方便
	 * 正常来说，当一个方法需要注入多个参数的时候，mybatis会将参数1注入到#{param1}，参数2注入到#{param2}
	 * 通过@param便可设置我们想要的参数注入的名称
	 * 多种参数传入方式：
	 * 		单参数：#{*}
	 * 		多参数：#{param1}, #{param2}或使用@Param
	 * 		pojo类：#{propertyName}
	 * 		map：#{key}
	 * */
	public void updatePasswordByUsername(@Param("username")String username, @Param("password")String password);
	
	/*
	 * #{}和${}的区别：
	 * #：采用预编译模式，更安全，不会有sql注入的问题
	 * $：不采用预编译，不安全，但采用非预编译的话，可以动态插入一些非参数的语句（允许sql注入）
	 * */
	
	/*
	 * 查询返回map
	 * 默认使用第一个作为key，使用@MapKey注解时会将注明的列名作为key
	 */
	@MapKey("id")
	public Map<Long, User> getUserMapById(long id);
	
	
	/*
	 * 查询返回map,有多个
	 */
	@MapKey("id")
	public Map<Long, User> getUserMap();
	
	/*
	 * 动态条件注入
	 */
	public List<User> getUser(User user);
	
	/*
	 * 当使用list做参数时，mybatis会将他标记为list如果要改成自己的id需要使用@param，map同理	
	 */
	public List<User> getUsersById(@Param("ids")List<Long> ids);
	
	/*
	 * 动态修改
	 */
	public void updateById(User user);
	
}
