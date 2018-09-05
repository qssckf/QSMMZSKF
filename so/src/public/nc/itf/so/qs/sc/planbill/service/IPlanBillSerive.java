package nc.itf.so.qs.sc.planbill.service;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

public abstract interface IPlanBillSerive {
	
	public abstract String[] queryVOPks(String sqlwhere) throws BusinessException;
	
	public abstract SuperVO[] queryVObyPks(String[] pks) throws BusinessException;

}
