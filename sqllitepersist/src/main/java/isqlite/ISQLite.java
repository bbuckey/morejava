package isqlite;

import java.io.Serializable;
import com.almworks.sqlite4java.SQLiteConnection;
import java.io.File;

public interface ISQLite<T> extends Serializable{

	
	public SQLiteConnection getSqlConn();
	
	public File getSqlDB();
	
	public T getInstance();
}