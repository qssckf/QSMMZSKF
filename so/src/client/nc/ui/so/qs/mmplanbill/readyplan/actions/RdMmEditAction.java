package nc.ui.so.qs.mmplanbill.readyplan.actions;

import nc.ui.pubapp.uif2app.actions.EditAction;
import nc.ui.so.qs.mmplanbill.readyplan.model.RdMmModel;

public class RdMmEditAction extends EditAction{

	@Override
	protected boolean isActionEnable() {
		// TODO �Զ����ɵķ������
		
		Boolean edit=((RdMmModel)this.getModel()).getEdit();
		
		return edit;
	}
	
	

}
