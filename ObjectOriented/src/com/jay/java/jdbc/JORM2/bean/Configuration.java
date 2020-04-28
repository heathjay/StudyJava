package com.jay.java.jdbc.JORM2.bean;
/**
 * 从配置文件中读取信息
 * @author jay
 *
 */
public class Configuration {
	/**
	 * 驱动类
	 */
	private String driver;
	/**
	 * jdbc的url
	 */
	private String url;
	/**
	 * 用户名
	 */
	private String user;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 使用的数据库
	 */
	private String usingDB;
	/**
	 * 项目的源码路径
	 */
	private String srcPath;
	/**
	 * 扫描生成java类的包
	 * po ： persistence object
	 */
	private String queryClass;
	/**
	 * 告诉别人项目使用的查询类是哪一个
	 */
	private String poPackage;
	/**
	 * 连接池中最小的连接数
	 */
	private int poolMinSize;
	/**
	 * 连接池中最大的连接数
	 */
	private int poolMaxSize;
	
	public int getPoolMinSize() {
		return poolMinSize;
	}
	public void setPoolMinSize(int poolMinSize) {
		this.poolMinSize = poolMinSize;
	}
	public int getPoolMaxSize() {
		return poolMaxSize;
	}
	public void setPoolMaxSize(int poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}
	public String getQueryClass() {
		return queryClass;
	}
	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	public Configuration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String poPackage) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
		
	}
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String queryClass, String poPackage) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.queryClass = queryClass;
		this.poPackage = poPackage;
	}
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String queryClass, String poPackage, int poolMinSize, int poolMaxSize) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.queryClass = queryClass;
		this.poPackage = poPackage;
		this.poolMinSize = poolMinSize;
		this.poolMaxSize = poolMaxSize;
	}
	
}
