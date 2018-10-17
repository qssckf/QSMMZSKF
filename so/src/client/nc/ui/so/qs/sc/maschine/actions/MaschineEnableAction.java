package nc.ui.so.qs.sc.maschine.actions;

import nc.bs.bd.service.ValueObjWithErrLog;
import nc.ui.bd.pub.actions.BDEnableAction;
//import nc.ui.so.xlx.tran.driver.service.DriverAppModelService;
import nc.ui.so.qs.sc.maschine.service.MaschineMaintainService;
import nc.ui.uif2.UIState;
import nc.vo.jcom.lang.StringUtil;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.pub.CircularlyAccessibleValueObject;

public class MaschineEnableAction extends BDEnableAction {
	
	
	private String StatusField=null;
	private String StatusValue=null;
	
	public String getStatusField() {
		return StatusField;
	}

	public void setStatusField(String statusField) {
		StatusField = statusField;
	}

	public String getStatusValue() {
		return StatusValue;
	}

	public void setStatusValue(String statusValue) {
		StatusValue = statusValue;
	}

	public MaschineEnableAction(){
		this.setStatusField("mstatus");
		this.setStatusValue("1");
	}
	
	@Override
	public Object doEnable(Object obj) throws Exception {
		// TODO 自动生成的方法存根
		ValueObjWithErrLog reVoErrLog = getService().enableMaschineVO(obj);
		return reVoErrLog.getVos()[0];
	}
	
	@Override
	protected boolean isActionEnable() {
		// TODO 自动生成的方法存根
		return (getModel().getUiState() == UIState.NOT_EDIT) && (this.getModel().getSelectedData() != null) && (isCurrentDataEnable());
	}

	@Override
	public boolean isCurrentDataEnable() {
		// TODO 自动生成的方法存根
		CircularlyAccessibleValueObject vo = (CircularlyAccessibleValueObject)getModel().getSelectedData();
		
		if(StringUtil.isEmpty(this.getStatusField())){
			this.setStatusField("enablestate");
		}
		
		return (vo.getAttributeValue(this.getStatusField()) != null) && ("0".equals(vo.getAttributeValue(this.getStatusField())) || "2".equals(vo.getAttributeValue(this.getStatusField())));
	}

	
	
	public MaschineMaintainService getService() {
		
		MaschineMaintainService service=(MaschineMaintainService)((BillManageModel)getModel()).getService();
		return service;
	}
	
	

}
