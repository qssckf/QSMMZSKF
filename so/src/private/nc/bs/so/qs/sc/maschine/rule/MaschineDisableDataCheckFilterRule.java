package nc.bs.so.qs.sc.maschine.rule;


import nc.bs.bd.service.ValueObjWithErrLog;
import nc.impl.pubapp.pattern.rule.IFilterRule;
//import nc.vo.so.xlx.tran.DriverVO;
import nc.vo.so.qs.sc.MaschineVO;

public class MaschineDisableDataCheckFilterRule implements IFilterRule<MaschineVO> {
	
	private ValueObjWithErrLog valueObjWithErrLog;
	
	public MaschineDisableDataCheckFilterRule(ValueObjWithErrLog valueObjWithErrLog){
		this.valueObjWithErrLog=valueObjWithErrLog;
	}

	@Override
	public MaschineVO[] process(MaschineVO[] vos) {
		// TODO 自动生成的方法存根
		return vos;
	}
	
	

}
