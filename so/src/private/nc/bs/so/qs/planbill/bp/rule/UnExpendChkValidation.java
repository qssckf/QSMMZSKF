package nc.bs.so.qs.planbill.bp.rule;

import java.util.Collection;

import nc.bs.uif2.validation.ValidationFailure;
import nc.bs.uif2.validation.Validator;
import nc.md.model.IBean;
import nc.vo.bd.config.BDUniqueruleVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDouble;
import nc.vo.util.AbstractUniqueRuleValidate;

public class UnExpendChkValidation implements Validator{

	@Override
	public ValidationFailure validate(Object obj) {
		// TODO �Զ����ɵķ������
		
		if(obj instanceof SuperVO[]){
			
			SuperVO[] vos = (SuperVO[])obj;
			
			for(SuperVO vo:vos){
				
				UFDouble totalnum=(UFDouble) vo.getAttributeValue("totalnum");
				
				if(totalnum.toDouble()>0){
					return new ValidationFailure("BOMչ����Ϣ�Ѿ��Ų�������ȡ����");
				}
			}
			
		}
		
		
		return null;
		
	}



}
