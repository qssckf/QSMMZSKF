package nc.ui.so.qs.mmplanbill.query;

import nc.itf.scmpub.reference.uap.setting.defaultdata.DefaultDataSettingAccessor;
import nc.ui.pubapp.uif2app.query2.IQueryConditionDLGInitializer;
import nc.ui.pubapp.uif2app.query2.QueryConditionDLGDelegator;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

public class PlanBillQryCondDLGInitializer implements IQueryConditionDLGInitializer{

	@Override
	public void initQueryConditionDLG(QueryConditionDLGDelegator dlgDelegator) {
		// TODO 自动生成的方法存根
		
		 setDefaultPk_org(dlgDelegator);
		 
		 
		
		
	}
	
	private void setDefaultPk_org(QueryConditionDLGDelegator dlgDelegator)
	{
		String defaultOrg = null;
		try {
			defaultOrg = DefaultDataSettingAccessor.getDefaultSaleOrg();
		}catch (Exception ex) {
			ExceptionUtils.wrappException(ex);
		}
		
		if ((defaultOrg != null) && (defaultOrg.trim().length() > 0)) {
			dlgDelegator.setDefaultValue("so_preorder_b.pk_org", defaultOrg);
		}
	}

}
