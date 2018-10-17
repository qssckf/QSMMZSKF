package nc.bs.so.shipmentsinfo.ace.bp;

import nc.bs.so.shipmentsinfo.plugin.bpplugin.ShipmentsInfoPluginPoint;
import nc.impl.pubapp.pattern.data.bill.template.DeleteBPTemplate;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.vo.so.qs.sc.AggShipmentsVO;

/**
 * ��׼����ɾ��BP
 */
public class AceShipmentsInfoDeleteBP {

	public void delete(AggShipmentsVO[] bills) {

		DeleteBPTemplate<AggShipmentsVO> bp = new DeleteBPTemplate<AggShipmentsVO>(ShipmentsInfoPluginPoint.DELETE);
     
		// ����ִ��ǰ����
		this.addBeforeRule(bp.getAroundProcesser());
		// ����ִ�к�ҵ�����
		this.addAfterRule(bp.getAroundProcesser());
		bp.delete(bills);
		}
	private void addBeforeRule(AroundProcesser<AggShipmentsVO> processer) {
		IRule<AggShipmentsVO> rule=null;
		rule = new nc.bs.pubapp.pub.rule.BillDeleteStatusCheckRule();
				   				   				    				   				   
		processer.addBeforeRule(rule);

	}
  /**
   * ɾ����ҵ�����
   * 
   * @param processer
   */
	private void addAfterRule(AroundProcesser<AggShipmentsVO> processer) {
		IRule<AggShipmentsVO> rule=null;
		rule = new nc.bs.pubapp.pub.rule.ReturnBillCodeRule();
		((nc.bs.pubapp.pub.rule.ReturnBillCodeRule)rule).setCbilltype("FQ01");
		((nc.bs.pubapp.pub.rule.ReturnBillCodeRule)rule).setCodeItem("vbillcode");
		((nc.bs.pubapp.pub.rule.ReturnBillCodeRule)rule).setGroupItem("pk_group");
		((nc.bs.pubapp.pub.rule.ReturnBillCodeRule)rule).setOrgItem("pk_org");
				    				   				   
		processer.addAfterRule(rule);		   				   
	}
}
