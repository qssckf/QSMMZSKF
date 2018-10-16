package nc.ui.so.qs.mmplanbill.process.actions;

import nc.ui.pubapp.uif2app.actions.EditAction;
import nc.ui.uif2.UIState;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.so.qs.sc.MmPlanBillVO;

public class PlanBillEditAction extends EditAction {

	@Override
	protected boolean isActionEnable() {
		// TODO �Զ����ɵķ������
		return (getModel().getUiState() == UIState.NOT_EDIT) && (this.getModel().getSelectedData() != null) && (isCurrentDataEnable());
	}

	private boolean isCurrentDataEnable() {
		// TODO �Զ����ɵķ������
		
		MmPlanBillVO vo = (MmPlanBillVO)getModel().getSelectedData();
		
		if(vo!=null){
			
			if(UFBoolean.TRUE.equals(vo.getSfexand())){
				return false;
			}else{
				return true;
			}
			
		}else{
			return false;
		}
		
	}
	
	

}
