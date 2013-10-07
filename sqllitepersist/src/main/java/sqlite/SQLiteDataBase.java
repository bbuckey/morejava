package sqlite;

import java.io.File;

import isqlite.ISQLite;

import com.almworks.sqlite4java.SQLiteConnection;

abstract class SQLiteDataBase implements ISQLite<SQLiteDataBase> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SQLiteConnection sqlConn;
	private File sqlDB;
	
	protected SQLiteDataBase() throws Exception{
		sqlDB = File.createTempFile("sqltemp", "db");
		sqlConn = new SQLiteConnection(sqlDB);
	}
	
	
	protected SQLiteDataBase(String path) throws Exception{
		sqlDB = new File(path);
		sqlConn = new SQLiteConnection(sqlDB);
	}
	
	public SQLiteConnection getSqlConn(){
		return sqlConn;
	}
	
	public File getSqlDB(){
		return sqlDB;
	}

}
