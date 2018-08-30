package nc.itf.so.qs.bill.service;

public interface IAppModelServiceEx {
	
	public abstract Object insert(Object paramObject) throws Exception;
		  
	public abstract Object update(Object paramObject) throws Exception;
		  
	public abstract void delete(Object paramObject) throws Exception;
	
	public Object[] queryVOsByPks(String[] pks) throws Exception;
	

}
