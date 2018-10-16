package nc.bs.pub.action;

import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.so.shipmentsinfo.ace.bp.AceShipmentsInfoUnApproveBP;
import nc.bs.so.shipmentsinfo.plugin.bpplugin.ShipmentsInfoPluginPoint;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.so.qs.sc.AggShipmentsVO;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.pub.VOStatus;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.bs.framework.common.NCLocator;

public class N_FQ01_UNAPPROVE extends AbstractPfAction<AggShipmentsVO> {

  public N_FQ01_UNAPPROVE() {
    super();
  }

  @Override
  protected CompareAroundProcesser<AggShipmentsVO> getCompareAroundProcesserWithRules(Object userObj) {
	  CompareAroundProcesser<AggShipmentsVO> processor =new CompareAroundProcesser<AggShipmentsVO>(ShipmentsInfoPluginPoint.UNAPPROVE);
	  // TODO �ڴ˴����ǰ�����
	  IRule<AggShipmentsVO> rule=null;
	  rule = new nc.bs.pubapp.pub.rule.UnapproveStatusCheckRule();
				   				   				    				   				   
	  processor.addBeforeRule(rule);
	  
	  return processor;
  }

  @Override
  protected AggShipmentsVO[] processBP(Object userObj,AggShipmentsVO[] clientFullVOs, AggShipmentsVO[] originBills) {
	  for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
		  clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		  }
	  AggShipmentsVO[] bills = null;
      try {
          nc.itf.so.IShipmentsInfoMaintain operator = NCLocator.getInstance().lookup(nc.itf.so.IShipmentsInfoMaintain.class);
          bills=operator.unapprove(clientFullVOs,originBills);
      } catch (BusinessException e) {
    	  ExceptionUtils.wrappBusinessException(e.getMessage());
    	  }
    return bills;
  }

}
