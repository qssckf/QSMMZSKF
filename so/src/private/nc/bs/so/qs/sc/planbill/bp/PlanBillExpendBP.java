package nc.bs.so.qs.sc.planbill.bp;

import java.util.Arrays;

import nc.bs.bd.bp.rule.NotNullValueRule;
import nc.bs.bd.bp.template.UpdateBPTemplate;
import nc.bs.so.qs.planbill.bp.rule.PlanBillExpendRule;
import nc.bs.so.qs.sc.plugin.PBPluginPoint;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.so.qs.sc.MmPlanBillVO;

public class PlanBillExpendBP {
	
	public PlanBillExpendBP(){};
	
	public MmPlanBillVO[] Expend(MmPlanBillVO[] updateVo,MmPlanBillVO[] oldVo){
		
		UpdateBPTemplate<MmPlanBillVO> bpt=new UpdateBPTemplate(PBPluginPoint.EXEC);
		
		addBeforeRule(bpt.getAroundProcesser());
		
		addAfterRule(bpt.getAroundProcesser());
		
		return bpt.update(updateVo, oldVo);
		
	}

	private void addAfterRule(CompareAroundProcesser<MmPlanBillVO> aroundProcesser) {
		// TODO �Զ����ɵķ������
		
		aroundProcesser.addBeforeRule(new PlanBillExpendRule());

		
	}

	private void addBeforeRule(CompareAroundProcesser<MmPlanBillVO> aroundProcesser) {
		// TODO �Զ����ɵķ������
		
		aroundProcesser.addBeforeRule(new NotNullValueRule(Arrays.asList(new String[] { "sfexand"})));

		
	}

}
