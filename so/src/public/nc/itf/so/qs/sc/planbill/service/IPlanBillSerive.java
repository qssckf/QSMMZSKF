package nc.itf.so.qs.sc.planbill.service;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

public abstract interface IPlanBillSerive {
	
	public abstract String[] queryVOPks(String sqlwhere) throws BusinessException;
	
	public abstract SuperVO[] queryVObyPks(String[] pks) throws BusinessException;
	
	public Boolean QueryPlanBillIsExists(String pk) throws BusinessException;
	
	public abstract SuperVO[] queryBomVersion(String pk_materail,String pk_org) throws BusinessException;
	
	public abstract SuperVO[] queryBomChildren(String bomid,String pk_org) throws BusinessException;

}
