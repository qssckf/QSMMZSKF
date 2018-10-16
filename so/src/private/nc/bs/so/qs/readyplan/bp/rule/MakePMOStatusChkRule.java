package nc.bs.so.qs.readyplan.bp.rule;

import java.util.ArrayList;
import java.util.List;

import nc.bs.uif2.validation.ValidationException;
import nc.bs.uif2.validation.ValidationFailure;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.mmpps.mpm.res.MpmRes;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.so.qs.sc.RdPorductDetailVO;

public class MakePMOStatusChkRule implements IRule<RdPorductDetailVO>{

	public MakePMOStatusChkRule(){
		
	}
	
	@Override
	public void process(RdPorductDetailVO[] vos) {
		// TODO �Զ����ɵķ������
		
		List<ValidationFailure> failures = new ArrayList();
		
		for (int i = 0; i < vos.length; i++) {
			
			if(vos[i].getBillstatus()==3 || "Y".equals(vos[i].getSfmakebill())){
				failures.add(new ValidationFailure("�������ڣ���"+vos[i].getProddate()+"��,������������"+vos[i].getProdnum()+"�����Ѿ������������������ܼ�����"));
			}
			
		}
		
		if (failures.size() > 0) {
			ExceptionUtils.wrappException(new ValidationException(failures));
		}
	}
	
	

}
