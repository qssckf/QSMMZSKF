package nc.bs.so.qs.readyplan.bp.rule;

import nc.impl.pubapp.pattern.rule.IRule;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.so.qs.sc.PlanProduceDetailVO;
import nc.vo.so.qs.util.IQLock;

public class MmPlanNumChkRule<E extends SuperVO> implements IRule<E> {
	
	public static IMDPersistenceQueryService getMDQueryService()
	{
		return MDPersistenceService.lookupPersistenceQueryService();
	}

	@Override
	public void process(E[] objs) {
		// TODO �Զ����ɵķ������
		
		try{
			
			for(SuperVO obj:objs){
				
				String srcbid=(String) obj.getAttributeValue("vsrcplanbid");
				
				PlanProduceDetailVO detailvo=this.getMDQueryService().queryBillOfVOByPK(PlanProduceDetailVO.class, srcbid, false);
				
				if(detailvo!=null){
					
					if(detailvo.getTotalnum().toDouble()>=detailvo.getPlannum().toDouble()){
						throw new BusinessException("�Ų������Ѿ������ƻ����������ܱ��棡");
					}
					
				}else{
					throw new BusinessException("û���ҵ���Դ���ݣ��Ų������쳣�������ԣ�");
				}
				
				
			}
			
			
			
		}catch(Exception e){
			ExceptionUtils.wrappException(e);
		}
		
		
		
	}

}
