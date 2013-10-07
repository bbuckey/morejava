package sqlite;

import sqlite.SQLiteDataBase;
import com.almworks.sqlite4java.SQLiteStatement;
import com.almworks.sqlite4java.SQLParts;

public class SQLRunner extends SQLiteDataBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798573671451876310L;

	public SQLRunner() throws Exception{
		super();
		if(!super.getSqlConn().isOpen()){
			super.getSqlConn().open();
		}
	}

	public SQLRunner(String file) throws Exception{
		super(file);
		if(!super.getSqlConn().isOpen()){
			super.getSqlConn().open();
		}
	}

	public SQLRunner(String file, String ... statements) throws Exception{
		super(file);
		if(statements != null){
			if(!super.getSqlConn().isOpen()){
				super.getSqlConn().open();
			}
			for(String s : statements){
				super.getSqlConn().exec(s);
			}
		}
	}

	public SQLiteStatement runSQLStatement(SQLParts sqlparts) throws Exception{
		SQLiteStatement sql = super.getSqlConn().prepare(sqlparts);
		return sql;
	}

	public SQLiteStatement runSQLStatement(String sqlparts) throws Exception{
		SQLiteStatement sql = super.getSqlConn().prepare(sqlparts);
		return sql;
	}

	public SQLiteStatement runSQLStatement(SQLParts sqlparts, Object ... obj ) throws Exception{
		SQLiteStatement sql = super.getSqlConn().prepare(sqlparts);
		for(int i = 0; i < obj.length; i++){
			sql = bindElement(sql,obj[i],i);
		}
		return sql;
	}

	public SQLiteStatement runSQLStatement(String sqlparts, Object ... obj) throws Exception{
		SQLiteStatement sql = super.getSqlConn().prepare(sqlparts);
		for(int i = 0; i < obj.length; i++){
			sql = bindElement(sql,obj[i],i);
		}
		return sql;
	}

	private SQLiteStatement bindElement(SQLiteStatement statement, Object  obj, int i)throws Exception{
		if( obj == null){
			statement.bindNull(i);
		} else if(obj instanceof String){
			statement.bind(i, (String)obj);
		} else if(obj instanceof Double) {
			statement.bind(i, (Double)obj);
		} else if(obj instanceof Integer) {
			statement.bind(i, (Integer)obj);
		} else if(obj instanceof Long) {
			statement.bind(i, (Long)obj);
		} else if(obj instanceof Byte[]) {
			statement.bind(i, (Byte)obj);
		}
		return statement;
	}

	public SQLRunner getInstance(){
		return this;
	}

}
