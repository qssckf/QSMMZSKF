package nc.ui.so.qs.mmplanbill.process.actions.validation;

import java.util.Collection;
import java.util.List;

import nc.bs.uif2.validation.ValidationException;
import nc.bs.uif2.validation.ValidationFailure;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.so.qs.sc.MmPlanBillVO;
import nc.vo.so.qs.sc.PlanProduceDetailVO;

public class ExtendChdChkValidation implements nc.bs.uif2.validation.IValidationService{

	public static IMDPersistenceQueryService getMDQueryService(){
		
		return MDPersistenceService.lookupPersistenceQueryService();
		
	}
	
	
	@Override
	public void validate(Object obj) throws ValidationException {
		// TODO �Զ����ɵķ������
		
		
		if(obj instanceof MmPlanBillVO){
			
			MmPlanBillVO vo=(MmPlanBillVO) obj;
			
			Collection<PlanProduceDetailVO> col=null;
			
			try {
				
				col=this.getMDQueryService().queryBillOfVOByCond(PlanProduceDetailVO.class, "pk_planbill='"+vo.getPk_planbill()+"' and dr=0 and totalnum>0", false);
			
			
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				ExceptionUtils.wrappException(e);
			}
			
			if(col!=null && col.size()>0){
				
				List<ValidationFailure> fs = new java.util.ArrayList();
				
				fs.add(new ValidationFailure("�������ȵ���["+vo.getVbillcode()+"]����չ�������Ѿ��Ų������ܽ���ȡ��չ��������"));
				
				throw new ValidationException(fs);
				
				
			}
			
			
			
		}
		
		
		
	}
	
	
	

}
