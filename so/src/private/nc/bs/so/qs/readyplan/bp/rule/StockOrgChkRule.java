package nc.bs.so.qs.readyplan.bp.rule;

import java.util.ArrayList;
import java.util.List;

import nc.bs.uif2.validation.ValidationException;
import nc.bs.uif2.validation.ValidationFailure;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.itf.scmpub.reference.uap.org.OrgUnitPubService;
import nc.vo.org.OrgVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.so.qs.sc.RdPorductDetailVO;

public class StockOrgChkRule implements IRule<RdPorductDetailVO>{

	@Override
	public void process(RdPorductDetailVO[] vos) {
		// TODO �Զ����ɵķ������
		
		List<ValidationFailure> failures = new ArrayList();
		
		for (int i = 0; i < vos.length; i++) {
			
			String pk_org=vos[i].getPk_org();
			
			OrgVO org=OrgUnitPubService.getOrg(pk_org);

			Boolean isstock=this.getOrgType(pk_org, "STOCKORGTYPE00000000");

			
			if(!isstock){
				failures.add(new ValidationFailure("��֯��"+org.getCode()+"���ǿ����֯������ʧ�ܣ�"));
			}
			
			
		}
		
		if (failures.size() > 0) {
			ExceptionUtils.wrappException(new ValidationException(failures));
		}
		
		
	}
	
	
	private boolean getOrgType(String pk_org, String type) {
		if (pk_org == null) {
			return false;
		}
  
		String key = pk_org + type;
		
		boolean istype = OrgUnitPubService.isTypeOf(pk_org, type);
		
		return istype;
	}

}
