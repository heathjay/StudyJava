package com.jay.java.jdbc.JORM.core;

import java.util.List;

/**
 * Query接口，负责对外提供服务的核心类
 * @author jay
 *
 */
@SuppressWarnings(value = { "all" })
public interface Query {
	/**
	 * 直接执行一个dml语句
	 * @param sql	语句
	 * @param params	参数
	 * @return 执行sql语句后影响了几行语句
	 */
	public int executeDML(String sql,Object[] params);
	
	/**
	 * 将一个对象存储到数据库中,
	 * 把对象中不为null的属性往数据库中存储
	 * @param obj
	 */
	public void insert(Object obj);
	/**
	 * 删除clazz表示类对应的表中记录
	 * @param clazz	跟表对应的类的Class对象，
	 * @param id 主键值
	 */
	public void delete(Class clazz, Object id);//delete from User where id=2;
	/**
	 * 删除对象在数据库中对应的记录，对象所在的类对应到表，对象的主键的值对应到记录
	 * @param obj
	 */
	public void delete( Object obj);//delete from User where id=2;
	/**
	 * 跟新对象对应的记录，并且只更新指定的字段值
	 * @param obj	更新的对象
	 * @param fieldNames
	 * @return 影响了几行
	 */
	public int update(Object obj,String[] fieldNames);//update User set uname=?,pwd=?
	/**
	 * 查询返回多行记，并将没行记录封装到clazz指定的类对象中
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public List queryRows(String sql, Class clazz, Object[] params);
	/**
	 * 查询返回一行记录，并将没行记录封装到clazz指定的类对象中
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryUniqueRows(String sql, Class clazz, Object[] params);
	/**
	 * 查询返回一行一列，并将该值返回
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryValue(String sql, Object[] params);
	/**
	 * 查询返回一行一列的数字，并将该值返回
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql, Object[] params);
	
	
}
