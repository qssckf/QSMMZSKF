package nc.bs.so.qs.sc.maschine.rule;

import nc.bs.bd.service.ValueObjWithErrLog;
import nc.impl.pubapp.pattern.rule.IFilterRule;
//import nc.vo.so.xlx.tran.DriverVO;
import nc.vo.so.qs.sc.MaschineVO;

public class MaschineUnEnableDataCheckFilterRule implements IFilterRule<MaschineVO> {
	
	private ValueObjWithErrLog valueObjWithErrLog;
	
	public MaschineUnEnableDataCheckFilterRule(ValueObjWithErrLog valueObjWithErrLog){
		this.valueObjWithErrLog=valueObjWithErrLog;
	}

	@Override
	public MaschineVO[] process(MaschineVO[] vos) {
		// TODO �Զ����ɵķ������
		return vos;
	}

}
