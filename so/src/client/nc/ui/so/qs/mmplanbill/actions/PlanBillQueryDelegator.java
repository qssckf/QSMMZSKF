package nc.ui.so.qs.mmplanbill.actions;

import nc.ui.querytemplate.QueryConditionDLG;
import nc.ui.uif2.actions.DefaultQueryDelegator;
import nc.ui.querytemplate.IQueryTemplateTotalVOProcessor;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.query.QueryConditionVO;
import nc.vo.pub.query.QueryTempletTotalVO;

public class PlanBillQueryDelegator extends DefaultQueryDelegator {

	@Override
	protected QueryConditionDLG createQueryDlg() {
		// TODO �Զ����ɵķ������
		
		
		QueryConditionDLG qcd = super.createQueryDlg();
		
		qcd.registerQueryTemplateTotalVOProceeor(new IQueryTemplateTotalVOProcessor(){

			@Override
			public void processQueryTempletTotalVO(QueryTempletTotalVO totalVO) {
				// TODO �Զ����ɵķ������
				
				QueryConditionVO[] vos = totalVO.getConditionVOs();
				
				for (QueryConditionVO vo : vos) {
					if ((vo.getFieldCode() != null) && (vo.getFieldCode().equals("pk_group"))) {
						vo.setValue(PlanBillQueryDelegator.this.getContext().getPk_group());
						vo.setIfImmobility(UFBoolean.TRUE);
					}
				}
				
			}
			
		});
		
		
		return super.createQueryDlg();
	}
	
	

}
