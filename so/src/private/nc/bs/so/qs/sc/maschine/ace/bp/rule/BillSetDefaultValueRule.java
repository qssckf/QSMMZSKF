package nc.bs.so.qs.sc.maschine.ace.bp.rule;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.so.qs.sc.AggMaschineVO;
//import nc.vo.so.xlx.tranflow.AggTranFlowVO;;

public class BillSetDefaultValueRule implements IRule<AggMaschineVO>{

	private BaseDAO bao;
	
	public BaseDAO getBao() {
		
		if(bao==null){
			this.bao=new BaseDAO();
		}
		return bao;
	}

	
	@Override
	public void process(AggMaschineVO[] objs) {
		
		
		// TODO 自动生成的方法存根
		
		for(AggMaschineVO obj:objs){
			
			String sql=bulidSQL(obj.getParentVO().getTableName(),"mstatus","pk_org",obj.getParentVO().getPk_org(),"tranbillbustype",obj.getParentVO().getTranbillbustype());
			
			try {
				getBao().executeUpdate(sql);
			} catch (DAOException e) {
				// TODO 自动生成的 catch 块
				ExceptionUtils.wrappException(e);
			}
			
			
		}
		
		
	}
	
	
	public String bulidSQL(String table,String defaultfield,String pkorgfield,String pk_org,String tratypeid,String tratypevalue){
		
		String sql = "update %1$s set %2$s='1' where %3$s='%4$s' and %5$s='%6$s'  and dr=0 ";
		sql = String.format(sql, new Object[] { table,defaultfield,pkorgfield,pk_org,tratypeid,tratypevalue});
		
		return sql;
	}

}
