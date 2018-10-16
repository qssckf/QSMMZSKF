package nc.ui.so.qs.mmplanbill.process.actions.validation;

import java.util.List;

import nc.bs.uif2.validation.ValidationException;
import nc.bs.uif2.validation.ValidationFailure;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.so.qs.sc.MmPlanBillVO;

public class UnExpendStatusValidation implements nc.bs.uif2.validation.IValidationService{

	@Override
	public void validate(Object obj) throws ValidationException {
		// TODO �Զ����ɵķ������
		
		if(obj instanceof MmPlanBillVO){
			
			MmPlanBillVO vo=(MmPlanBillVO) obj;
			
			if(UFBoolean.FALSE.equals(vo.getSfexand())){
				
				List<ValidationFailure> fs = new java.util.ArrayList();
				
				fs.add(new ValidationFailure("�������ȵ���["+vo.getVbillcode()+"]����û��չ�������ܽ���ȡ��չ��������"));
				
				throw new ValidationException(fs);
				
			}
			
			
		}
		
		
		
	}

}
