package com.jay.java.jdbc.JORM.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jay.java.jdbc.JORM.bean.ColumnInfo;
import com.jay.java.jdbc.JORM.bean.JavaFieldGetSet;
import com.jay.java.jdbc.JORM.bean.TableBean;
import com.jay.java.jdbc.JORM.core.DBManager;
import com.jay.java.jdbc.JORM.core.MySqlTypeConvert;
import com.jay.java.jdbc.JORM.core.TableContext;
import com.jay.java.jdbc.JORM.core.TypeConvert;

/**
 * 封装了生成Java文件的常用操作
 * @author jay
 *
 */
public class JavaFileUtils {
	/**
	 * 根据字段信息生成java属性信息，如var username -> private String username,以及相应的set和get方法
	 * 
	 * @param column
	 * @param convertor
	 * @return java属性和set/get方法
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvert convertor) {
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("\tprivate " + javaFieldType  + " "+column.getName() + ";\n");
		//public String getUsername(){return username;}
		
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic " + javaFieldType +" get" +StringUtils.firstChar2UpperCase(column.getName()) + "(){\n");
		getSrc.append("\t\treturn " + column.getName() + ";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//public void setUsername(String username){this.username = username;}
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) + "(");
		setSrc.append(javaFieldType+" " + column.getName() + "){\n");
		setSrc.append("\t\tthis." + column.getName() + "=" + column.getName() + ";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		
		return jfgs;
	}
	
	/**
	 * 根据表信息生成java类的源代码
	 * @param tableInfo
	 * @param convertor
	 * @return
	 */
	public static String createJavaSrc(TableBean tableInfo,TypeConvert convertor) {

		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		for(ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c,convertor));
		}
		
		StringBuilder src = new StringBuilder();
		//生成package语句
		src.append("package " + DBManager.getConf().getPoPackage() + ";\n\n");
		//生成import语句
		src.append("import java.sql.*;\n" );
		src.append("import java.util.*;\n\n" );
		
		//生成类声明语句
		src.append("public class " + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + "{\n\n");
		//生成属性列表
		for(JavaFieldGetSet f: javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		//生成get方法
		for(JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo());
		}
		//生成set方法
		for(JavaFieldGetSet f : javaFields) {
			src.append(f.getSetInfo());
		}
		//生成类结束
		src.append("}\n");
//		System.out.println(src);
		return src.toString();
	}
	
	public static void createJavaPOFile(TableBean tableInfo, TypeConvert convertor) {
		String src = createJavaSrc( tableInfo, convertor);
		String srcPath = DBManager.getConf().getSrcPath();
		String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.", "/");
		
		File f = new File("src/" + packagePath + "/" + StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");
//		System.out.println(f.getAbsolutePath());
		
		  if(!f.exists()) {
			f.mkdirs();
		}
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(src);
			System.out.println("建立表" + tableInfo.getTname() +"对应的java类" +StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
	/*	ColumnInfo ci = new ColumnInfo("id","int",0);
		JavaFieldGetSet f = createFieldGetSetSRC(ci,new MySqlTypeConvert());
		System.out.println(f);*/
		
		
		
	}
}
