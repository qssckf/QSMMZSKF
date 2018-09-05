package nc.ui.so.qs.mmplanbill.service;

import nc.bs.framework.common.NCLocator;
import nc.itf.so.qs.bill.service.IAppModelServiceEx;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.vo.bd.pub.sqlutil.BDSqlInUtil;
import nc.vo.pub.BusinessException;
import nc.vo.uif2.LoginContext;

public class PlanBillAppModelService implements IAppModelServiceEx {

	private IPlanBillSerive planbillservice;
	
	public IPlanBillSerive getPlanbillservice() {
		
		if(this.planbillservice==null){
			this.planbillservice=NCLocator.getInstance().lookup(IPlanBillSerive.class);
		}
		
		return planbillservice;
	}

	@Override
	public Object insert(Object paramObject) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Object update(Object paramObject) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void delete(Object paramObject) throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Object[] queryVOsByPks(String[] pks) throws BusinessException {
		// TODO 自动生成的方法存根
		return null;
	}
	
	public String[] queryVosPksBySqlWhere(String[] orgIDs, String condition) throws BusinessException{
		
		
		StringBuilder builder = new StringBuilder();
		 
		builder.append("(" + condition + ")");
		
		String inSql = BDSqlInUtil.getInSql(orgIDs, false);
		 
		builder.append(" and (pk_org in ").append(inSql + ")");
		 
		return this.getPlanbillservice().queryVOPks(builder.toString());
		

		
	}

	

}
