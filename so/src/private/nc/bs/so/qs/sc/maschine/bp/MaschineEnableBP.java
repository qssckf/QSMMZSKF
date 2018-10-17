package nc.bs.so.qs.sc.maschine.bp;

//import nc.bs.so.xlx.tran.tranflow.ace.bp.rule.BillCheckVOConsistence;
//import nc.bs.so.xlx.tran.tranflow.ace.bp.rule.BillSetDefaultValueRule;
//import nc.bs.so.xlx.tran.tranflow.ace.bp.rule.BillVOSetValue;
//import nc.bs.so.xlx.tran.tranflow.ace.bp.rule.TranFlowBusLockRule;
//import nc.bs.so.xlx.tran.tranflow.plugin.bpplugin.TranFlowPluginPoint;
import nc.bs.so.qs.sc.maschine.ace.bp.rule.BillCheckVOConsistence;
import nc.bs.so.qs.sc.maschine.ace.bp.rule.BillSetDefaultValueRule;
import nc.bs.so.qs.sc.maschine.ace.bp.rule.BillVOSetValue;
import nc.bs.so.qs.sc.maschine.ace.bp.rule.MaschineFlowBusLockRule;
import nc.bs.so.qs.sc.maschine.plugin.bpplugin.MaschinePluginPoint;
import nc.impl.pubapp.pattern.data.bill.template.UpdateBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.so.qs.sc.AggMaschineVO;
//import nc.vo.so.xlx.tranflow.AggTranFlowVO;

public class MaschineEnableBP {
	
	public MaschineEnableBP(){
		
	}
	
	public AggMaschineVO[] enable(AggMaschineVO[] bills,AggMaschineVO[] oldbills) {
		// �����޸�ģ��
		UpdateBPTemplate<AggMaschineVO> bp = new UpdateBPTemplate<AggMaschineVO>(MaschinePluginPoint.UPDATE);
		// ִ��ǰ����
		this.addBeforeRule(bp.getAroundProcesser());
		// ִ�к����
		this.addAfterRule(bp.getAroundProcesser());
		
		return bp.update(bills,oldbills);
	}

	private void addAfterRule(CompareAroundProcesser<AggMaschineVO> Processer) {
		// TODO �Զ����ɵķ������
		
		Processer.addAfterRule(new nc.bs.pubapp.pub.rule.FillUpdateDataRule());
		
	}

	private void addBeforeRule(CompareAroundProcesser<AggMaschineVO> Processer) {
		// TODO �Զ����ɵķ������
		
		
		
		Processer.addBeforeRule(new MaschineFlowBusLockRule());
		
		Processer.addBeforeRule(new BillCheckVOConsistence());
		
		Processer.addBeforeRule(new BillSetDefaultValueRule());
		
		BillVOSetValue bs=new BillVOSetValue();
		
		bs.setHeadField(new String[]{"mmstatus"});
		
		bs.setHeadValue(new String[]{"1"});
		
		Processer.addBeforeRule(bs);
		
	}
	
	

	

}
