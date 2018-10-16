package nc.bs.so.qs.sc.maschine.bp.rule;

import java.util.ArrayList;
import java.util.List;

import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.so.qs.sc.AggMaschineVO;
import nc.vo.so.qs.sc.pub.pf.IMaschineBillLock;
import nc.vo.so.qs.sc.tools.MaschineBizlockDataUtil;
//import nc.vo.so.xlx.pub.pf.ITranBillLock;
//import nc.vo.so.xlx.tools.TranBizlockDataUtil;
//import nc.vo.so.xlx.tranflow.AggTranFlowVO;
import nc.vo.util.bizlock.BizlockDataUtil;

public class MaschineFlowBusLockRule implements IRule<AggMaschineVO>{

	@Override
	public void process(AggMaschineVO[] obj) {
		// TODO �Զ����ɵķ������
		
		if(obj instanceof IMaschineBillLock[]){
			
			try {
				MaschineBizlockDataUtil.lockDataByBizlock((IMaschineBillLock[]) obj);
			} catch (BusinessException e) {
				// TODO �Զ����ɵ� catch ��
				ExceptionUtils.wrappException(e);
			}
			
		}
	}


}
